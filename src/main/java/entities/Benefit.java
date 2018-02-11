package entities;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Component
public class Benefit {

	@NotNull
	private String benefitName;
	private int pricePercentage;
	
	public Benefit() {}
	
	public int modifyPrice(int price) {
		return pricePercentage * price / 100;
	}
	
}
