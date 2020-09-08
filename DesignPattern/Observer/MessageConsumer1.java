package Observer;

public class MessageConsumer1 implements Observer{

	@Override
	public void update(Message msg) {
			System.out.println("MessageConsumer1: "+msg.getContent());
	}

}
