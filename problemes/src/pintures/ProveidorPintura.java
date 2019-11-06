package pintures;

/**
 * proveidor d'un color de pintura.
 * @author julian
 *
 */
public interface ProveidorPintura {

	/**
	 * Color d'aquest proveidor.
	 * @return
	 */
	Color getColor();
	
	/**
	 * Unitats de pintura disponibles.
	 * @return
	 */
	int getEstoc();
	
	/**
	 * Unitats minimes que es poden retirar.
	 * @return
	 */
	int getQuantitatMinima();
	
	/**
	 * Afegeix estoc de pintura.
	 * @param quantitat
	 */
	void produirPintura(int quantitat);
	
	/**
	 * Retira estoc de pintura (amb un minim).
	 * Si no hi ha prou estoc, no es retira res (zero).
	 * @param quantitat
	 * @return
	 */
	int retirarPintura(int quantitat);
}
