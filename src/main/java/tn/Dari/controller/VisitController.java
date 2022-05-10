package tn.Dari.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.Dari.entities.Visit;
import tn.Dari.services.IVisitService;
import tn.Dari.entities.Type;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("visitcontroller")
public class VisitController {

	@Autowired IVisitService visitservice;
	
	
	@GetMapping("/test")
	public String test() {
		return "working fine ! " ; 
	}
	
	@PostMapping("/addVisitAndAssignAnnAndUser/{id_an}/{user_id}")
	public void addVisitAndAssignAnnAndUser(@RequestBody Visit vst, @PathVariable("id_an") Long id_an,
			@PathVariable("user_id") Long user_id) {
		visitservice.addVisitAndAssignAnnAndUser(vst, id_an, user_id);
	}

	@GetMapping("/getVisitByAnnouncementAndType/{id_an}/{type}")
	public List<Visit> getVisitByAnnouncementAndType(@PathVariable("id_an") Long id_an,
			@PathVariable("type") Type type) {
		return visitservice.getVisitByAnnouncementAndType(id_an, type);
	}

	@GetMapping("/getNbrVisitAnnouncement/{id_an}")
	public int getNbrVisitAnnouncement(@PathVariable("id_an") Long id_an) {
		return visitservice.getNbrVisitAnnouncement(id_an);
	}

		/*@GetMapping("/getRevenuAnnounce/{id_an}")
		public int getRevenuMedecin(@PathVariable("id_an") Long id_an,
				@RequestParam Date startDate,
				@RequestParam Date endDate) {
			return visitservice.getRevenuAnnounce(id_an, startDate, endDate);
		}
	}*/
}
