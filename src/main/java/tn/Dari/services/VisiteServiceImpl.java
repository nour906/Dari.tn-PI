package tn.Dari.services;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
//import tn.Dari.entities.Type;
import tn.Dari.entities.Visit;

import tn.Dari.entities.VisitType;
import tn.Dari.repository.AnnouncementRepository;
import tn.Dari.repository.VisiteRepository;


@Transactional
@Service
public class VisiteServiceImpl implements VisiteService{
	
	@Autowired
	VisiteRepository visitRepository;

	@Autowired
	AnnouncementRepository announcementRepository;
	
	//@Override
	//public Visit saveVisit(Visit Vi, Long idAnnouncement) {
	
		
	//	Vi.setAnnouncement(announcementRepository.getById(idAnnouncement));
	//	return (Visit) visitRepository.save(Vi);
	//}
	
	@Override
	public Visit saveVisite(Visit Vi) {
		return	visitRepository.save(Vi);
	}

		@Override
		public Visit updateVisit(Visit vi) {
			return visitRepository.save(vi);
		}
		@Override
		public void deleteVisit(Long idVisit) {
			Optional<Visit> visit = visitRepository.findById(idVisit);
				visitRepository.deleteById(idVisit);
			} 
		
		@Override
		public List<Visit> retrieveAll() {
			return visitRepository.findAll();
		}

		
		@Override
		public Visit findVisiteById(Long idVisit) {
			return (Visit) visitRepository.findById(idVisit).orElse(null);
		}
		
	//	@Override
	//	public int getNbrVisitAnnouncement(Long id_an) {
			//return visitRepository.findByAnnouncementIdAnnouncement(id_an).size();
	//	}
		//@Override
		//public void assignVisitToAnnounce(Long idVisite, Long idAnnouncement) {
		//	Visit Vi= visitRepository.findById(idVisite).orElse(null);
		//	Vi.setAnnouncement(announcementRepository.findById(idVisite).orElse(null));
		//	visitRepository.save(Vi);
			
	//	}
		
	//	@Override
	//	public List<Visit> findByDateCreationBetween(Date d1, Date d2) {
	//		return (List<Visit>)visitRepository.findByDateCreationBetween(d1,d2);
	//	}

		

		@Override
		public List<Visit> retrieveVisite() {
			return  (List<Visit>)  visitRepository.findAll();
		}

		

		

	
	/*
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

	

	//@Scheduled(cron = "* *15 * * * *") 
	public void retriveVisite() {
		List<Visit> vsts = visitRepository.findAll();
		for (Visit Visit : vsts) {
			if (Visit.getDate().after(new Date()))
				log.info("La liste des Visites : " + Visit.getDate() + " : Announcement :"
						+ Visit.getAnnouncement().getId_an()+Visit.getAnnouncement().getCity() + " : User :"
						+ Visit.getUser().getLast_name()+ Visit.getUser().getFirst_name());
		}
	}
	*/
	


	
	
}
