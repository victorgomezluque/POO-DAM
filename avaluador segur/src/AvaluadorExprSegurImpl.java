import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.text.html.HTMLDocument.Iterator;

public class AvaluadorExprSegurImpl implements AvaluadorExprSegur {

	@Override
	public List<String> aTokens(String expr) throws ExpressioException {
		String[] tokens = expr.split(" ");

		// Arrays.asList() convierte un array en un array list,
		ArrayList<String> res = new ArrayList<String>(Arrays.asList(tokens));

		for (java.util.Iterator iterator = res.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			if (string.equals(" ")) {
				iterator.remove();
			}

		}

		// System.out.println(res);
		return res;
	}

	@Override
	public List<String> aPostfix(List<String> infix) throws ExpressioException {
		ArrayList<String> numeros = new ArrayList<String>();
		ArrayList<String> operador = new ArrayList<String>();
		int contador = 0;
		int contadorabierto=0;
		int contadorCerrado=0;
		

		for (String string : infix) {

			try {
				Double.parseDouble(string);
				numeros.add(string);

			} catch (Exception e) {

				if (string.equals("(") || string.equals(")")) {
					contador++;
					if (string.equals("(")) {
						contadorabierto++;
					}
					if (string.equals(")")) {
						contadorCerrado++;
					}

					if (contador == 2) {
						numeros.add(operador.get(0));
						operador.remove(0);
						contador = 0;
					}
				} else {
					operador.add(0, string);

				}

			}

		}

		ExpressioException s = new ExpressioException(null);

		
		
		if(contadorabierto<contadorCerrado) {
			throw new ExpressioException("T faltan parentesis abiertos");

			
		}else if(contadorabierto>contadorCerrado) {
			throw new ExpressioException("T faltan parentesis cerrados");

		}
		
		if (numeros.size() <= operador.size()) {
			throw new ExpressioException("T falta numeros");
		}
		

		ArrayList<String> res = new ArrayList<String>();
		res.addAll(numeros);
		res.addAll(operador);
		return res;
	}

	@Override
	public double avalua(List<String> postfix) throws ExpressioException {
		double resultado = 0;
		ExpressioException s = new ExpressioException(null);

		if(postfix.size()>2) {
		while (postfix.size() > 1) {
			System.out.println(postfix);
			for (int i = 0; i < postfix.size(); i++) {

				try {
					Double.parseDouble(postfix.get(i));
				} catch (Exception e) {
					if (postfix.get(i).equals("*")) {
						Double num1 = Double.parseDouble(postfix.get((int) (i - 1)));
						Double num2 = Double.parseDouble(postfix.get((int) (i - 2)));

						Double result = num1 * num2;
						resultado = result;
//							
						postfix.remove(i);
						postfix.remove(i - 1);
						postfix.set((int) (i - 2), result.toString());

					} else if (postfix.get(i).equals("+")) {
						Double num1 = Double.parseDouble(postfix.get((int) (i - 1)));
						Double num2 = Double.parseDouble(postfix.get((int) (i - 2)));

						Double result = num1 + num2;
						resultado = result;

						postfix.remove(i);
						postfix.remove(i - 1);
						postfix.set((int) (i - 2), result.toString());

					} else if (postfix.get(i).equals("-")) {
						Double num1 = Double.parseDouble(postfix.get((int) (i - 1)));
						Double num2 = Double.parseDouble(postfix.get((int) (i - 2)));

						Double result = num2 - num1;
						resultado = result;

						postfix.remove(i);
						postfix.remove(i - 1);
						postfix.set((int) (i - 2), result.toString());

					} else if (postfix.get(i).equals("/")) {
						Double num1 = Double.parseDouble(postfix.get((int) (i - 1)));
						Double num2 = Double.parseDouble(postfix.get((int) (i - 2)));

						Double result = num2 / num1;
						resultado = result;

						postfix.remove(i);
						postfix.remove(i - 1);
						postfix.set((int) (i - 2), result.toString());

					}

				}

			}
		}
		}else {
			throw new ExpressioException("No puedes hacer la operación");
	
		}

		return resultado;
	}

}