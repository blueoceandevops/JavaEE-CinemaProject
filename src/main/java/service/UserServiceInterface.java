package service;

import java.util.Collection;

import entities.User;

public interface UserServiceInterface {

	void put(User user);
	void delete(User user);
	
	Collection<User> selectAll();
	Collection<User> selectByName(String username);
	
}
