package Staregy;

public class WalletStaregy implements PaymentStaregy{

	String accName;
	int otp;
	
	public WalletStaregy(){
		this.accName=accName;
		this.otp=otp;
	}
	
	@Override
	public void pay(double amount) {
		System.out.println("Through WalletStaregy "+amount);
	}

}
