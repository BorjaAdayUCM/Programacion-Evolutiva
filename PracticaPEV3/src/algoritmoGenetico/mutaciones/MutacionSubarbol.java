
package algoritmoGenetico.mutaciones;

import java.util.Random;

import algoritmoGenetico.individuos.Individuo;

public class MutacionSubarbol extends Mutacion {

	public MutacionSubarbol(Individuo[] poblacion, int tamPoblacion, Random rand, double probMutacion) {
		super(poblacion, tamPoblacion, rand, probMutacion);
	}

	@Override
	public void run() {
		for(int i = 0; i < this.tamPoblacion; i++) {
			if(this.rand.nextDouble() < this.probMutacion) {
				this.poblacion[i].mutacionSubarbol();
			}
		}
	}

}