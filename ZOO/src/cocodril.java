public class cocodril extends Animal{
	

	String mou(Zoo zoo) {
		String s = "Un cocodril neda estany amunt estany avall";
		return s;
	}

	
	String alimenta(Zoo zoo) {
		Animal c = zoo.mostraAnimal();
		
		if(c != null){
			if(c instanceof Vaca) {
			zoo.suprimeixAnimal(c);
			return "El cocodril es menja una vaca";
			}
			else if(c instanceof cocodril) {
				zoo.suprimeixAnimal(c);
				return "El cocodril es menja una altre cocodril";
				
			}else if(c == null){
				return "El cocodril busca que pot menjar";				
			}
			
			
		}
		
		return null;
		
	}

	
	String expresa(Zoo zoo) {
		String s = "Un cocodril obre una boca plena de dents";
		return s;
	}
	

}
