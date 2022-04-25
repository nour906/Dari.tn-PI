package com.example.newD.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
public class Subscription implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSub;
    private String title;
    private float price;
    private String description ;
    private String urLImg ;



    @OneToMany(mappedBy = "subscription",cascade = CascadeType.ALL,orphanRemoval = true ,fetch = FetchType.EAGER)
    private List<Subscribe> subscribes ;



    public Subscription( String title, float price, String description) {

        this.title = title;
        this.price = price;
        this.description = description;

    }


    public Subscription() {

    }

    public Subscription(String title, float price, String description, List<Subscribe> subscribes, String urLImg) {
        this.title = title;
        this.price = price;
        this.description = description;
        this.subscribes = subscribes;
        this.urLImg = urLImg;
    }

    @JsonIgnore
    public List<Subscribe> getSubscribes() {
        return subscribes;
    }

    public void setSubscribes(List<Subscribe> subscribes) {
        this.subscribes = subscribes;
    }

    public int getIdSub() {
        return idSub;
    }

    public void setId_sub(int idSub) {
        this.idSub = idSub;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public void setIdSub(int idSub) {
        this.idSub = idSub;
    }


    public String getUrLImg() {
        return urLImg;
    }


    public void setUrLImg(String urLImg) {
        this.urLImg = urLImg;
    }


}
