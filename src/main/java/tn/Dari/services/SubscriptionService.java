package tn.Dari.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.Dari.entities.Subscription;
import tn.Dari.repository.SubscriptionRepository;

@Service
public class SubscriptionService implements ISubscriptionService{

	@Autowired
	SubscriptionRepository subscriptionRepository;
	
	@Override
	public List<Subscription> retrieveSubscription() {
		return (List<Subscription>) subscriptionRepository.findAll();
	}

	@Override
	public Subscription retrieveById(Long id) {
		return (Subscription) subscriptionRepository.findById(id).orElse(null);
	}

	@Override
	public Subscription saveSubscription(Subscription Sb) {
		return (Subscription) subscriptionRepository.save(Sb);
	}

	@Override
	public Subscription updateSubscription(Subscription Sb) {
		return (Subscription) subscriptionRepository.save(Sb);
	}

	@Override
	public void deleteSubscription(Long id) {
		subscriptionRepository.deleteById(id);		
	}

}
