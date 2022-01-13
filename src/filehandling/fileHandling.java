package filehandling;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class fileHandling {
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		String fileName = "text.txt";
		//helps find path to text files, needed for appending method
		Path path = FileSystems.getDefault().getPath(fileName).toAbsolutePath();
		System.out.println(path);
		
		
		
		FileHandlingMethods fileHandle = new FileHandlingMethods();
		fileHandle.DeleteFileIfExists("text.txt");
		System.out.println("Fresh start");
		System.out.println();
		
		File myFile = fileHandle.createFile("text.txt");
		
		fileHandle.writeFile("Hello World!");
		
		fileHandle.readFile("text.txt");
		
		System.out.println("End of test 1");
		System.out.println();
		
		fileHandle.appendToFile("\nHello World to you too!", path.toString());
		
		fileHandle.readFile("text.txt");
		
		System.out.println("End of test 2");
		System.out.println();
		
		fileHandle.appendToFile("End of test. Have a nice day.", path.toString());
		
		fileHandle.readFile("text.txt");
		
		System.out.println("End of test 3");
	}
	
	
}

