package tn.Dari.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.Dari.entities.Payment;
import tn.Dari.services.IPaymentService;

import java.util.List;


@RestController
@RequestMapping
public class PaymentController  {

    @Autowired
    IPaymentService paymentservice;

    @GetMapping("/Show_detail_payment")
    @ResponseBody
    List<Payment> afficherPayment(){
        return paymentservice.retrievePayment();
    }


    @GetMapping("/show_payment/{id}")
    @ResponseBody
    Payment afficherPayment(@PathVariable("id")Long id) {
        return paymentservice.retrieveById(id);
    }


    @PostMapping("/add_payment")
    @ResponseBody
    Payment ajouterPayment(@RequestBody Payment p) {
        return paymentservice.savePayment(p);
    }

    @PutMapping("/update_payment")
    @ResponseBody
    Payment updateAnnouncement(@RequestBody Payment p){
        return paymentservice.updatePayment(p);
    }

    @DeleteMapping("/delete_payment/{id}")
    @ResponseBody
    void deletePayment(@PathVariable("id") Long id) {
        paymentservice.deletePayment(id);
    }


}
