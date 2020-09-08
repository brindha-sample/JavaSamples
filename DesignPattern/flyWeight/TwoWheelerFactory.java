package flyWeight;

import java.util.HashMap;

public class TwoWheelerFactory {
	
	private static TwoWheeler bike;
	private static TwoWheeler scooter;
	private static final HashMap<String, TwoWheeler> twMap = new HashMap<>();
	
	public static TwoWheeler getBike(int speed){
		bike=twMap.get("bike"+speed);
		if(bike==null) {
			bike=new BikeRider(speed);
			twMap.put("bike"+speed, bike);
		}
		return bike;
	}
	
	public static TwoWheeler getScooter(int speed){
		scooter=twMap.get("scooter"+speed);
		if(scooter==null) {
			scooter=new ScooterRider(speed);
			twMap.put("scooter"+speed, scooter);
		}
		return scooter;
	}

}
