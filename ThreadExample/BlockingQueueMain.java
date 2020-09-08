import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueueMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BlockingQueue1 queue = new BlockingQueue1();
		
		Thread p1= new Thread(new producer(queue));
		Thread c1= new Thread(new consumer(queue));
		
		p1.start();
		c1.start();
	}
}

class producer implements Runnable{

	BlockingQueue1 queue;
	
	public producer(BlockingQueue1 queue){
		this.queue=queue;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<10;i++){
			try {
				queue.enque(i);
				System.out.println("Added to queue:"+i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}

class consumer implements Runnable{

	BlockingQueue1 queue;
	
	public consumer(BlockingQueue1 queue){
		this.queue=queue;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<10;i++){
			try {
				System.out.println("Removed from queue:"+queue.deque());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}

