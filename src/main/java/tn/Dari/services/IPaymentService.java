package tn.Dari.services;

import java.util.List;

import tn.Dari.entities.Payment;


public interface IPaymentService {

    List<Payment> retrievePayment();
    Payment retrieveById(Long id);
    Payment savePayment(Payment p);
    Payment updatePayment(Payment p);
    void deletePayment(Long id);

}
