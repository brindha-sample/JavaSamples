package flyWeight;

public class ScooterRider implements TwoWheeler {

	private String type ="Scooter";
	private int speed=0;
	
	public ScooterRider(int speed){
		this.speed=speed;
	}
	@Override
	public void ride() {
		// TODO Auto-generated method stub
		System.out.println("Riding "+type+" of speed "+speed);
	}

}
