package entities;

import java.util.Collection;

public class User {

	private String username;
	private String password;
	private String userMail;
	private Collection<Ticket> tickets;
	private boolean isAdmin;
	
	public User() {}
	
}
