package tn.Dari.services;

import java.util.List;

import tn.Dari.entities.User;

//import java.util.List;

//import tn.Dari.entities.User;


public interface IUserService {


	//public User Register_User(User user)throws EmailExistsException;
	public List<User>findAll();
	public void deleteById(Long id);
	public User Update_User(User user) ;
	//public boolean emailExist(String email);
	User findById(Long id);
}
