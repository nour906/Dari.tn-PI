package tn.Dari.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.Dari.entities.Payment;
import tn.Dari.repository.PaymentRepository;

import java.util.List;



@Service
public class PaymentService implements IPaymentService {
    @Autowired
    PaymentRepository PaymentRepository;


    @Override
    public List<Payment> retrievePayment() {
        return (List<Payment>) PaymentRepository.findAll();
    }

    @Override
    public Payment retrieveById(Long id) {
        return (Payment) PaymentRepository.findById(id).orElse(null);
    }

    @Override
    public Payment savePayment(Payment p) {
        return (Payment) PaymentRepository.save(p);
    }

    @Override
    public Payment updatePayment(Payment p) {
        return (Payment) PaymentRepository.save(p);
    }

    @Override
    public void deletePayment(Long id) {
        PaymentRepository.deleteById(id);

    }
}
