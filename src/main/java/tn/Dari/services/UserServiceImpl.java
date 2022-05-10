package tn.Dari.services;






import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import tn.Dari.entities.User;
import tn.Dari.registration.token.ConfirmationToken;
import tn.Dari.registration.token.ConfirmationTokenService;
import tn.Dari.repository.UserRepository;





@Service 
@AllArgsConstructor
public class UserServiceImpl implements IUserService ,UserDetailsService  {
	
	private UserRepository userRepository;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	private final static String USER_NOT_FOUND_MSG = "User with email %s not found";
	private final ConfirmationTokenService confirmationTokenService;
	/*@ValidPassword
	PasswordEncoder passwordEncoder;
	
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
		this.passwordEncoder = new BCryptPasswordEncoder();
		
	}*/
	
	// Registration Part
	
  /* @Override
	public User Register_User(User user) throws EmailExistsException{
	   if (emailExist(user.getEmail())) {
	        throw new EmailExistsException("There is an account with that email adress: " + user.getEmail());
	    }
     
	    String encodedPassword= this.passwordEncoder.encode(user.getPassword());
	    user.setPassword(encodedPassword);
	   
	    return userRepository.save(user) ;
	}
   
     public boolean emailExist(String email) {
       return userRepository.findByEmail(email) != null;
   }*/
     
     //Updating user_information
   @Override
	public User Update_User(User user) {
	   return userRepository.save(user);
	}
   
   //Finding a user by it's ID
 @Override
	public User findById(Long id) {
		User user= userRepository.findById(id).orElse(null);
		return user;
	}
   // Showing all users
 @Override
	public List<User>findAll() {
		return(List<User>)userRepository.findAll();
	}
   
   //Removing a user
   @Override
	public void deleteById(Long id) {
		userRepository.deleteById(id);
	}

 
	
	
	
	
	///////////////LA partie registration
   @Override
public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

	return userRepository.findByEmail(email).orElseThrow(()-> new UsernameNotFoundException(String.format("USER_NOT_FOUND_MSG , email")));
}

public String signUpUser(User user){
	boolean userExists = userRepository.findByEmail(user.getEmail())
			.isPresent();
	if (userExists){
		throw new IllegalStateException("email already taken");
	}
	
String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
user.setPassword(encodedPassword);
userRepository.save(user);
// send confirmation token
 String token= UUID.randomUUID().toString();

 ConfirmationToken confirmationToken = new ConfirmationToken(
		 token,
		 LocalDateTime.now(),
		 LocalDateTime.now().plusMinutes(60),
		 user
		  );
  confirmationTokenService.saveConfirmationToken(confirmationToken);
  
  //TODO: sending email
 return token;
	}
public int enableUser(String email) {
    return userRepository.enableUser(email);
}


   
	

	

}
