package problemes.mascotes;

import java.util.ArrayList;
import java.util.List;

public interface MascotesFactory {

	Hogar creaHogar(String nom);
	
	Veterinari creaVeterinari(String nom);
	
	Mascota registraGos(String nom, int any, Hogar hogar);
	
	Mascota registraGat(String nom, int any, Hogar hogar);
	
	Mascota trobaMascota(Long chipId);
	
	ArrayList<Mascota> llistaMascotes(Hogar hogar);
}
