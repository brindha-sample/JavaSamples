package Staregy;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

	List<Item> lst;
	
	public ShoppingCart(){
		lst=new ArrayList<Item>();
	}
	
	public void addItem(Item item){
		lst.add(item);
	}
	
	public void removeItem(Item item){
		lst.remove(item);
	}
	
	public double calculate(){
		double sum=0;
		sum = lst.stream().mapToDouble(Item::getPrice).sum();
		return sum;
	}
	
	public void pay(PaymentStaregy staregy){
		double amount = calculate();
		staregy.pay(amount);
	}
	
}
