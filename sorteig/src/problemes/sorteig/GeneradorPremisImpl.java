package problemes.sorteig;

import java.util.Random;

public class GeneradorPremisImpl implements GeneradorPremis<Integer> {

	@Override
	public Integer genera() {
		return new Random().nextInt(10);
	}
}
