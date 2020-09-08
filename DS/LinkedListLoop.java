package datastructure;

public class LinkedListLoop {
	
	private Node head;
	
	private static class Node{
		private int value;
		private Node next;
		
		Node(int value){
			this.value=value;
		}
	}
	
	public void addToLast(Node n1){
		if(head == null){
			head = n1;
		}else{
			Node temp = head;
			while(temp.next!=null){
				temp=temp.next;
			}
			temp.next=n1;
		}
	}
	
	public void print(){
		Node temp=head;
		while(temp!=null){
			System.out.println(temp.value);
			temp=temp.next;
		}
		System.out.println();
	}
	
	public boolean ifLoopExit(){
		Node fastPointer = head;
		Node slowPointer = head;
		while(fastPointer != null && fastPointer.next != null){
			fastPointer=fastPointer.next.next;
			slowPointer=slowPointer.next;
			if(slowPointer == fastPointer){
				return true;
			}
		}
		return false;
	}

	public static void main(String args[]){
		LinkedListLoop lst=new LinkedListLoop();
		
		Node loopNode = new Node(7);
		lst.addToLast(new Node(5));
		lst.addToLast(new Node(3));
		lst.addToLast(loopNode);
		lst.addToLast(new Node(6));
		lst.addToLast(new Node(1));
		lst.addToLast(loopNode);
		
		//lst.print();
		System.out.println(lst.ifLoopExit());
	}
}
