package Observer;

public class MessageConsumer2 implements Observer {

	@Override
	public void update(Message msg) {
		System.out.println("MessageConsumer2: "+ msg.getContent());
	}

}
