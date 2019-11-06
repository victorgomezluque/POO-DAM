package test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.TreeSet;

public class SetsAndHashesTest {

	public static void main(String[] args) {
		
		PersonaFactory noComparablefactory = new PersonaNoComparableFactory();
		PersonaFactory comparableFactory = new PersonaComparableFactory();
		
		// ArrayList
		
		testCollection(new ArrayList<>(), noComparablefactory);
				
		// HashSet: set que utilitza hash per optimitzar l'accés
		
		testCollection(new HashSet<>(), noComparablefactory);
		
		// TreeSet: set ordenat que necessita implementar Comparable
		
		try {
			testCollection(new TreeSet<>(), noComparablefactory);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		testCollection(new TreeSet<>(), comparableFactory);
	}
	
	static void testCollection(Collection<Persona> col, PersonaFactory factory) {		
		
		System.out.println("====> " + col.getClass().getSimpleName() + 
				" amb " + factory.getClass().getSimpleName());
		
		List<Boolean> resultats = new ArrayList<>();
		
		resultats.add(col.add(factory.create(150L, "Joan")));
		resultats.add(col.add(factory.create(150L, "Joan")));
		resultats.add(col.add(factory.create(150L, "Maria")));
		resultats.add(col.add(factory.create(101L, "Joan")));
		resultats.add(col.add(factory.create(102L, "Maria")));
		
		Persona persona = factory.create(150L, "Joan");
		
		// contains implementat diferent a ArrayList, TreeSet i HashSet
		System.out.println("cerca: " + persona + ": " + col.contains(persona));
		
		System.out.println("resultats: " + resultats);
		System.out.println("contingut: " + col);
	}

	// CLASSES
	
	static class Persona {
		protected Long id;
		protected String nom;
		
		public Persona(Long id, String nom) {
			this.id = id;
			this.nom = nom;
		}
		
		@Override
		public boolean equals(Object o) {	
			
			if (o == this)
		        return true;
		    if (!(o instanceof Persona))
		        return false;
		    
		    Persona bp = (Persona) o;
		    
		    boolean idIgual = this.id == null? 
		    		bp.id == null : this.id.equals(bp.id);
		    boolean nomIgual = this.nom == null? 
		    		bp.nom == null : this.nom.equals(bp.nom);
		    
		    return idIgual && nomIgual;
		}
		
		@Override
		public int hashCode() {			
			return Objects.hash(id, nom);
		}			
		
		@Override
		public String toString() {
			return "{" + id + "," + nom + "}";
		}
	}	
	
	static class PersonaComparable extends Persona implements Comparable<PersonaComparable> {

		public PersonaComparable(Long id, String nom) {
			super(id, nom);
		}

		@Override
		public int compareTo(PersonaComparable pc) {
			return id.compareTo(pc.id);
		}
	}
	
	// FACTORIES
	
	interface PersonaFactory {
		Persona create(Long id, String nom);
	}
	
	static class PersonaNoComparableFactory implements PersonaFactory {
		
		public Persona create(Long id, String nom) {
			return new Persona(id, nom);
		}
	}
	
	static class PersonaComparableFactory implements PersonaFactory {
		
		public Persona create(Long id, String nom) {
			return new PersonaComparable(id, nom);
		}
	}
	
}
