package tn.Dari.services;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import tn.Dari.entities.User;
import tn.Dari.repository.RoleRepository;
import tn.Dari.repository.UserRepository;

@Service 
public class UserServiceImpl implements IUserService  {
	@Autowired
	UserRepository userRepository;
	@Autowired
	RoleRepository roleRepository;
	
	PasswordEncoder passwordEncoder;
	
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
		this.passwordEncoder = new BCryptPasswordEncoder();
		
	}
	
   @Override
	public User Add_User(User user) {
	   
	    String encodedPassword= this.passwordEncoder.encode(user.getPassword());
	    user.setPassword(encodedPassword);
	    return userRepository.save(user);
	}
   @Override
	public User Update_User(User user) {
		 return userRepository.save(user);
	}
   
   @Override
	public User findById(Long id) {
		User user= userRepository.findById(id).orElse(null);
		return user;
	}
   @Override
	public List<User>findAll() {
		return(List<User>)userRepository.findAll();
	}
   @Override
	public void deleteById(Long id) {
		userRepository.deleteById(id);
	}

 
	

	

}
