package problemes.sorteig;

import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 
 * @author julian
 *
 * @param <K> identificador del participant
 * @param <V> bolet amb el que participa
 */
public interface Sorteig<K, V> {

	/**
	 * afegeix un nou concursant a la cua
	 * @param clau
	 * @return
	 */
	V afegir(K clau);

	/**
	 * inverteix la cua de concursants utilitzant una pila
	 */
	void invertir();

	/**
	 * retorna la cua de concursants
	 * @return
	 */
	Queue<K> concursants();

	/** 
	 * fa el sorteig i retorna els identificadors dels guanyadors
	 * @return
	 */
	Set<K> sortejar();

	/**
	 * retorna un mapa amb cada bolet guanyador i si s'ha trobat un guanyador
	 * @return
	 */
	Map<V, Boolean> premiats();
}
