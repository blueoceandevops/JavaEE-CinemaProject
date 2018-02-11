package cinema;

import java.sql.Date;
import java.sql.Time;

public class Ticket {

	private Movie movie;
	private Benefit benefit;
	
	private int rowNum;
	private int placeNum;
	private Date date;
	private Time time;
	private int price;
	private int uniqueCode;
	private boolean payStatus;
	
	public Ticket() {}
	
}
