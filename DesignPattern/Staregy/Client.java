package Staregy;

public class Client {

	/*
	 * Choose implementation on runtime out of multiple implementations that task has.
	 * Colletion.sort()  - Open Closed Principle
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Item i1=new Item("aaa",1.0);
		Item i2=new Item("aaa",1.0);
		Item i3=new Item("aaa",2.0);
		Item i4=new Item("aaa",2.0);
		
		ShoppingCart cart= new ShoppingCart();
		
		cart.addItem(i1);
		cart.addItem(i2);
		cart.pay(new CreditCardStaregy());
		
		ShoppingCart cart1= new ShoppingCart();
		cart1.addItem(i3);
		cart1.addItem(i4);
		cart1.pay(new WalletStaregy());
		
	}

}
