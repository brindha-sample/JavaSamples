package datastructure;

public class QueueExample {

	//FIFO - array
	private int frontPtr, rearPtr;
	private int[] queueArray;
	private int capacity;
	
	public QueueExample(int capacity){
		this.capacity=capacity;
		queueArray = new int[capacity];
		frontPtr = -1; 
		rearPtr = -1;
	}
	
	public void enqueue(int value){
		if(rearPtr==capacity-1){
			System.err.println("Queue is full");
		}else{
			if(frontPtr==-1)
				frontPtr=0;
			System.out.println("Enqueuing the value "+value);
			queueArray[++rearPtr]=value;
			
		}
	}
	
	public int dequeue(){
		if(frontPtr==-1){
			System.err.println("Queue is empty");
			return -1;
		}
		int value = queueArray[frontPtr];
		if(frontPtr>=rearPtr){
			rearPtr=-1;
			frontPtr=-1;
		}else{
			frontPtr++;
		}
		System.out.println("Dequeing the value "+value);
		return value;		
	}
	
	public static void main(String[] args) {

		QueueExample queue = new QueueExample(3);
		System.out.println(queue.dequeue());
		
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
	}

}
