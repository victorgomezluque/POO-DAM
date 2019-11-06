import java.util.List;
import java.util.Scanner;

/*
 * expressions que ha de gestionar (al catch), mostrant un error i fent un nou scanner:
 *
 * expressió incorrecta!
 * 		2 * A
 * 		1 / / 3
 * 		2 * 3 )
 * 		( 2 * 3
 * problema aritmètic!
 * 		2 / 0		<== a l'avalua: ha de generar un ArithmeticException
 */
public class AvaluadorExprSegurTest {
	
	public static void main(String[] args) {
		
		test(new AvaluadorExprSegurImpl());
	}

	public static void test(AvaluadorExprSegur ae) {
		
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			System.out.print("> ");
			String expr = scanner.nextLine();
			if (expr.length() == 0) {
				break;
			}
			
			List<String> tokens;
			List<String> pfList;
			
			try {
				tokens = ae.aTokens(expr);
				pfList = ae.aPostfix(tokens);
				System.out.println(pfList);
				double result = ae.avalua(pfList);		
				System.out.println("resultat: " + result + "\n");
				
			} catch (ExpressioException e) {
			
				System.out.println("expressió incorrecta!");
				e.printStackTrace(System.out);
				continue;
			} catch (ArithmeticException e) {
				System.out.println("problema aritmètic!");
				e.printStackTrace(System.out);
				continue;
			}
		}
		
		System.out.println("ciao!");
		scanner.close();
	}
}