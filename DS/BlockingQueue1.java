package datastructure;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueue1 {



	final Lock lock = new ReentrantLock();
	final Condition isFull = lock.newCondition();
	final Condition isEmpty = lock.newCondition();
	
	final int[] queueArray=new int[6];
	int frontPtr, rearPtr = -1;
	
	public void enque(int element) throws InterruptedException{
		lock.lock();
		try{
			while(rearPtr==queueArray.length-1){
				isFull.await();
			}
			queueArray[++rearPtr]=element;
			if(frontPtr==-1) frontPtr=0;
			isEmpty.signal();
			
		}finally{
			lock.unlock();
		}
	}
	
	public int deque() throws InterruptedException{
		lock.lock();
		try{
			while(frontPtr==-1){
				isEmpty.await();
			}
			int result = queueArray[frontPtr];
			if(frontPtr >= rearPtr) {
				frontPtr=-1;
				rearPtr=-1;
			}else{
				frontPtr++;
			}
			isFull.signal();
			return result;
		}finally{
			lock.unlock();
		}
	}



}
