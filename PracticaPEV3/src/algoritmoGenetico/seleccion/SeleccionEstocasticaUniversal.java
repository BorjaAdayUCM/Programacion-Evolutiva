package algoritmoGenetico.seleccion;

import java.util.Random;

import algoritmoGenetico.individuos.Individuo;

public class SeleccionEstocasticaUniversal extends Seleccion{

	public SeleccionEstocasticaUniversal(double[] fitness, Individuo[] poblacion, int tamPoblacion, Random rand, int tamTorneo, double escogerMejor, double umbralTruncamiento) {
		super(fitness, poblacion, tamPoblacion, rand, tamTorneo, escogerMejor, umbralTruncamiento);
	}

	@Override
	public Individuo[] run() {
		//Creacion de variables
		Individuo poblacionFinal[] = new Individuo[this.tamPoblacion];
		
		double seleccionado = (double)(1 / (double) this.tamPoblacion) * this.rand.nextDouble(), probAcumulada = this.fitness[0];
		int elegido = 0, numSeleccionados = 0;
		
		while(numSeleccionados < this.tamPoblacion) {
			while(numSeleccionados < this.tamPoblacion && seleccionado <= probAcumulada) {
				poblacionFinal[numSeleccionados] = new Individuo(this.poblacion[elegido]);
				seleccionado += (((double) 1.0) / ((double) this.tamPoblacion));
				numSeleccionados++;
			}
			elegido++;
			if(elegido < this.tamPoblacion) probAcumulada += this.fitness[elegido];
		}
		
		return poblacionFinal;
	}
}
