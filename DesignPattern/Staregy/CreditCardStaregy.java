package Staregy;

import java.sql.Date;

public class CreditCardStaregy implements PaymentStaregy {

	int cardnumber;
	int cvv;
	Date expiryDate;
	public CreditCardStaregy(){
		this.cardnumber=cardnumber;
		this.cvv=cvv;
		this.expiryDate=expiryDate;
	}
	
	@Override
	public void pay(double amount) {
		System.out.println("Through CreditCardStaregy "+ amount);
	}

}
