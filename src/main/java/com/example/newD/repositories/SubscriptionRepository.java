package com.example.newD.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.newD.entities.Subscription;

import java.util.List;

public interface SubscriptionRepository extends JpaRepository<Subscription, Integer> {

    List<Subscription> findSubscriptionByTitle(String Title);
}
