package algoritmoGenetico.seleccion;

import java.util.Random;

import algoritmoGenetico.individuos.Individuo;
import algoritmoGenetico.individuos.IndividuoFuncion1;
import algoritmoGenetico.individuos.IndividuoFuncion2;
import algoritmoGenetico.individuos.IndividuoFuncion3;
import algoritmoGenetico.individuos.IndividuoFuncion4;
import algoritmoGenetico.individuos.IndividuoFuncion5;

@SuppressWarnings("rawtypes")
public class SeleccionEstocasticaUniversal extends Seleccion{

	public SeleccionEstocasticaUniversal(double[] fitness, Individuo[] poblacion, int tamPoblacion, Random rand, int tamTorneo, double escogerMejor, double umbralTruncamiento, int numProblema) {
		super(fitness, poblacion, tamPoblacion, rand, tamTorneo, escogerMejor, umbralTruncamiento, numProblema);
	}

	@Override
	public Individuo[] run() {
		//Creacion de variables
		Individuo poblacionFinal[] = new Individuo[this.tamPoblacion];
		
		double seleccionado = (double)(1 / (double) this.tamPoblacion) * this.rand.nextDouble(), probAcumulada = this.fitness[0];
		int elegido = 0, numSeleccionados = 0;
		
		while(numSeleccionados < this.tamPoblacion) {
			while(numSeleccionados < this.tamPoblacion && seleccionado <= probAcumulada) {
				switch(this.numProblema) {
					case 1: poblacionFinal[numSeleccionados] = new IndividuoFuncion1(this.poblacion[elegido]); break;
					case 2: poblacionFinal[numSeleccionados] = new IndividuoFuncion2(this.poblacion[elegido]); break;
					case 3: poblacionFinal[numSeleccionados] = new IndividuoFuncion3(this.poblacion[elegido]); break;
					case 4: poblacionFinal[numSeleccionados] = new IndividuoFuncion4((IndividuoFuncion4) this.poblacion[elegido]); break;
					case 5: poblacionFinal[numSeleccionados] = new IndividuoFuncion5((IndividuoFuncion5) this.poblacion[elegido]); break;
				}
				seleccionado += (((double) 1.0) / ((double) this.tamPoblacion));
				numSeleccionados++;
			}
			elegido++;
			if(elegido < this.tamPoblacion) probAcumulada += this.fitness[elegido];
		}
		
		return poblacionFinal;
	}
}
