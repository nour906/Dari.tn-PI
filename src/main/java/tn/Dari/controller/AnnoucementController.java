package tn.Dari.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.Dari.entities.Announcement;
import tn.Dari.services.IAnnouncementService;


@RestController 
@RequestMapping("Announcementcontroller")
public class AnnoucementController {

	
	@Autowired
	IAnnouncementService announcementservice;
	
	@GetMapping("/afficherDetailAnnouncement")
	@ResponseBody 
	List<Announcement> afficherAnnouncement(){
		return announcementservice.retrieveAnnouncement();
	}

	
	@GetMapping("/afficherAnnouncement/{id}")
	@ResponseBody 
	Announcement afficherannouncement(@PathVariable("id")Long id_an) {
		return announcementservice.retrieveById(id_an);
	}
	
	
	@PostMapping("/ajouterAnnouncement")
	@ResponseBody
	Announcement ajouterAnnouncement(@RequestBody Announcement An) {
		return announcementservice.saveAnnouncement(An);
	}
	
	@PutMapping("/updateAnnouncement")
	@ResponseBody
	Announcement updateAnnouncement(@RequestBody Announcement An){ 
		return announcementservice.updateAnnouncement(An);
	}
	
	@DeleteMapping("/deleteAnnouncement/{id}")
	@ResponseBody
	void deleteAnnouncement(@PathVariable("id") Long id) {
		announcementservice.deleteAnnouncement(id);
	}
	
	
}
