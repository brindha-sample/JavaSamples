import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Deadlock {
	private Lock lock1 = new ReentrantLock();
	private Lock lock2 = new ReentrantLock();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Deadlock deadlock = new Deadlock();
		new Thread(deadlock::operation1).start();
		new Thread(deadlock::operation2).start();
	}
	
	public void operation1(){
		lock1.lock();
		System.out.println("operation1: Aquried lock1 waiting for lock2");
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lock2.lock();
		System.out.println("operation1: Aquried lock2 ");
		
		System.out.println("operation1: Executing operation... ");
		System.out.println("operation1: Releasing locks... ");
		lock2.unlock();
		lock1.unlock();
	}
	
	public void operation2(){
		lock2.lock();
		System.out.println("operation2: Aquried lock2 waiting for lock1");
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lock1.lock();
		System.out.println("operation2: Aquried lock1 ");
		
		System.out.println("operation2: Executing operation... ");
		System.out.println("operation2: Releasing locks... ");
		lock1.unlock();
		lock2.unlock();
	}

}
