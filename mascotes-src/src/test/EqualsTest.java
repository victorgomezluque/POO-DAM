package test;

import java.util.Objects;

public class EqualsTest {
	
	public static void main(String[] args) {
		
		Persona p1 = new Persona(100L, "Anna");
		Persona p2 = new Persona(101L, "Maria");
		Persona p3 = new Persona(100L, "Anna");
		Persona p4 = p1;
		
		compara(p1, p2);
		compara(p1, p3);
		compara(p1, p4);
		
		BonaPersona bp1 = new BonaPersona(100L, "Anna");
		BonaPersona bp2 = new BonaPersona(101L, "Maria");
		BonaPersona bp3 = new BonaPersona(100L, "Anna");
		BonaPersona bp4 = bp1;
		
		compara(bp1, bp2);
		compara(bp1, bp3);
		compara(bp1, bp4);
	}

	static void compara(Object o1, Object o2) {
		System.out.print(hashInfo(o1) + " vs "  +  hashInfo(o2) + ": "); 
		System.out.println(o1.equals(o2)? "IGUALS" : "DIFERENTS");
	}
	
	static String hashInfo(Object o) {
		return o.getClass().getSimpleName() + 
				"@" + Integer.toHexString(o.hashCode()) + 
				o.toString();
	}
	
	/*
	 * aquesta classe hereta equals() i hashCode()
	 */
	
	static class Persona {
		protected Long id;
		protected String nom;
		
		public Persona(Long id, String nom) {
			this.id = id;
			this.nom = nom;
		}
		
		@Override
		public String toString() {
			return "{" + id + "," + nom + "}";
		}
	}
	
	/*
	 * contracte hashCode():
	 * 
	 * consistència interna: el valor de hashCode() només pot canviar si una propietat a equals() canvia
	 * consistència equals: els objectes que són iguals han de retornar el mateix hashCode
	 * col.lisions: els objects que no són iguals poden tenir el mateix hashCode
	 * 
	 */
	
	static class BonaPersona extends Persona {
		
		public BonaPersona(Long id, String nom) {
			super(id, nom);
		}
		
		@Override
		public boolean equals(Object o) {			
			if (o == this)
		        return true;
		    if (!(o instanceof BonaPersona))
		        return false;
		    
		    BonaPersona bp = (BonaPersona) o;
		    
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
	}
}
