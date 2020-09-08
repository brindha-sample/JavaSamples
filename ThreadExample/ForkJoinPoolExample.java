import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinPoolExample extends RecursiveTask<Long> {

	long workload=0;
	
	public ForkJoinPoolExample(long workload){
		this.workload=workload;
	}
	
	@Override
	protected Long compute() {
		// TODO Auto-generated method stub
		if(workload>16){
			System.out.println("Splitting tasks");
			List<ForkJoinPoolExample> poolList =new ArrayList<ForkJoinPoolExample>();
			poolList=createSubTask();
			
			for(ForkJoinPoolExample e:poolList){
				e.fork();
			}
			
			long result=0;
			for(ForkJoinPoolExample e:poolList){
				result += e.join();
			}
			
			return result;
		}else{
			System.out.println("Doing own work");
			return workload;
		}
	}
	
	public List<ForkJoinPoolExample> createSubTask(){
		List<ForkJoinPoolExample> poolList =new ArrayList<ForkJoinPoolExample>();
		
		ForkJoinPoolExample e1=new ForkJoinPoolExample(this.workload/2);
		ForkJoinPoolExample e2=new ForkJoinPoolExample(this.workload/2);
		
		poolList.add(e1);
		poolList.add(e2);
		
		return poolList;
	}
	
	public static void main(String args[]){
		long startTime=System.currentTimeMillis();
		ForkJoinPoolExample task = new ForkJoinPoolExample(128);
		ForkJoinPool forkJoinPool = new ForkJoinPool(2);
		long mergedResult=forkJoinPool.invoke(task);
		System.out.println(mergedResult);
		System.out.println(System.currentTimeMillis() - startTime +"ms to complete");
	}

}
