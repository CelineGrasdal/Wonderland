/**
 * title: TextFileReader.java
 * description: An constuctor that stores a text file line by line in array and displays text file all at
 * once in command line box.
 * date: August 17, 2022
 * @author Celine Grasdal
 * @version 1.0
 * AU ID: 3556933
 */
 
/**
 * DOCUMENTATION...
 */
 
/**
 * Celine Grasdal
 * AU ID: 3556933
 * August 17, 2022
 *
 * TextFileReader
 *
 * Purpose and Description
 *
 * A constructor that takes a text file input from TextFileReaderDemo and stores thefile line by line in array and displays text file all at 
 * once in command line box.
 *
 * This file uses Java and requires Java Version 17.0.2 or higher to run.
 *
 * Compiling and running instructions
 * Compile: javac TextFileReader.java
 */
 
 /**
  *
  * Classes
  *
  * public class TextFileReader
  * This is the main public class for this application
  *
  */
  
/**
 *
 * Test Plan
 *
 * 1. Call the consructor in TextFileReaderDemo
 * EXPECTED:
 *    TextFileReader object should be created as an array with the ability to call the function to display 
 *    all contents of text file.
 * 1. ACTUAL:
 *    TextFIleReader object is created as expected.
 *
 * 2. Good data cases:
 * EXPECTED:
 *    Place excerpt.txt in same folder as TextFileReaderDemo
 *    Run the following test by typing "java TextFileReaderDemo excerpt.txt" and pressing enter.
 *    Output should be display of entire text of excerpt.txt and display of each line and corresponding 
 *    number of each line of excerpt.txt
 * ACTUAL:
 *    Results displayed as expected.
 *    
 */ 
/**
 * CODE...
 */

/** Java packages to read file*/
import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;

/** Primary (public) class for TextFIleReader */
public class TextFileReader {
	
		/** Intialize and set default Array List */
	    String[] lineList;
	    
		/** Default constructor */
		public TextFileReader() {
			//Set default Array List to size 100
		    lineList = new String[100];
		}
		
		/** Method to accept input for file name and store file in array */
		public TextFileReader(String input) {
			// Method to create array and store file in array line by line
			lineList = new String[100];
			int i = 1;
				/** try-catch statement to catch invalid file names */
			    try {
					// Create file reader object
				    FileReader fr = new FileReader(input);
					// Create buffered reader object
					BufferedReader br = new BufferedReader(fr);
					// Create variable to store only one line of text file
					String line = br.readLine();
					/** Method to read file and store file in array line by line */
					while (line != null && i < lineList.length) {
				        lineList[i] = line;
						i++;
						line = br.readLine();
					}
					// Close buffered reader
					br.close();
				}
				/** Method to handle invalid file and display error messages */
				catch (FileNotFoundException e) {
				System.out.println("This file can't be found.");
				e.printStackTrace();
				}
				catch (IOException e) {
				e.printStackTrace();
				}
		}		

	/** Method to combine array in order to print off all elements of array at once*/
	public String contents() {
		StringBuffer sb = new StringBuffer();
		for (int i = 1; i < lineList.length; i++) {
			if (lineList[i] == null)
				break;
			sb.append(lineList[i]);
		}
		String str = sb.toString();
		return str;
	}
	
	/** Method to print array line by line with corresponding line number */
	public void display() {
		for (int i = 1; i < lineList.length; i++) {
			if (lineList[i] == null)
				break;
			System.out.println("line " + (i) + " " + lineList[i]);
		}
	}
} // end of class TextFileReader