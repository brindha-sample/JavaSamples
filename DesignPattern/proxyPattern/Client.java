package proxyPattern;

/*
 * Proxy means ‘in place of’, representing’ for the real class and it provides the
 * access to that object when required
 */

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Internet net=new ProxyInternet();
		try{
			net.connect("host4");
			net.connect("host1");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}

	}

}
