import java.util.ArrayList;

public class espectador implements Esser {
	
	public String accio(Zoo zoo) {
		Animal animalico = zoo.mostraAnimal();
		
		if(animalico instanceof Vaca) {
			return "Espectador esta mirando un vaca";
		}else if(animalico instanceof cocodril) {
			return "Espectador esta mirando un cocodrilo";
		}else if(animalico == null) {
			return "Espectador no sabe donde mirar, porque no hay una mierda";
			
		}
		
		return null;
				
	}
	
	
}
