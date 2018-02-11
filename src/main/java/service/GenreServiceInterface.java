package service;

import java.util.Collection;

import entities.Genre;

public interface GenreServiceInterface {

	void put(Genre genre);
	void delete(Genre genre);
	
	Collection<Genre> selectAll();
	Collection<Genre> selectByName(String name);
	
}
