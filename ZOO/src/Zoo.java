import java.util.ArrayList;
import java.util.Random;

public class Zoo {
	
	ArrayList<Animal> animals;
	espectador Espectador = new espectador();

	Animal mostraAnimal() {
		Random rnd = new Random();
		int i = rnd.nextInt();
		Animal animalReturn = animals.get(i);
		if (animalReturn.equals("Vacas") || animalReturn.equals("cocodril")) {
			return animalReturn;
		} else {
			return null;
		}

	}

	void afegexiAnimal(String s) {

		switch (s) {
		case "Vaca":
			Vaca vaca = new Vaca();
			animals.add(vaca);
			break;
		case "cocodril":
			cocodril coco = new cocodril();
			animals.add(coco);
			break;
		}
	}
	
	

	void Surpimeixanimal(String s) {

		switch (s) {
		case "Vaca":
			Vaca vaca = new Vaca();
			animals.remove(vaca);
			break;
		case "cocodril":
			cocodril coco = new cocodril();
			animals.add(coco);
			break;
		}
		
		
		
	}
	
	
	
	void suprimeixAnimal(Animal a) {
		animals.remove(a);
	}
	
	
	void suprimeixTots(Animal a) {
		animals.removeAll(animals);
	}
	

	void mirar() {
		Random rnd = new Random();
		int i = rnd.nextInt(1);
		switch (i) {
		case 0:
			Espectador.accio(zoo);
			break;
		case 1:
			Animal a = mostraAnimal();
			a.accio(zoo);
			if(a.equals(null)){
				System.out.println("Vaya zoo, que no hay naaa");
			}
			
			break;

		}
	}
}
