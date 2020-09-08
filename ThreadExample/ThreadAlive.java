
public class ThreadAlive {
	public static void printMessage(String str){
		String threadName = Thread.currentThread().getName();
		System.out.println(threadName+" "+str);
	}
	
	private static class messageLoop implements Runnable{
		@Override
		public void run() {
			String[] strs={"a","b","c","d"};
			
			for(int i=0;i<strs.length;i++){
				try {
					Thread.sleep(4000);
					printMessage(strs[i]);
				} catch (InterruptedException e) {
					printMessage("Interrupted");
				}
			}
			
		}
		
	}
	
	public static void main(String[] args) {

		int patienceTime = 3000;
		long startTime= System.currentTimeMillis();
		try{
		printMessage("starting messageLoop");
		Thread thread = new Thread(new messageLoop());
		thread.start();
		printMessage("started");
		
		while(thread.isAlive()){
			printMessage("waiting");
			thread.join(1000);
			if((System.currentTimeMillis()-startTime) > patienceTime){
				printMessage("Tried of waiting");
				thread.interrupt();
				thread.join();
			}
		}
		printMessage("Completed");
		}
		catch(InterruptedException e){
			printMessage("Interrupted in main: "+e.getMessage());
		}
		
	}

}
