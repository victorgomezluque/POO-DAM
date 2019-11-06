package problemes.mascotes;

public class hogarImpl implements Hogar{
	
	private String nom;

	@Override
	public String getNom() {
		// TODO Auto-generated method stub
		return nom;
	}

	public hogarImpl(String nom) {
		this.nom = nom;
	}
	
	@Override
	public String toString() {
		String nombre = nom; 
		
		return nombre;
	}


	
	
	

	
}
