package decoratorPattern;

public class BaseIcecream implements Icecream {

	protected Icecream ice;
	@Override
	public String makeIceCream() {
		// TODO Auto-generated method stub
		return "Base Ice Cream";
	}

}
