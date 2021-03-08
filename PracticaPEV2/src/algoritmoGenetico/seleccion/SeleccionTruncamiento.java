package algoritmoGenetico.seleccion;

import java.util.Random;

import algoritmoGenetico.individuos.Individuo;

public class SeleccionTruncamiento extends Seleccion{
	
	public SeleccionTruncamiento(double[] fitness, Individuo[] poblacion, int tamPoblacion, Random rand, int tamTorneo, double escogerMejor, double umbralTruncamiento, int numProblema) {
		super(fitness, poblacion, tamPoblacion, rand, tamTorneo, escogerMejor, umbralTruncamiento, numProblema);
	}

	
	@Override
	public Individuo[] run() {
		
		
		if(this.umbralTruncamiento == 0.0) return this.poblacion;
		int numCopias = (int) Math.round((double) this.tamPoblacion / (double) this.umbralTruncamiento);
		if(numCopias == 0) return this.poblacion;
		
		Individuo poblacionFinal[] = new Individuo[this.tamPoblacion];
		//Calculo del umbral
		int numSeleccionados = 0, copiasActual = 0, individuoActual = 0;
		while(numSeleccionados < this.tamPoblacion) {
			copiasActual = 0;
			while(numSeleccionados < this.tamPoblacion && copiasActual < numCopias) {
				poblacionFinal[numSeleccionados] = new Individuo(this.poblacion[individuoActual]);
				numSeleccionados++; copiasActual++;
			}
			individuoActual++;
		}
		
		return poblacionFinal;
	}
}

