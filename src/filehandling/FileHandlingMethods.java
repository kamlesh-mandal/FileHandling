package filehandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileHandlingMethods {

	private File myFile;
	
	public File getFile() {
		return myFile;
	}
	
	public File createFile (String fileName) {
		try {
			myFile = new File(fileName);
			if(myFile.exists()) {
				System.out.println(fileName + " already exists");
				return (myFile);
			}
			myFile.createNewFile();
			System.out.println(fileName + " created");
		} 
		catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return myFile;
	}
	
	public boolean DeleteFileIfExists (String fileName) {
		boolean status = false;
		try {
			myFile = new File(fileName);
			if(myFile.exists()) {
				status = myFile.delete();
				if (status == true) {
					System.out.println("Deleted");
				}
				else {
					System.out.println("Delete was not performed.");	
				}
				return status;
				
			}
		}
		catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return status;
	}
	
	public boolean writeFile (String text) {
		
		FileWriter writer = null;
		try {
			writer = new FileWriter(myFile);
			writer.write(text);
			return true;
		}
		catch(IOException ioe) {
			System.err.println("Failed to write to file.");
		}
		catch (NullPointerException npe) {
			System.err.println("File does not exist.");
		}
		finally{
			try {
				if (writer != null) {
					writer.flush();
					writer.close();
				}
			}
			catch (IOException ioex){
				ioex.printStackTrace();
			}
		}
		return false;
	}
	
	public void readFile (String fileName) {
		try {
		      myFile = new File(fileName);
		      Scanner myReader = new Scanner(myFile);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        System.out.println(data);
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	
	public void appendToFile(String text, String path) {
		FileWriter writer;
		PrintWriter pwriter;
		try {
			writer = new FileWriter(path, true);
			pwriter = new PrintWriter(writer);
			pwriter.println(text);
			pwriter.close();
		}
		catch (IOException e) {
			System.err.println("Error");
		}

	}
	
}