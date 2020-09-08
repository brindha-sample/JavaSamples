package Observer;

import java.util.List;

public interface Subject {
	
	public void attach(Observer obj);
	public void detach(Observer obj);
	public void notify(Message msg);

}
