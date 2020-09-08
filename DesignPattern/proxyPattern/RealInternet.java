package proxyPattern;

public class RealInternet implements Internet{

	@Override
	public void connect(String hostname) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Connected to host "+hostname);
	}

}
