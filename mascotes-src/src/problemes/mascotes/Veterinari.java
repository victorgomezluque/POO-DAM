package problemes.mascotes;

public interface Veterinari {
	
	String getNom();
	int pendents();
	void visita(Mascota mascota);
	Mascota atendre();
	
}
