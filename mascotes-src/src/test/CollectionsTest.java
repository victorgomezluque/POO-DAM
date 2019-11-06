package test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CollectionsTest {

	public static void main(String[] args) {
		
		List<Integer> list1 = crearLlista1();
		List<Integer> list2 = crearLlista2();
		
		iterar1(list1);
		cercar(list1, 8);
		
		iterar2(list2);
		cercar(list2, null);
		
		List list3 = new ArrayList();
		list3.add("test");
		list3.add(1);		
		
		List<Object> list4 = new ArrayList<>();
		list4.add("test");
		list4.add(1);
		
		List<String> list5 = new ArrayList<>();
		list5.add("test");
		
		String test = list5.get(0);
		
		// list5.add(new Object()); // aquesta linea donaria error
		
		List list = new ArrayList();
		list.add("hello");
		String s = (String) list.get(0);
	}
	
	static void iterar1(List<Integer> list) {
		
		System.out.println("===> iterar1:");
		Iterator<Integer> iterator = list.iterator();

		while(iterator.hasNext()) {
		    Integer numero = iterator.next();
		    System.out.println(numero);
		}
	}
	
	static void iterar2(List<Integer> list) {
		
		System.out.println("===> iterar2:");

		for (Integer item: list) {
		    System.out.println(item);
		}
	}
	
	/**
	 * @param list
	 * @param valor
	 */
	static void cercar(List<Integer> list, Integer valor) {		
		
		System.out.println(valor + (list.contains(valor)? " trobat" : " NO trobat"));
	}
	
	// creació de llistes
	
	static List<Integer> crearLlista1() {
		
		List<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(8);
		list.add(3);
		list.add(5);
		
		return list;
	}
	
	static List<Integer> crearLlista2() {
		
		List<Integer> list = new LinkedList<>();
		list.add(null);
		list.add(1);
		
		return list;
	}
}
