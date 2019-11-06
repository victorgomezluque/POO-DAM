package problemes.mascotes.test;

import java.util.Collections;
import java.util.List;

import problemes.mascotes.Hogar;
import problemes.mascotes.Mascota;
import problemes.mascotes.MascotesFactory;
import problemes.mascotes.Veterinari;
import problemes.mascotes.impl.MascotesFactoryImpl;

public class MascotesTest {
	
	/* sortida esperada:
	 * 
	====> localitzat:
	Tom(2016) és un GAT amb chip 4 a Casa meva
	====> mascotes per any:
	[Garfield(2015) és un GAT amb chip 1 a Casa meva, Tom(2016) és un GAT amb chip 4 a Casa meva, Silvestre(2017) és un GAT amb chip 3 a Casa meva]
	====> veterinari:
	atenent Doraemon(2013) és un GAT amb chip 2 a Refugi
	atenent Silvestre(2017) és un GAT amb chip 3 a Casa meva
	atenent Garfield(2015) és un GAT amb chip 1 a Casa meva
	 *
	 */	
	
	public static void main(String[] args) {
		
		testFactory(new MascotesFactoryImpl());
	}

	public static void testFactory(MascotesFactory registre) {
		
		Hogar h1 = registre.creaHogar("Refugi");
		Hogar h2 = registre.creaHogar("Casa meva");
		
		Mascota garfield = registre.registraGat("Garfield", 2015, h2);
		Mascota doraemon = registre.registraGat("Doraemon", 2013, h1);
		Mascota silvestre = registre.registraGat("Silvestre", 2017, h2);
		Mascota tom = registre.registraGat("Tom", 2016, h2);
		
		Mascota tomTrobat = registre.trobaMascota(tom.getChip().getId());		
		System.out.println("====> localitzat:\n" + tomTrobat);
		
		Hogar h3 = registre.creaHogar("Casa meva");
		List<Mascota> mascotes = registre.llistaMascotes(h3);
		Collections.sort(mascotes);
		System.out.println("====> mascotes per any:\n" + mascotes);
		
		Veterinari v1 = registre.creaVeterinari("Vete");
		
		v1.visita(doraemon);
		v1.visita(silvestre);
		v1.visita(garfield);
		
		System.out.println("====> veterinari:");
		
		Mascota pacient;
		while ((pacient = v1.atendre()) != null) {
			System.out.println("atenent " + pacient);	
		}
	}
}
