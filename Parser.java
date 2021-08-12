package ie.gmit.dip;

import java.io.*;
import java.util.*;

/**
 * Implements the <code>Runnable</code> interface. Takes a file given by the 
 * user in the form of a String and parses it into a HashMap, where a key is 
 * created for each word in the file and a value is created for the frequency of 
 * occurrence of each word.
 * 
 * @author Martina Schwarz
 * @version 1.0
 */

public class Parser implements Runnable {
	private String file;
	private Map<Integer, Integer> map = new HashMap<>();
	
	/**
	 * The constructor is overloaded.
	 * 
	 * @param file the file given by the user
	 */

	public Parser(String file) {
			this.file = file;
		}
	/**
	 * Uses a <code>BufferedReader</code> to read a file given by the user and split it 
	 * into a String array. Loops through the array and creates a Map containing the 
	 * hashCode of each word, mapped to the frequency of its occurrence.
	 * 
	 * Checks for <code>FileNotFoundException</code> and if thrown, prints error and 
	 * exits.
	 * 
	 * @param file the file given by the user
	 * @return a Map containing the hashCode of each String in the file mapped to its frequency of occurrence
	 */

	private Map<Integer, Integer> parseFile(String file) {

		try {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			String line = null;

			//read the file line by line and split the text by commas and full stops
			//create a String array
			while ((line = br.readLine()) != null) {
				String[] lines = line.split("\\s+|,\\s*|\\.\\s*");
				
				for (String word : lines) {
					
					//get the hashCode for each word
					int hash = word.hashCode();
					int frequency = 1;
					
					//if the map already contains a hashCode, add 1 to the existing value for frequency
					if (map.containsKey(hash)) {
						frequency += map.get(hash);
					}
					//add the hashCode and the frequency to the map
					map.put(hash, frequency);
				}
			}
			br.close();	
		} catch (FileNotFoundException e) {
			System.out.println("[ERROR] " + file + " wasn't found.");
			System.exit(0);
		} catch (IOException e) {
			e.getMessage();
		}
		return map;
	}
	
	/**
	 * Getter method, returns the Map created in the parseFile method.
	 * 
	 * @return a Map created in <i>parseFile</i>
	 */

	public Map<Integer, Integer> getMap() {
		return map;
	}
	
	/**
	 * Overrides run method of <code>Runnable</code> interface. Calls parseFile 
	 * method.
	 */

	@Override
	public void run()  {
		parseFile(file);
	}
}
