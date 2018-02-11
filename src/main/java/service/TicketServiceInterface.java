package service;

import java.sql.Date;
import java.util.Collection;

import entities.Movie;
import entities.Ticket;

public interface TicketServiceInterface {

	void put(Ticket ticket);
	void delete(Ticket ticket);

	Ticket selectBySeat(int row, int seat);
	
	Collection<Ticket> selectAll(Movie movie, Date date);
	Collection<Ticket> selectAvailable(Movie movie, Date date);
	Collection<Ticket> selectBooked(Movie movie, Date date);
	
}
