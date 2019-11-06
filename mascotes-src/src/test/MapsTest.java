package test;

import java.io.PrintStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MapsTest {

	public static void main(String[] args) {

		testMap();
		copiesTest();
		countFrequencies(); 
	}
	
	static void testMap() {
		
		System.out.println("====> testMap");
		
		Map<Integer, String> map = new HashMap<>();
		
		System.out.println(map.put(1, "dijous"));		
		System.out.println(map.put(1, "dijous"));		
		System.out.println(map.put(1, "divendres"));
		System.out.println(map.getOrDefault(2, "dimarts"));
		System.out.println(map.get(1));
		System.out.println(map.get(2));
	}
	
	static void copiesTest() {
		
		System.out.println("====> copiesTest");
		
		Map<Integer, Persona> map = new HashMap<>();
		map.put(1, new Persona("Paula"));
		map.put(2, new Persona("Andy"));
		System.out.println("original");
		printMapItems(map);
		
		shallowCopy(map);
		deepCopy(map);
		
		Map<Integer, Persona> unmodifiableCopy = unmodifiableCopy(map);
		
		try {
			unmodifiableCopy.put(9, new Persona("Impossible"));
		} catch (Exception e) {	
			e.printStackTrace(System.out);
		}
	}
	
	static void printMapItems(Map<Integer, Persona> map) {
		for (Integer key: map.keySet()) {
			Persona value = map.get(key);
			System.out.println("val " + value);
		} 
	}
	
	static Map<Integer, Persona> shallowCopy(Map<Integer, Persona> map) {
		
		Map<Integer, Persona> to = new HashMap<>(map);
		System.out.println("shallowCopy");
		printMapItems(to);
		return to;
	}
	
	static Map<Integer, Persona> deepCopy(Map<Integer, Persona> from) {
		
		Map<Integer, Persona> to = new HashMap<>();
		
		for (Entry<Integer, Persona> entry: from.entrySet()) {
			Integer key = new Integer(entry.getKey());
			Persona value = new Persona(entry.getValue().nom);
			
			to.put(key, value);
		}
		
		System.out.println("deepCopy");
		printMapItems(to);
		return to;
	}	
	
	static Map<Integer, Persona> unmodifiableCopy(Map<Integer, Persona> map) {
		return Collections.unmodifiableMap(map);
	}

	static void countFrequencies() {
		
		System.out.println("====> countFrequencies");
		
		int arr[] = { 10, 34, 5, 10, 3, 5, 10 }; 
		
		// Creates an empty HashMap
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		// Traverse through the given array
		for (int i = 0; i < arr.length; i++) {

			// Get if the element is present
			Integer c = map.get(arr[i]);

			// If this is first occurrence of element
			// Insert the element
			if (map.get(arr[i]) == null) {
				map.put(arr[i], 1);
			}

			// If elements already exists in hash map
			// Increment the count of element by 1
			else {
				map.put(arr[i], ++c);
			}
		}
		
		// find something
		
		int frequency = map.get(10);
		System.out.println("frequency for 10 is " + frequency);
		
		// iterate map
		
		for (Integer key: map.keySet()) {
			Integer value = map.get(key);
			// ...
		}
		
		for (Entry<Integer, Integer> entry: map.entrySet()) {
			Integer key = entry.getKey();
			Integer value = entry.getValue();
			// ...
		}

		// Print HashMap

		System.out.println("keys: " + map.keySet());
		System.out.println("values: " + map.values());
		System.out.println("entries: " + map.entrySet());		
		System.out.println("map: " + map);
	}
	
	// CLASSES
	
	static class Persona {
		public String nom;
		
		public Persona(String nom) {
			this.nom = nom;
		}
		
		@Override
		public String toString() {			
			return "{" + nom + "}@" + Integer.toHexString(hashCode());
		}
	}
}
