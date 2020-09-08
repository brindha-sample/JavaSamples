import java.util.Date;

public class WorkerThread implements Runnable{

	private String command;
	
	public WorkerThread(String command){
		this.command=command;
	}
	
	@Override
	public void run() {

		System.out.println(Thread.currentThread().getName()+" Start time:"+new Date());	
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+" End time:"+new Date());
		
	}
	
	public String toString(){
		return this.command;
	}

	
}
