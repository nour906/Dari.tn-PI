package com.example.newD.entities;



import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Entity
public class Subscribe implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_sub",  nullable = false)
    private Subscription subscription;


    private Date DateD;
    private Date DateF ;

    private boolean paid ;

    public Subscribe(Subscription subscription, Date dateD, Date dateF, Boolean paid) {
        this.subscription = subscription;
        this.DateD = dateD;
        this.DateF = dateF;
        this.paid = paid;
    }

    public Subscribe() {

    }


    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    public Date getDateD() {
        return DateD;
    }

    public void setDateD(Date dateD) {
        DateD = dateD;
    }

    public Date getDateF() {
        return DateF;
    }

    public void setDateF(Date dateF) {
        DateF = dateF;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
