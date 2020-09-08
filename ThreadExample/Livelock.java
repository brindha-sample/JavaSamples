import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Livelock {

	private Lock lock1 = new ReentrantLock();
	private Lock lock2 = new ReentrantLock();
	
	public static void main(String[] args) {
		Livelock example = new Livelock();
		new Thread(example::operation1).start();
		new Thread(example::operation2).start();
		

	}
	
	public void operation1(){
		lock1.lock();
		System.out.println("operation1: Acquired lock1 waiting for lock2");
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(lock2.tryLock())
			lock2.lock();
		else{
			System.out.println("operation1: Cannot aquire lock2, releasing lock1");
			lock1.unlock();
		}
		lock2.unlock();
		lock1.unlock();
			
	}
	
	public void operation2(){
		
	}

}
