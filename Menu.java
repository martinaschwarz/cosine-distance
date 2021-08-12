package ie.gmit.dip;

import java.util.*;

/**
 * Provides a UI for the user to interact with the application.
 * 
 * @author Martina Schwarz
 * @version 1.0
 */

public class Menu {
	private Scanner s;
	private String subject;
	private String query;
	
	/**
	 * Asks the user to input the paths to two text files and passes them to the 
	 * cosineDistanceQuery method of the <code>Database</code> class.
	 */
	
	public void start() {
		
		//initialize the Scanner
		s = new Scanner(System.in);
		
		System.out.println("**************************");
		System.out.println("Cosine Distance Calculator");
		System.out.println("**************************");
		
		System.out.println();
		System.out.println("Enter path to Subject File >");
		
		//block and wait for user input and set subject to value entered by user
		subject = s.nextLine();
		
		System.out.println();
		System.out.println("Enter path to Query File >");
		
		//block and wait for user input and set query to value entered by user
		query = s.nextLine();
		
		System.out.println();
		System.out.println("Calculating.....");
		System.out.println();
		
		//call cosineDistanceQuery and pass in subject and query values
		new Database().cosineDistanceQuery(subject, query);
		
		//close the Scanner
		s.close();
	}
}
