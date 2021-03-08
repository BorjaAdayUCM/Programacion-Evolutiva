package algoritmoGenetico.cruces;

import java.util.Random;

import algoritmoGenetico.individuos.Individuo;
import algoritmoGenetico.individuos.IndividuoFuncion1;
import algoritmoGenetico.individuos.IndividuoFuncion2;
import algoritmoGenetico.individuos.IndividuoFuncion3;
import algoritmoGenetico.individuos.IndividuoFuncion4;
import algoritmoGenetico.individuos.IndividuoFuncion5;

@SuppressWarnings("rawtypes")
public class CruceSBX extends Cruce {

	public CruceSBX(Individuo[] poblacion, int tamPoblacion, Random rand, double probCruce, int numProblema) {
		super(poblacion, tamPoblacion, rand, probCruce, numProblema);
	}

	@Override
	public Individuo[] run() {
		Individuo[] nuevaPoblacion = new Individuo[this.tamPoblacion];
		
		//Copio la poblacion
		for(int i = 0; i < this.tamPoblacion; i++) {
			switch(this.numProblema) {
				case 1: nuevaPoblacion[i] = new IndividuoFuncion1(this.poblacion[i]); break;
				case 2: nuevaPoblacion[i] = new IndividuoFuncion2(this.poblacion[i]); break;
				case 3: nuevaPoblacion[i] = new IndividuoFuncion3(this.poblacion[i]); break;
				case 4: nuevaPoblacion[i] = new IndividuoFuncion4((IndividuoFuncion4)this.poblacion[i]); break;
				case 5: nuevaPoblacion[i] = new IndividuoFuncion5((IndividuoFuncion5)this.poblacion[i]); break;
			}
		}
		double r = this.rand.nextDouble(), b = 0.0;
		if(r <= 0.5) b = 2 * Math.pow(r, 1 / 2);
		else b = Math.pow((int) (1 / (2 * (2 - r))), 1 / 2);
		for(int i = 0; i < this.tamPoblacion - 1; i+=2) {
			if(this.rand.nextDouble() < this.probCruce) {
				int tamCromosoma = this.poblacion[i].getCromosoma().length;
				for(int j = 0; j < tamCromosoma; j++) {
					nuevaPoblacion[i].getCromosoma()[j] = 0.5 * (((1 + b) * (Double) this.poblacion[i].getCromosoma()[j]) + ((1 - b) * (Double) this.poblacion[i + 1].getCromosoma()[j]));
					nuevaPoblacion[i + 1].getCromosoma()[j] = 0.5 * (((1 - b) * (Double) this.poblacion[i].getCromosoma()[j]) + ((1 + b) * (Double) this.poblacion[i + 1].getCromosoma()[j]));
				}
			}
		}
		
		return nuevaPoblacion;
	}

}
