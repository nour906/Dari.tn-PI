package tn.Dari.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.Dari.entities.Visit;
import tn.Dari.entities.Announcement;
import tn.Dari.entities.User;
import tn.Dari.entities.Type;

import tn.Dari.repository.AnnouncementRepository;
import tn.Dari.repository.VisitRepository;
import tn.Dari.repository.UserRepository;






@Slf4j
@Service
public class VisitService implements IVisitService{
	
	@Autowired
	VisitRepository visitRepository;

	@Autowired
	AnnouncementRepository announcementRepository;

	@Autowired
	UserRepository userRepository;

	@Override
	public void addVisitAndAssignAnnAndUser(Visit vst, Long id_an, Long user_id) {
		Announcement announcement = announcementRepository.findById(id_an).orElse(null);
		User user = userRepository.findById(user_id).orElse(null);
		vst.setAnnouncement(announcement);
		vst.setUser(user);
		visitRepository.save(vst);
	}
	@Override
	public List<Visit> getVisitByAnnouncementAndType(Long id_an,  Type type) {
		return visitRepository.findByAnnouncementIdAnnouncementAndAnnouncementType(id_an, type);
	}

	@Override
	public int getNbrVisitAnnouncement(Long id_an) {
		return visitRepository.findByAnnouncementIdAnnouncement(id_an).size();
	}

	@Scheduled(cron = "* */15 * * * *")
	public void retriveVisite() {
		List<Visit> vsts = visitRepository.findAll();
		for (Visit Visit : vsts) {
			if (Visit.getDateVisit().after(new Date()))
				log.info("La liste des Visites : " + Visit.getDateVisit() + " : Announcement :"
						+ Visit.getAnnouncement().getId_an()+Visit.getAnnouncement().getCity() + " : User :"
						+ Visit.getUser().getLast_name()+ Visit.getUser().getFirst_name());
		}
	}
	

}

