package tn.Dari.services;

import java.util.Date;
import java.util.List;

import tn.Dari.entities.Visit;

public interface VisiteService {

	
	
	//public void addVisitAndAssignAnnAndUser(Visit vst, Long id_an, Long user_id);

	//public List<Visit> getVisitByAnnouncementAndType(Long id_an,  Type type);


//	public int getNbrVisitAnnouncement(Long id_an);
	//public void retriveVisite();

	Visit saveVisite(Visit Vi);
	List<Visit> retrieveVisite();
	//Visit saveVisit(Visit Vi,  Long idAnnouncement);
	Visit findVisiteById(Long idVisit);	
	Visit updateVisit(Visit Vi);

	void deleteVisit(Long idVisit);

	List<Visit> retrieveAll();
	//List<Visit> findByDateCreationBetween(Date d1, Date d2);
	
	//void assignVisitToAnnounce(Long idVisite, Long idAnnouncement);
	
	
	
	
	
	

	
	
	
}
