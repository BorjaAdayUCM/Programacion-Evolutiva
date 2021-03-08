package algoritmoGenetico.cruces;

import java.util.Random;

import algoritmoGenetico.individuos.Individuo;
import algoritmoGenetico.individuos.IndividuoFuncion1;
import algoritmoGenetico.individuos.IndividuoFuncion2;
import algoritmoGenetico.individuos.IndividuoFuncion3;
import algoritmoGenetico.individuos.IndividuoFuncion4;
import algoritmoGenetico.individuos.IndividuoFuncion5;

@SuppressWarnings("rawtypes")
public class CruceMonopunto extends Cruce {

	
	public CruceMonopunto(Individuo[] poblacion, int tamPoblacion, Random rand, double probCruce, int numProblema) {
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
				int puntoCorte = this.rand.nextInt(tamCromosoma);
				for(int j = puntoCorte; j < tamCromosoma; j++) {
					nuevaPoblacion[i].getCromosoma()[j] = this.poblacion[i + 1].getCromosoma()[j];
					nuevaPoblacion[i + 1].getCromosoma()[j] = this.poblacion[i].getCromosoma()[j];
				}
			}
		}
		
		return nuevaPoblacion;
	}
	
}
