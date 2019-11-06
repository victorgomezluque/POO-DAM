package problemes.parells.impl;

import java.util.Collection;

import problemes.parells.Parell;
import problemes.parells.ParellFactory;
import problemes.parells.ParellIgual;
import problemes.parells.ProcessadorParells;

public class ParellFactoryImpl implements ParellFactory {

	@Override
	public <T> ParellIgual<T> creaParellIgual(T esquerra, T dreta) {
	ParellIgual<T> parellIgual = new ParellIgualImpl<T>(esquerra, dreta);
	return parellIgual;

	}

	@Override
	public <L, R> Parell<L, R> creaParell(L esquerra, R dreta) {
		Parell<L, R> parell = new ParellImpl<L, R>(esquerra, dreta);
		return parell;
	}

	@Override
	public <L, R, T extends Parell<L, R>> ProcessadorParells<L, R, T> creaProcessador(Collection<T> collection) {
		ProcessadorParells<L, R, T> processadorparell = new ProcessadorParellsImpl<L, R, T>(collection);  
		return processadorparell;
	}

}
