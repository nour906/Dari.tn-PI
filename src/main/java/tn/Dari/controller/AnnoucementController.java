package tn.Dari.controller;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.ui.Model;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.file.Paths;





import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tn.Dari.entities.Announcement;
import tn.Dari.entities.Image;
import tn.Dari.repository.AnnouncementRepository;
import tn.Dari.services.IAnnouncementService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController 
@RequestMapping("Announcementcontroller")
public class AnnoucementController {
	
	

	@Autowired
	IAnnouncementService announcementservice;
	@Autowired
	 AnnouncementRepository  announcementRepository;
	
	@GetMapping("/Announcements")
	@ResponseBody 
	List<Announcement> afficherAnnouncement(){
		return announcementservice.retrieveAnnouncement();
	}
	
	
	@GetMapping("/Announcements/{id}")
	@ResponseBody 
	Announcement afficherannouncement(@PathVariable("id")Long id_an) {
		return announcementservice.retrieveById(id_an);
	}
	
	
	@RequestMapping(value = "/Announcements", method = RequestMethod.POST)
	@ResponseBody
	
	Announcement ajouterAnnouncement(Announcement An,@RequestParam("file") MultipartFile file){
		return announcementservice.saveAnnouncement(An, file);
	}
	
	///////////////////////////////////////
/*
	@PostMapping("/Announcements")
	@ResponseBody
	Announcement ajouterAnnouncement(@RequestBody Announcement An){
		return (Announcement) announcementservice.saveAnnouncement(An);
	}
	*/
	

	
	///////////////////////////////////////
	
	
	@PutMapping("/Announcements/{id}")
	@ResponseBody
	public Announcement updateAnnouncement(@PathVariable("id")Long id_an,@RequestBody Announcement An){ 
		Announcement announcement = announcementRepository.getById(id_an);
		announcement.setDescription(An.getDescription());
		announcement.setCity(An.getCity());
		announcement.setAddress(An.getAddress());
		announcement.setGovernorate(An.getGovernorate());
		announcement.setPhone(An.getPhone());
		announcement.setPrice(An.getPrice());
		announcement.setDate(An.getDate());
		return announcementRepository.save(announcement);
		
	}
	
	@DeleteMapping("/Announcements/{id}")
	@ResponseBody
	void deleteAnnouncement(@PathVariable("id") Long id) {
		announcementservice.deleteAnnouncement(id);
	}
	

	
}
