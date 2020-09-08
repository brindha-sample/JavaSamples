package FileReaExamples;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BufferedReaderExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader buf = null;
		try{
			//examine, locate or manipulate file - Path
		Path file = Paths.get("C:\\Users\\Administrator\\workspace\\FirstProject\\src\\FileReaExamples\\Welcome.txt"); 
		InputStream input = Files.newInputStream(file);
		buf = new BufferedReader(new InputStreamReader(input));
		System.out.println(buf.readLine());
		}catch(Exception e){
			e.printStackTrace();
			//System.err.println(e.getMessage());
		}finally{
			try {
				buf.close();
			} catch (IOException ioe) {
				System.err.println(ioe.getMessage());
			}
		}

	}

}
