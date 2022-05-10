package tn.Dari.services;

import java.util.Date;
import java.util.List;



import tn.Dari.entities.Visit;
import tn.Dari.entities.Type;


public interface IVisitService {
	
	public void addVisitAndAssignAnnAndUser(Visit vst, Long id_an, Long user_id);

	public List<Visit> getVisitByAnnouncementAndType(Long id_an,  Type type);


	public int getNbrVisitAnnouncement(Long id_an);

}
