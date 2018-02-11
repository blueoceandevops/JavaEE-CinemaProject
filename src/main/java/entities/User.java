package entities;

import java.util.Collection;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Component
public class User {
	
	@NotNull
	private String username;
	@NotNull
	private String password;
	@NotNull
	private String userMail;
	private Collection<Ticket> tickets;
	private boolean isAdmin;
	
	public User() {}
	
}
