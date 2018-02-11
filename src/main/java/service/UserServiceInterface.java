package service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import entities.User;

@Service
public interface UserServiceInterface {

	void put(User user);
	void delete(User user);
	
	Collection<User> selectAll();
	Collection<User> selectByName(String username);
	
}
