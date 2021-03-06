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

import tn.Dari.entities.User;
import tn.Dari.services.IUserService;



@RestController
@RequestMapping("/User")
public class UserController {
	@Autowired
	IUserService userservice;
	@GetMapping("/Users")
	List<User> showUsers(){
		return userservice.findAll();
		
	}
	
	@GetMapping("/User/{id}")
	@ResponseBody
	User ShowUSerById(@PathVariable Long iduser) {
		return userservice.findById(iduser);
	}
	
	// http://localhost:8089/SpringMVC/Users/Register
	@PostMapping("/Register")
	@ResponseBody
	User AddUSer(@RequestBody User user) {
		return userservice.Add_User(user);
	}
	
	@PutMapping("/UpdateUser")
	@ResponseBody
	User UpdateUser(@RequestBody User user) {
		return userservice.Update_User(user);
	}
	@DeleteMapping("/DeleteUser/{id}")
	@ResponseBody
	void deleteUser(Long iduser) {
		userservice.deleteById(iduser);
		
	}
	

}
