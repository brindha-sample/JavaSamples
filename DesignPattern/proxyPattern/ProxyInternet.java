package proxyPattern;

import java.util.ArrayList;
import java.util.List;

public class ProxyInternet implements Internet{

	private static List<String> proxyLst=new ArrayList<String>();
	private RealInternet real = new RealInternet();
	static{
		proxyLst.add("host1");
		proxyLst.add("host2");
		proxyLst.add("host3");
	}
	@Override
	public void connect(String hostname) throws Exception{
		// TODO Auto-generated method stub
		if(proxyLst.contains(hostname)){
			throw new Exception("Not authorized to visit this host "+hostname);
		}
		real.connect(hostname);
	}

}
