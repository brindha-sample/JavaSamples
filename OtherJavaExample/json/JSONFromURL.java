package json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONFromURL {

	public static void main(String[] args) {
		JSONParser parser = new JSONParser();
		try {
			URL url =new URL("");
			URLConnection con = url.openConnection();
			BufferedReader br= new BufferedReader(new InputStreamReader(con.getInputStream()));
			String input;
			while((input=br.readLine()) != null){
				JSONArray objects = (JSONArray) parser.parse(input);
				for(Object ob:objects){
					JSONObject jsonObj = (JSONObject)ob;
					jsonObj.get("");
				}
				
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(IOException ioe){
			ioe.printStackTrace();
		}catch(ParseException pe){
			pe.printStackTrace();
		}
		
		
		

	}

}
