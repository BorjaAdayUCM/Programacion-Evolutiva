package algoritmoGenetico.cruces;

import java.util.Random;

import algoritmoGenetico.individuos.Individuo;
import algoritmoGenetico.individuos.IndividuoFuncion1;
import algoritmoGenetico.individuos.IndividuoFuncion2;
import algoritmoGenetico.individuos.IndividuoFuncion3;
import algoritmoGenetico.individuos.IndividuoFuncion4;
import algoritmoGenetico.individuos.IndividuoFuncion5;

@SuppressWarnings("rawtypes")
public class CruceBLX extends Cruce {

	public CruceBLX(Individuo[] poblacion, int tamPoblacion, Random rand, double probCruce, int numProblema) {
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
		
		for(int i = 0; i < this.tamPoblacion - 1; i+=2) {
			if(this.rand.nextDouble() < this.probCruce) {
				int tamCromosoma = this.poblacion[i].getCromosoma().length;
				for(int j = 0; j < tamCromosoma; j++) {
					double min = Math.min((Double) this.poblacion[i].getCromosoma()[j], (Double) this.poblacion[i + 1].getCromosoma()[j]), max = Math.max((Double) this.poblacion[i].getCromosoma()[j], (Double) this.poblacion[i + 1].getCromosoma()[j]);
					double I = max - min;
					min = min - (I * this.rand.nextDouble());
					max = max + (I * this.rand.nextDouble());
					
					nuevaPoblacion[i].getCromosoma()[j] = min + (max - min) * this.rand.nextDouble();
					nuevaPoblacion[i + 1].getCromosoma()[j] = min + (max - min) * this.rand.nextDouble();
				}
			}
		}
		
		return nuevaPoblacion;
	}

}
