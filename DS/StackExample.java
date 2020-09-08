package datastructure;

public class StackExample {

	//LIFO - array
	private int top;
	private int stackArray[];
	private int capacity;
	
	public StackExample(int capacity) {
		stackArray= new int[capacity];
		top=-1;
		this.capacity=capacity;
	}

	public void push(int value)
	{
		if(top==(capacity-1)){
			System.err.println("Stack overflow");
			System.exit(1);
		}
		System.out.println("Inserting into stack");
		stackArray[++top]=value;
	}
	
	public int pop(){
		if(top==-1){
			System.err.println("Stack is empty");
			System.exit(1);
		}
		return stackArray[top--];
	}

	public static void main(String[] args) {
		StackExample stack = new StackExample(5);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		//stack.push(6);
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}

}
