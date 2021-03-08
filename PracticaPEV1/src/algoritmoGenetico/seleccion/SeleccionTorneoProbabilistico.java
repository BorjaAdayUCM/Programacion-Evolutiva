package algoritmoGenetico.seleccion;

import java.util.Random;

import algoritmoGenetico.individuos.Individuo;
import algoritmoGenetico.individuos.IndividuoFuncion1;
import algoritmoGenetico.individuos.IndividuoFuncion2;
import algoritmoGenetico.individuos.IndividuoFuncion3;
import algoritmoGenetico.individuos.IndividuoFuncion4;
import algoritmoGenetico.individuos.IndividuoFuncion5;

@SuppressWarnings("rawtypes")
public class SeleccionTorneoProbabilistico extends Seleccion {
	
	public SeleccionTorneoProbabilistico(double[] fitness, Individuo[] poblacion, int tamPoblacion, Random rand, int tamTorneo, double escogerMejor, double umbralTruncamiento, int numProblema) {
		super(fitness, poblacion, tamPoblacion, rand, tamTorneo, escogerMejor, umbralTruncamiento, numProblema);
	}

	
	@Override
	public Individuo[] run() {
		Individuo poblacionFinal[] = new Individuo[this.tamPoblacion];
		
		for(int i = 0; i < this.tamPoblacion; i++) {
			
			
			//Creacion del torneo
			Individuo[] torneo = new Individuo[this.tamTorneo];
			double[] fitness = new double[this.tamTorneo];
			for(int j = 0; j < this.tamTorneo; j++) {
				int elegido = this.rand.nextInt(this.tamPoblacion);
				fitness[j] = this.fitness[elegido];
				torneo[j] = this.poblacion[elegido];
			}
			
			//Calculo del mejor y peor
			double max = fitness[0], min = fitness[0];
			int mejor = 0, peor = 0;
			for(int k = 1; k < this.tamTorneo; k++) {
				if(fitness[k] > max) {
					max = fitness[k];
					mejor = k;
				}
				if(fitness[k] < min) {
					min = fitness[k];
					peor = k;
				}
			}
			
			//Escoger
			int escogido;
			if(this.rand.nextDouble() < (this.escogerMejor / 100)) escogido = mejor;
			else escogido = peor;
			switch(this.numProblema) {
				case 1: poblacionFinal[i] = new IndividuoFuncion1(torneo[escogido]); break;
				case 2: poblacionFinal[i] = new IndividuoFuncion2(torneo[escogido]); break;
				case 3: poblacionFinal[i] = new IndividuoFuncion3(torneo[escogido]); break;
				case 4: poblacionFinal[i] = new IndividuoFuncion4((IndividuoFuncion4) torneo[escogido]); break;
				case 5: poblacionFinal[i] = new IndividuoFuncion5((IndividuoFuncion5) torneo[escogido]); break;
			}
		}
		
		return poblacionFinal;
	}

}