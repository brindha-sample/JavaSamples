package flyWeight;

/*
 * Flyweight design pattern enables the use sharing of large numbers of objects 
 * that have part of their internal state common and other parts of state can vary.
 */
public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TwoWheeler bike = TwoWheelerFactory.getBike(100);
		bike.ride();
		
		TwoWheeler scooter = TwoWheelerFactory.getScooter(60);
		scooter.ride();
		
		TwoWheeler bike1 = TwoWheelerFactory.getBike(120);
		bike1.ride();
		
		TwoWheeler scooter1 = TwoWheelerFactory.getScooter(60);
		scooter1.ride();
		
		System.out.println(bike.hashCode());
		System.out.println(bike1.hashCode());
		
		System.out.println(scooter.hashCode());
		System.out.println(scooter1.hashCode());
	}

}
