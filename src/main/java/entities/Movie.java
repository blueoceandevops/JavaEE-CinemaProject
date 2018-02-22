package entities;

import java.sql.Date;
import java.sql.Time;
import java.util.Collection;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;
import java.net.URL;
@Component
public class Movie {
	
	private Collection<Genre> genre;
	
	@NotNull
	private String name;
	@NotNull
	private Time duration;
	@NotNull
	private Date startDate;
	@NotNull
	private Date endDate;
	private int ageRestriction;
	private URL trailerLink;
	private URL posterLink;
	
	public Movie() {}
	
}
