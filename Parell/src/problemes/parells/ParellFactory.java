package problemes.parells;

import java.util.Collection;

public interface ParellFactory {
	
	<T> ParellIgual<T> creaParellIgual(T esquerra, T dreta);
	<L, R> Parell<L, R> creaParell(L esquerra, R dreta);
	
	<L, R, T extends Parell<L, R>> ProcessadorParells<L, R, T> creaProcessador(Collection<T> collection);
}
