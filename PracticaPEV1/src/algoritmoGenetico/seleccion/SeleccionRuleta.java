package algoritmoGenetico.seleccion;

import java.util.Random;

import algoritmoGenetico.individuos.Individuo;
import algoritmoGenetico.individuos.IndividuoFuncion1;
import algoritmoGenetico.individuos.IndividuoFuncion2;
import algoritmoGenetico.individuos.IndividuoFuncion3;
import algoritmoGenetico.individuos.IndividuoFuncion4;
import algoritmoGenetico.individuos.IndividuoFuncion5;

@SuppressWarnings("rawtypes")
public class SeleccionRuleta extends Seleccion {

	public SeleccionRuleta(double[] fitness, Individuo[] poblacion, int tamPoblacion, Random rand, int tamTorneo, double escogerMejor, double umbralTruncamiento, int numProblema) {
		super(fitness, poblacion, tamPoblacion, rand, tamTorneo, escogerMejor, umbralTruncamiento, numProblema);
	}

	@Override
	public Individuo[] run() {
		//Creacion de variables
		Individuo poblacionFinal[] = new Individuo[this.tamPoblacion];
		double probabilidad, probabilidadAcumulada;
		int k;

		for(int i = 0; i < this.tamPoblacion; i++) {
			k = 0;
			probabilidad = this.rand.nextDouble();
			probabilidadAcumulada = this.fitness[k];
			while(k < this.tamPoblacion - 1 && probabilidadAcumulada < probabilidad) {
				probabilidadAcumulada += this.fitness[k + 1];
				k++;
			}
			switch(this.numProblema) {
				case 1: poblacionFinal[i] = new IndividuoFuncion1(this.poblacion[k]); break;
				case 2: poblacionFinal[i] = new IndividuoFuncion2(this.poblacion[k]); break;
				case 3: poblacionFinal[i] = new IndividuoFuncion3(this.poblacion[k]); break;
				case 4: poblacionFinal[i] = new IndividuoFuncion4((IndividuoFuncion4) this.poblacion[k]); break;
				case 5: poblacionFinal[i] = new IndividuoFuncion5((IndividuoFuncion5) this.poblacion[k]); break;
			}
			
		}
		return poblacionFinal;
	}

}
