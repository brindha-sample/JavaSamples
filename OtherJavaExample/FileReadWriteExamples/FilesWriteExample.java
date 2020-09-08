package FileReaExamples;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilesWriteExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			String fileName= "newFile1";
			Path path=Paths.get(fileName);
			System.out.println(Files.exists(path));
			System.out.println("creating new file");
			Files.createFile(path);
			String text="Entered text...";
			Files.write(path, text.getBytes());
			System.out.println(new String(Files.readAllBytes(path)));
			System.out.println(path.toAbsolutePath());
		}catch(IOException e){
			e.printStackTrace();
		}
	}

}
