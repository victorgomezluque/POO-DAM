package pintures;

import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * magatzem de pintura amb un proveidor per cada color
 * @author julian
 *
 */
public interface MagatzemPintura {
	
	/**
	 * Afegeix el proveidor d'un color.
	 * @param proveidor
	 */
	void afegirProveidor(ProveidorPintura proveidor);
	
	/**
	 * Obte el proveidor per color, null si no hi ha.
	 * @param color
	 * @return
	 */
	ProveidorPintura getProveidor(Color color);
	
	/**
	 * Retorna els estocs al magatzem de cada color.
	 * @return
	 */
	Map<Color, Integer> getEstocMagatzem();
	
	/**
	 * Retorna els estocs per cada proveidor.
	 * @return
	 */
	Map<Color, Integer> getEstocProveidors();
	
	/**
	 * Afegeix una comanda a una cua.
	 * @param comanda
	 */
	void afegirComanda(Comanda comanda);
	
	/**
	 * Retorna la cua de comandes pendents de processar.
	 * @return
	 */
	Queue<Comanda> getComandesPendents();
	
	/**
	 * Processa les comandes, retornant les processades,
	 * i deixant les que no poden atendre's a la cua.
	 * @return
	 */
	List<Comanda> processarComandes();	
}
