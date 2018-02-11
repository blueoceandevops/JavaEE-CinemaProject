package entities;

import java.sql.Date;
import java.sql.Time;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Component
public class Ticket {

	@NotNull
	private Movie movie;
	@NotNull
	private Benefit benefit;
	
	private int rowNum;
	private int placeNum;
	@NotNull
	private Date date;
	@NotNull
	private Time time;
	private int price;
	private int uniqueCode;
	private boolean payStatus;
	
	public Ticket() {}
	
}
