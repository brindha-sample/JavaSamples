package Observer;

import java.util.ArrayList;
import java.util.List;

public class MessagPublisher implements Subject {

	List<Observer> lst= new ArrayList<Observer>();
	@Override
	public void attach(Observer obj) {
		lst.add(obj);
	}

	@Override
	public void detach(Observer obj) {
		lst.remove(obj);
	}

	@Override
	public void notify(Message msg) {
		for(Observer ob:lst){
			ob.update(msg);
		}
	}

}
