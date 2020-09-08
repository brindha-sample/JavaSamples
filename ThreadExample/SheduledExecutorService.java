import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SheduledExecutorService {

	public static void main(String[] args) throws InterruptedException{
		
		
		ScheduledExecutorService scheduledThreadPool=Executors.newScheduledThreadPool(5);
		System.out.println("Current time :: "+new Date());
		
		for(int i=0;i<=3;i++){
			WorkerThread wThread=new WorkerThread("work");
			scheduledThreadPool.schedule(wThread, 10, TimeUnit.SECONDS);
		}
		
		Thread.sleep(3000);
		scheduledThreadPool.shutdown();
		
		while(!scheduledThreadPool.isTerminated()){
			
		}
		System.out.println("Finished all tasks");
		
	}

}
