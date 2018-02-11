package service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import entities.Genre;

@Service
public interface GenreServiceInterface {

	void put(Genre genre);
	void delete(Genre genre);
	
	Collection<Genre> selectAll();
	Collection<Genre> selectByName(String name);
	
}
