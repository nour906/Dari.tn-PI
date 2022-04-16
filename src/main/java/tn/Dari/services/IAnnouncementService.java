package tn.Dari.services;

import java.util.List;

import tn.Dari.entities.Announcement;


public interface IAnnouncementService {

	List<Announcement> retrieveAnnouncement();	
	Announcement retrieveById(Long id);
	Announcement saveAnnouncement(Announcement An);
	Announcement updateAnnouncement(Announcement An);
	void deleteAnnouncement(Long id);
	
}
