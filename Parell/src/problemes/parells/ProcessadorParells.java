package problemes.parells;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public interface ProcessadorParells<L, R, T extends Parell<L, R>> {

	Set<T> getSet();
	Collection<T> getCollection();
	
	Set<L> getEsquerres();
	Set<R> getDretes();
	
	Map<L, Integer> comptaEsquerres();
	Map<R, Integer> comptaDretes();
}
