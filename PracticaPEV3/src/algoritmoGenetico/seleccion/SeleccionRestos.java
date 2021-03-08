package algoritmoGenetico.seleccion;

import java.util.Random;

import algoritmoGenetico.individuos.Individuo;

public class SeleccionRestos extends Seleccion {

	public SeleccionRestos(double[] fitness, Individuo[] poblacion, int tamPoblacion, Random rand, int tamTorneo, double escogerMejor, double umbralTruncamiento) {
		super(fitness, poblacion, tamPoblacion, rand, tamTorneo, escogerMejor, umbralTruncamiento);
	}

	
	@Override
	public Individuo[] run() {
		
		Individuo poblacionFinal[] = new Individuo[this.tamPoblacion];
		
		int numSeleccionados = 0, copiasActual = 0, individuoActual = 0;
		while(numSeleccionados < this.tamPoblacion && individuoActual < this.tamPoblacion) {
			int copiasEsperadas = (int) Math.round(this.fitness[individuoActual] * this.tamPoblacion);
			copiasActual = 0;
			while(copiasActual < copiasEsperadas && individuoActual < this.tamPoblacion) {
				poblacionFinal[numSeleccionados] = new Individuo(this.poblacion[individuoActual]);
				numSeleccionados++; copiasActual++;
			}
			individuoActual++;
		}
		
		int restantes = this.tamPoblacion - numSeleccionados;
		Individuo poblacionUnir[] = new Individuo[restantes];
		poblacionUnir = new SeleccionRuleta(this.fitness, this.poblacion, restantes, this.rand, this.tamTorneo, this.escogerMejor, this.umbralTruncamiento).run();
		
		for(int i = 0; numSeleccionados < this.tamPoblacion && i < restantes; i++, numSeleccionados++) poblacionFinal[numSeleccionados] = new Individuo(poblacionUnir[i]);
		
		return poblacionFinal;
	}
}