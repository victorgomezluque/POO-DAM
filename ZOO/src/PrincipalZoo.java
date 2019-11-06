import java.util.Scanner;

public class PrincipalZoo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Zoo zoo = new Zoo();
		espectador Es = new espectador();
		boolean acabar = false;
		int i = 0;
		Scanner sc = new Scanner(System.in);

		while(!acabar) {
			System.out.println("El zoo a obert les portes");
			System.out.println("1. Afegir vaca");
			System.out.println("2. Afegir cocodril");
			System.out.println("3. Suprimir vaca");
			System.out.println("5. Espectador mira");
			System.out.println("6. Surt");
			i = sc.nextInt();


			
			switch (i) {
			case 1:
				zoo.afegexiAnimal("Vaca");
				System.out.println("Ha arribat al zoo\r\n" + "una enorme vaca");
				break;
			case 2:
				zoo.afegexiAnimal("cocodril");
				System.out.println("Ha arribat al zoo un perillós cocodril");
				break;
			case 3:
				zoo.Surpimeixanimal("Vaca");
				System.out.println("S'ha traslladat una vaca");
				break;
			case 4:
				zoo.Surpimeixanimal("cocodril");
				System.out.println("S'ha traslladat un cocodril");

				break;
			case 5:
				Es.accio(zoo);
				break;
			case 6:
				System.out.println("Chao");
				

				break;
			}
			break;

		}
	}

}
