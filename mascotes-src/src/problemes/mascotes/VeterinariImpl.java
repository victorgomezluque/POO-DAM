package problemes.mascotes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;

public class VeterinariImpl implements Veterinari {

	private String Nom;
	private String pendents;
	ArrayList<Mascota> mascotes = new ArrayList<Mascota>();
	ArrayList<Mascota> visitaMascota = new ArrayList<>();

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}

	public String getPendents() {
		return pendents;
	}

	public void setPendents(String pendents) {
		this.pendents = pendents;
	}

	@Override
	public int pendents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void visita(Mascota mascota) {
		visitaMascota.add(mascota);
	}

	@SuppressWarnings("unlikely-arg-type")
	@Override
	public Mascota atendre() {
		
		for (Iterator iterator = visitaMascota.iterator(); iterator.hasNext();) {
			Mascota mascota = (Mascota) iterator.next();
			iterator.remove();
			return mascota;
		}

		return null;
	}

	public VeterinariImpl(String nom) {
		super();
		Nom = nom;
	}

}
