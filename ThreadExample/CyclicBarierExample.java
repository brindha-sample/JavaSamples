import java.util.concurrent.CyclicBarrier;

public class CyclicBarierExample {

	public static void main(String[] args) {
		//CountDown & .countdown
		CyclicBarrier barrier = new CyclicBarrier(4);
		Sample s1 = new Sample(1000,barrier,"Thread1");
		Sample s2 = new Sample(1000,barrier,"Thread2");
		Sample s3 = new Sample(1000,barrier,"Thread3");
		Sample s4 = new Sample(1000,barrier,"Thread4");
		
		s1.start();
		s2.start();
		s3.start();
		s4.start();
		
		System.out.println(Thread.currentThread().getName()+" is over");

	}

}

class Sample extends Thread{
	private int duration;
	private CyclicBarrier barrier; 
	
	public Sample(int duration, CyclicBarrier barrier, String name) {
		super(name);
		this.duration = duration;
		this.barrier = barrier;
	};
	
	public void run(){
		try{
			Thread.sleep(duration);
			System.out.println(Thread.currentThread().getName()+" awaits");
			barrier.await();
			System.out.println(Thread.currentThread().getName()+" started");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
