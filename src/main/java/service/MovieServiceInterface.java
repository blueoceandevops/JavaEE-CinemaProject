package service;

import java.sql.Date;
import java.util.Collection;

import entities.Movie;

public interface MovieServiceInterface {

	void put(Movie movie);
	void delete(Movie movie);
	
	Collection<Movie> selectAll();
	Collection<Movie> selectAvailable();
	Collection<Movie> selectUnavailable();
	Collection<Movie> selectByName(String name);
	Collection<Movie> selectByDuration(int lowerDur, int upperDur);
	Collection<Movie> selectByRestriction(int lowerAge, int upperAge);
	Collection<Movie> selectByDate(Date lowerDate, Date upperDate);
	
	
	
}
