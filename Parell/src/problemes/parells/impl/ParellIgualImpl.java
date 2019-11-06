package problemes.parells.impl;

import problemes.parells.ParellIgual;

public class ParellIgualImpl<T> extends ParellImpl<T, T> implements ParellIgual<T>
{

	public ParellIgualImpl(T esquerra, T dreta) {
		super(esquerra, dreta);
	}

	
}
