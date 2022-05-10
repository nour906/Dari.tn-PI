package tn.Dari.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

import tn.Dari.services.UserServiceImpl;

@RestController
@CrossOrigin(origins = "*")
@AllArgsConstructor

@RequestMapping(path="api/v1/registration")

public class RegistarationController {
	@Autowired
	UserServiceImpl userservice;

     private RegistrationService registrationService;

		@PostMapping
		@ResponseBody
		public String register( @RequestBody RegistrationRequest request){
			
			return registrationService.register(request);
		}
		 @GetMapping(path = "confirm")
		    public String confirm(@RequestParam("token") String token) {
		        return registrationService.confirmToken(token);
		}

}
