package ie.gmit.dip;

import java.util.*;

/**
 * Adds records to a database in the form of HashMaps, which can then be queried by
 * calling the available methods to retrieve data.
 * 
 * In this case, the cosineDistancQuery method can be called to compare two
 * database records and calculate their similarity.
 * 
 * @author Martina Schwarz
 * @version 1.0
 */

public class Database {
	private Map<Integer, Integer> subject = new HashMap<>();
	private Map<Integer, Integer> query = new HashMap<>();
	
	/**
	 * Uses Threads to parse two files by calling <code>Parser</code> and adds two records 
	 * to the database in the form of two HashMaps, <i>subject</i> and <i>query</i>.
	 * 
	 * @param s the first file to parse and add to the database
	 * @param t the second file to parse and add to the database
	 */
	
	private void addDatabaseRecord(String s, String t) {
		
		Parser p1 = new Parser(s);		
		Parser p2 = new Parser(t);
		
		//start Parser in Thread 1 for String s
		Thread t1 = new Thread(p1);
		t1.start();
		
		//start Parser in Thread 2 for String t
		Thread t2 = new Thread(p2);
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		subject = p1.getMap();
		query = p2.getMap();
	}
	
	/**
	 * Takes two files given by the user, adds them to the database and then 
	 * queries the database to retrieve the cosine distance and the similarity 
	 * of the two files. 
	 * 
	 * Utilizes <code>Calculator</code> to carry out the major calculations.
	 * 
	 * @param s the first file passed in by the user in the Menu class
	 * @param t the second file passed in by the user in the Menu class
	 */
	
	public void cosineDistanceQuery(String s, String t) {
				
		//call addDatabaseRecord method to parse the files given by the user and retrieve a HashMap for each
		addDatabaseRecord(s, t);

		//get only the values from each Map
		Collection<Integer> sub_frequency = subject.values();
		Collection<Integer> que_frequency = query.values();
		
		//use Calculator method to calculate the magnitudes for both Maps
		float sub_magnitude = new Calculator().calculateMagnitude(sub_frequency);
		float que_magnitude = new Calculator().calculateMagnitude(que_frequency);
		
		//use Calculator method to combine the two Maps and calculate the dot product
		long dot_prod = new Calculator().calculateDotProduct(subject, query);
		
		//calculate the cosine distance based on all previous calculations
		float cosine_distance = (dot_prod / (sub_magnitude * que_magnitude));
		
		//print the result in the console
		System.out.println("The cosine distance between the two files is: " + cosine_distance);
		System.out.println();
		System.out.println("**************************");
		System.out.print("Similarity: ");
		System.out.format("%.2f", cosine_distance * 100);
		System.out.println("%");
		System.out.println("**************************");
	}
}
