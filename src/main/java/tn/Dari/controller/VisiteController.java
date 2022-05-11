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

import tn.Dari.entities.VisitType;
import tn.Dari.entities.Visit;
import tn.Dari.repository.VisiteRepository;

import tn.Dari.services.VisiteService;



@CrossOrigin(origins = "http://localhost:4200")
@RestController 
@RequestMapping("Visitecontroller")
public class VisiteController {
	
	

	@Autowired
	VisiteService visiteservice;
	@Autowired
	VisiteRepository  visiterepository;
	//@RequestMapping(value = "/test", method = RequestMethod.GET)
	//@RequestMapping(value = "/test", method = { RequestMethod.GET, RequestMethod.POST })
	
	//@GetMapping("/test")
	//public String test() {
	//	return "working fine ! " ; 
	//}

	//@PostMapping("/ajouterVisite")
	//@ResponseBody
	//Visit ajouterStock(@RequestBody Visit Vi,@RequestBody Long idA) {
	//	return visiteservice.saveVisit(Vi,idA);
	//}
	
	@PostMapping("/visite")
	@ResponseBody
	Visit ajouterVisite(@RequestBody Visit Vi){
		return (Visit) visiteservice.saveVisite(Vi);
	}
	
	@GetMapping("/all-visite")
	@ResponseBody
	public List<Visit> getVisit() {
		return visiteservice.retrieveAll();
	}
	
	
	@PutMapping("/update-visite")
	public Visit updateVisit(@RequestBody Visit vi) {
		return visiteservice.updateVisit(vi);
	}
	@DeleteMapping("/delete-visite/{idVisit}")
	public void deleteVisit(@PathVariable("idVisit") Long id) {
		visiteservice.deleteVisit(id);
	}

	
//	@GetMapping("/getNbrVisitAnnouncement/{id_an}")
	//public int getNbrVisitAnnouncement(@PathVariable("id_an") Long id_an) {
	//	return visiteservice.getNbrVisitAnnouncement(id_an);
	//}
	
	@GetMapping("/afficherdetailVisites")
	@ResponseBody 
	List<Visit> afficherProduits(){
		return visiteservice.retrieveVisite();
	}
	
//	@PostMapping("/findVisiteByDate")
	//@ResponseBody
	//List<Visit> findByDateCreationBetween(@RequestBody Date d1,@RequestBody Date d2) {
	//	return visiteservice.findByDateCreationBetween(d1,d2);
	//}
	
	//@PostMapping("/assignVisitetoAnnouncement")
//	@ResponseBody
	//void assignVisitToAnnounce(@RequestBody Long idVisite,@RequestBody Long id_an) {
	//	visiteservice.assignVisitToAnnounce(idVisite, id_an);
	//}
	
	//@PostMapping("/addVisitAndAssignAnnAndUser/{id_an}/{user_id}")
	//public void addVisitAndAssignAnnAndUser(@RequestBody Visit vst, @PathVariable("id_an") Long id_an,
			//@PathVariable("user_id") Long user_id) {
		//visiteservice.addVisitAndAssignAnnAndUser(vst, id_an, user_id);
	//}

	//@GetMapping("/getVisitByAnnouncementAndType/{id_an}/{type}")
	//public List<Visit> getVisitByAnnouncementAndType(@PathVariable("id_an") Long id_an,
			//@PathVariable("type") Type type) {
		//return visiteservice.getVisitByAnnouncementAndType(id_an, type);
	//}

	
//}
		
}




	
	
	
	
	
