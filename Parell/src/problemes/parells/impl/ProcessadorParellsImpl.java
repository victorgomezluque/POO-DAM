package problemes.parells.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import problemes.parells.Parell;
import problemes.parells.ProcessadorParells;

public class ProcessadorParellsImpl<L, R, T extends Parell<L, R>> implements ProcessadorParells<L, R, T> {

	Collection<T> collection;

	public ProcessadorParellsImpl(Collection<T> collection) {
		super();
		this.collection = collection;
	}

	@Override
	public Set<T> getSet() {
		Set<T> set = new HashSet<T>();
		for (T t : collection) {
			set.add(t);
		}
		return (Set<T>) set;
	}

	@Override
	public Collection<T> getCollection() {
		return collection;
	}

	@Override
	public Set<L> getEsquerres() {
		Set<T> set = new HashSet<T>();
		for (T t : collection) {
			set.add(t);
		}
		return (Set<L>) set;
	}

	@Override
	public Set<R> getDretes() {
		Set<T> set = new HashSet<T>();
		for (T t : collection) {
			set.add(t);
		}
		return (Set<R>) set;
	}

	@Override
	public Map<L, Integer> comptaEsquerres() {
		
		Map<L, Integer> mapa = new HashMap<L, Integer>();
		for (T t : collection) {
			if (mapa.get(t.getEsquerra()) != null) {
				mapa.put(t.getEsquerra(), mapa.get(t.getEsquerra())+1);
			}else {
				mapa.put(t.getEsquerra(), 1);

			}
		}
		return mapa;
	}

	@Override
	public Map<R, Integer> comptaDretes() {
		Map<R, Integer> mapa = new HashMap<R, Integer>();
		for (T t : collection) {
			if (mapa.get(t.getDreta()) != null) {
				mapa.put(t.getDreta(), mapa.get(t.getDreta())+1);
			}else {
				mapa.put(t.getDreta(), 1);

			}
		}
		return mapa;
	}

}
