package cinema;

public class Benefit {

	private String benefitName;
	private int pricePercentage;
	
	public Benefit() {}
	
	public int modifyPrice(int price) {
		return pricePercentage * price / 100;
	}
	
}
