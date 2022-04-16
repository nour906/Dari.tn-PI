package tn.Dari.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.Dari.entities.Announcement;
import tn.Dari.repository.AnnouncementRepository;

@Service
public class AnnouncementService implements IAnnouncementService  {

	@Autowired
	 AnnouncementRepository  announcementRepository;
	
	@Override
	public List<Announcement> retrieveAnnouncement() {
		return (List<Announcement>) announcementRepository.findAll();
	}

	@Override
	public Announcement retrieveById(Long id) {
		return (Announcement) announcementRepository.findById(id).orElse(null);
	}

	@Override
	public Announcement saveAnnouncement(Announcement An) {
		return (Announcement) announcementRepository.save(An);
	}

	@Override
	public Announcement updateAnnouncement(Announcement An) {
		return (Announcement) announcementRepository.save(An);
	}

	@Override
	public void deleteAnnouncement(Long id) {
		announcementRepository.deleteById(id);
		
	}

	
	
}
