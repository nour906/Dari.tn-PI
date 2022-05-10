package tn.Dari.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import tn.Dari.entities.User;


import tn.Dari.services.IUserService;



@AllArgsConstructor
@RestController
@CrossOrigin(origins = "*")

public class UserController {
	@Autowired
	IUserService userservice;
	
	/*@Autowired
	RegistrationService registrationService;*/
	@GetMapping("/")
	public void login() {
		
	}
	@GetMapping("/api/v1/AllUsers")
	List<User> showUsers(){
		return userservice.findAll();
		
	}
	
	
	@GetMapping("/api/v1/FindUser/{id}")
	@ResponseBody
	User ShowUserById(@PathVariable("id") Long iduser) {
		return userservice.findById(iduser);
	}
	
	// http://localhost:8089/DariTn/Registration
	/*@PostMapping(path="/DariTn/Registration")
	@ResponseBody
	User AddUSer(@Valid @RequestBody User user) throws EmailExistsException {
		
		return userservice.Register_User(user);
	}*/
	
	@PutMapping("/api/v1/UpdateUser")
	@ResponseBody
	User UpdateUser(@RequestBody User user) {
		return userservice.Update_User(user);
	}
	@DeleteMapping("/api/v1/DeleteUser/{id}")
	@ResponseBody
	void deleteUser(Long iduser) {
		userservice.deleteById(iduser);
	}
}
	

