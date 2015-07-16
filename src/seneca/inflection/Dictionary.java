package seneca.inflection;

// Import io so we can use file objects
import java.io.*;
import java.util.Scanner;
import java.util.*;


public class Dictionary {
    public static ArrayList dictionary(String input){
        ArrayList output = new ArrayList(15);
        try {
            // Open the file c:\test.txt as a buffered reader
            BufferedReader bf = new BufferedReader(new FileReader("Seneca_Dictionary.txt"));
			
            // Start a line count and declare a string to hold our current line.
            int linecount = 0;
            String line;
            // Loop through each line, stashing the line into our line variable.
            while (( line = bf.readLine()) != null){
            // Increment the count and find the index of the word
    		linecount++;
                                
    		if(line.indexOf(input) > 0) {
                    if (line.matches(".*\\$(et|d).*\\b" + input + "\\b.*")) {
                        output.add(line);
                    }
                } 
                                
            }
            // Close the file after done searching
            
	} catch (IOException e) {
            System.out.println("IO Error Occurred: " + e.toString());
	}
        return output;
    }
    
    public static void main(String args[]) {
        Scanner word = new Scanner(System.in);
        System.out.println("Type the word you would like to find.");
        String input = word.next();
        ArrayList output = new ArrayList(15);
		try {
			// Open the file c:\test.txt as a buffered reader
			BufferedReader bf = new BufferedReader(new FileReader("Seneca_Dictionary.txt"));
			
			// Start a line count and declare a string to hold our current line.
			int linecount = 0;
    			String line;

			// Let the user know what we are searching for
			System.out.println("Searching for " + input + " in file...");
                        
			// Loop through each line, stashing the line into our line variable.
			while (( line = bf.readLine()) != null)
			{
    				// Increment the count and find the index of the word
    				linecount++;
                                
    				if(line.indexOf(input) > 0) {
                                    if (line.matches(".*\\$(et|d).*\\b" + input + "\\b.*")) {
                                        output.add(line);
                                    }
                                } 
                                
			}
			// Close the file after done searching
			bf.close();
                        for (int i = 0; i < output.size(); i++) {
                            System.out.println(output.get(i));
                        }
                        System.out.println("There are no more.");
		}
		catch (IOException e) {
			System.out.println("IO Error Occurred: " + e.toString());
		}
	}
}

