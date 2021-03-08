package algoritmoGenetico.seleccion;

import java.util.Random;

import algoritmoGenetico.individuos.Individuo;

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
		
		double sumaTotal = 0;
		for(int i = 0; i < this.tamPoblacion; i++) {
			sumaTotal += this.fitness[i];
		}

		for(int i = 0; i < this.tamPoblacion; i++) {
			k = 0;
			probabilidad = this.rand.nextDouble() * sumaTotal;
			probabilidadAcumulada = this.fitness[k];
			while(k < this.tamPoblacion - 1 && probabilidadAcumulada < probabilidad) {
				probabilidadAcumulada += this.fitness[k + 1];
				k++;
			}
			poblacionFinal[i] = new Individuo(this.poblacion[k]);
		}
		return poblacionFinal;
	}

}
