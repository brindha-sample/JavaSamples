import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueue {


	final Lock lock = new ReentrantLock();
	final Condition isFull = lock.newCondition();
	final Condition isEmpty = lock.newCondition();
	
	final int[] queueArray=new int[6];
	int frontPtr, rearPtr,count;
	
	public void enque(int element) throws InterruptedException{
		lock.lock();
		try{
			while(count==queueArray.length){
				isFull.await();
			}
			queueArray[rearPtr]=element;
			if(++rearPtr == queueArray.length) rearPtr=0;
			++count;
			isEmpty.signal();
			
		}finally{
			lock.unlock();
		}
	}
	
	public int deque() throws InterruptedException{
		lock.lock();
		try{
			while(count==frontPtr){
				isEmpty.await();
			}
			int result = queueArray[frontPtr];
			if(++frontPtr == queueArray.length) frontPtr=0;
			--count;
			isFull.signal();
			return result;
		}finally{
			lock.unlock();
		}
	}

}
