package problemes.parells.impl;

import problemes.parells.Parell;

public class ParellImpl<L,R> implements Parell <L,R>{
	
	
	private L esquerra;
	private R dreta;
	
	public ParellImpl(L esquerra, R dreta) {
		this.dreta = dreta;
		this.esquerra = esquerra;
		
	}
	
	@Override
	public L getEsquerra() {
		return esquerra;
	}

	@Override
	public  R getDreta() {
		return dreta;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dreta == null) ? 0 : dreta.hashCode());
		result = prime * result + ((esquerra == null) ? 0 : esquerra.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ParellImpl other = (ParellImpl) obj;
		if (dreta == null) {
			if (other.dreta != null)
				return false;
		} else if (!dreta.equals(other.dreta))
			return false;
		if (esquerra == null) {
			if (other.esquerra != null)
				return false;
		} else if (!esquerra.equals(other.esquerra))
			return false;
		return true;
	}

	@Override
	public String toString() {
		String t = esquerra + ":" + dreta;
		return t;
	}

	
	

}
