package problemes.mascotes;

public class MascotaImpl implements Mascota {
	private Chip chip;
	private String Nom;
	private int any;
	private Especie especie;
	
	public Chip getChip() {
		return chip;
	}
	
	public String getNom() {
		return Nom;
	}
	
	public int getAny() {
		return any;
	}
	
	public Especie getEspecie() {
		return especie;
	}
	
	@Override
	public int compareTo(Mascota o) {
		// TODO Auto-generated method stub
		if(any>o.getAny()) {
			return 1;
		}else {
			if(any<o.getAny()) {
				return -1;
			}else {
				return 0;
			}
		}
				
	}


	public MascotaImpl(Chip chip, String nom, int any, Hogar hogar, Especie especie) {
		super();
		this.chip = chip;
		this.Nom = nom;
		this.any = any;
		this.especie = especie;
	}

	@Override
	public String toString() {
		return "MascotaImpl [chip=" + chip + ", Nom=" + Nom + ", any=" + any + ", especie=" + especie + "]";
	}
	
	
	
	
	
}
