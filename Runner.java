package ie.gmit.dip;

/**
 * Contains the main method and starts the application by calling the start method 
 * of <code>Menu</code>.
 * 
 * @author Martina Schwarz
 * @version 1.0
 */

public class Runner {
	
	/**
	 * Starts the application by calling the start method of <code>Menu</code>.
	 * 
	 * @param args the command-line arguments
	 */
	
	public static void main(String[] args) {
		
		new Menu().start();
	}

}
