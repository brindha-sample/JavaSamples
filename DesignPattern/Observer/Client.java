package Observer;

public class Client {

	/*
	 * One to many dependancies between objects, when one object's state changes all its 
	 * dependancies are notified. Publish-subscribe pattern. eg:JMS
	 */
	public static void main(String[] args) {

		Message msg=new Message("Subject Content upated");
		
		MessageConsumer1 con1= new MessageConsumer1();
		MessageConsumer2 con2= new MessageConsumer2();
		
		MessagPublisher p=new MessagPublisher();
		
		p.attach(con1);
		p.attach(con2);
		
		p.notify(msg);
		
	}

}
