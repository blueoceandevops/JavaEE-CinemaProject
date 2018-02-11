package entities;

import java.sql.Date;
import java.sql.Time;
import java.util.Collection;

public class Movie {
	
	private Collection<Genre> genre;
	
	private String name;
	private Time duration;
	private Date startDate;
	private Date endDate;
	private int ageRestriction;
	private String trailerLink;
	private String posterLink;
	
	public Movie() {}
	
}
