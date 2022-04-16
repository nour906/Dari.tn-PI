package tn.Dari.services;

import java.util.List;

import tn.Dari.entities.Subscription;


public interface ISubscriptionService {

	
	List<Subscription> retrieveSubscription();	
	Subscription retrieveById(Long id);
	Subscription saveSubscription(Subscription Sb);
	Subscription updateSubscription(Subscription Sb);
	void deleteSubscription(Long id);
}
