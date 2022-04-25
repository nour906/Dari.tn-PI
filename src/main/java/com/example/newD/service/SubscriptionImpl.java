package com.example.newD.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.example.newD.repositories.SubscriptionRepository;
import com.example.newD.entities.Subscription;

import com.example.newD.entities.Subscribe;
import com.example.newD.repositories.SubscribeRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Service
public class SubscriptionImpl implements ISubscription {
    private static final Logger logger = LoggerFactory.getLogger(SubscriptionImpl.class);

    @Autowired
    SubscriptionRepository SubRep ;

    @Autowired
    SubscribeRepository subscribeRepository ;

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Subscription> AllSubs() {

        List<Subscription> subs = (List<Subscription>) SubRep.findAll();
        for(Subscription sub  : subs ){
            System.out.println("subscriptions    : " + sub);

        }
        return subs;
    }

    @Override
    public Optional<Subscription> getSub(int id) {
        return SubRep.findById(id);
    }

    @Override
    public List<Subscription> getSubT(String title) {

        return SubRep.findSubscriptionByTitle(title);
    }

    @Override
    public Subscription Add(Subscription S) {

        return SubRep.save(S);
    }


    @Override
    public Subscription Modify(Subscription S) {
        Subscription sub =SubRep.findById(S.getIdSub()).orElse(null);
        sub.setTitle(S.getTitle());
        sub.setPrice(S.getPrice());
        sub.setDescription(S.getDescription());
        return SubRep.save(sub);
    }

    @Override
    public void DeleteSub(int  id) {
        SubRep.deleteById(id);
    }

    @Override
    public Subscribe AddSubToo(int idS,Date dateD, Date dateF) {


        Subscribe s = new Subscribe();
        s.setDateD(new Date());
        s.setDateF(new Date());
        Subscription su = SubRep.findById(idS).get();
        s.setSubscription(su);
        s.setPaid(true);
        return subscribeRepository.save(s);
    }

    @Override
    public Subscribe EndAbo(int idS) {

        Subscribe subsc = subscribeRepository.findById(idS).orElse(null);
        logger.info("its here : {} ", subsc.getId());
        if(subsc.getDateF().compareTo(new Date())<0){
            subsc.setPaid(false);
        }
        return subsc ;
    }

    @Override
    public List<Subscribe> GetSubs() {
        List<Subscribe> subscribe = (List<Subscribe>) subscribeRepository.findAll();
        for(Subscribe sub  : subscribe ){
            System.out.println("List of subscribes    : " + sub);

        }
        return subscribe;

    }


    @Transactional
    public void insertWithQuery(Subscribe sub) {
        entityManager.createNativeQuery("INSERT INTO Subscribe (dated,datef,utilisateur_id,id_sub) VALUES (?,?,?,?)")
                .setParameter(1, sub.getDateD())
                .setParameter(2, sub.getDateF())
                .setParameter(3,sub.getSubscription().getIdSub())
                .executeUpdate();
    }


    //-----------------------------paiement-----------------------------------//

}
