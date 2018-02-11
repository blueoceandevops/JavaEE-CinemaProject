package entities;

import java.util.Collection;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Component
public class Genre {

	@NotNull
	private String name;
	private Collection<Movie> movies;
	
	public Genre() {}
}
