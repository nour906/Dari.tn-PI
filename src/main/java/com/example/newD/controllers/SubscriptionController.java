package com.example.newD.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import com.example.newD.entities.Subscribe;
import com.example.newD.entities.Subscription;
import com.example.newD.service.ISubscription;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory; 

@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/Subscription")
public class SubscriptionController {
    private static final Logger logger = LoggerFactory.getLogger(SubscriptionController .class);

    @Autowired
    ISubscription subscription;

    @GetMapping("/GetAll")
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(subscription.AllSubs(), HttpStatus.OK);


    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<?> getSub(@PathVariable  int id){

        return new ResponseEntity<>( subscription.getSub(id), HttpStatus.OK);
    }

    @GetMapping("/getSubByTitle/{title}")
    public ResponseEntity<?> SubByTitle(@PathVariable String title){

        return new ResponseEntity<>( subscription.getSubT(title), HttpStatus.OK);
    }

    @PostMapping("/addsub")
    @ResponseBody
    public ResponseEntity<?> Add(@RequestBody Subscription s){
        Subscription sub = subscription.Add(s);
        return new ResponseEntity<>( " Subscription added. ",  HttpStatus.OK);

    }
    @PostMapping("/addsubscribe")
    @ResponseBody
    public ResponseEntity<?> AddS(@RequestBody Subscribe s){
        logger.info("the subscription is : {} " , s.getSubscription().getIdSub());
        Subscribe su = subscription.AddSubToo(s.getSubscription().getIdSub(),s.getDateD(),s.getDateF());
        return new ResponseEntity<>("subscribe added too",HttpStatus.OK);

    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void DeleteSub(@PathVariable("id") int id){
        subscription.DeleteSub(id);
    }

    @PostMapping ("/Modify")
    @ResponseBody
    public Subscription modify(@RequestBody Subscription su){

        return subscription.Modify(su);
    }


    @GetMapping("/GetAllS")
    public ResponseEntity<?> getAllSubsribes(){
        return new ResponseEntity<>(subscription.GetSubs(),  HttpStatus.OK);


    }


    @GetMapping("/End/{idS}")
    public Subscribe End(@PathVariable int idS){
        return subscription.EndAbo(idS);
    }


}
