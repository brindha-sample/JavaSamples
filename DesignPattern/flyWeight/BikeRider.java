package flyWeight;

public class BikeRider implements TwoWheeler {

	private String type ="Bike";  //intrinsic - immutable
	private int speed=0;		  //extrinsic
	
	public BikeRider(int speed){
		this.speed=speed;
	}
	@Override
	public void ride() {
		// TODO Auto-generated method stub
		System.out.println("Riding "+type+" of speed "+speed);
	}

}
