package tn.Dari.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.Dari.entities.Announcement;
import tn.Dari.entities.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

}