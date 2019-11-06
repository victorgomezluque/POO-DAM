package problemes.mascotes;

public interface Mascota extends Comparable<Mascota> {
	
	Chip getChip();
	String getNom();
	int getAny();
	Especie getEspecie();
}
