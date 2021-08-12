package ie.gmit.dip;

import java.util.*;

/**
 * Contains methods that can be used to calculate certain values based on Maps
 * stored in <code>Database</code>.
 * 
 * @author Martina Schwarz
 * @version 1.0
 */

public class Calculator {
	
	/**
	 * Calculates the magnitude of a Collection of integers by adding up each squared 
	 * value and then calculating the square root.
	 * 
	 * @param c the Collection of integers
	 * @return a float representing the magnitude
	 */

	public float calculateMagnitude(Collection<Integer> c) {
		
		float f = 0;
		for (Integer val : c) {
			
			//square each value in the Collection and add them up
			f += (val * val);
		}
		//calculate the square root 
		return (float) Math.sqrt(f);
	}
	
	/**
	 * Calculates the dot product of two Maps by multiplying the integers stored in the  
	 * values for each key and adding the results.
	 * 
	 * @param m1 the subject Map
	 * @param m2 the query Map
	 * @return a long representing the dot product
	 */
	
	public long calculateDotProduct(Map<Integer, Integer> m1, Map<Integer, Integer> m2) {
		Map<Integer, Integer> temp = new HashMap<>();
		
		for (Integer key : m1.keySet()) {
			
			//multiply the values of both maps for each key
		    if (m2.containsKey(key)) {
		    	int value = m1.get(key) * m2.get(key);
		    	
		    	//populate a new map with the keys and calculated values
		    	temp.put(key, value);
		    }
		}
		
		//get only the values of the map
		Collection<Integer> c = temp.values();	
		long dot = 0;
		
		//add the values
		for (Integer val : c) {
			dot += val;
		}
		return dot;
	}
}
