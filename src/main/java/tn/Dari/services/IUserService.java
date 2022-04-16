package tn.Dari.services;

import java.util.List;

import tn.Dari.entities.User;

public interface IUserService {
	public User Add_User(User user);
	public User findById(Long id);
	public List<User>findAll();
	public void deleteById(Long id);
	public User Update_User(User user) ;
}
