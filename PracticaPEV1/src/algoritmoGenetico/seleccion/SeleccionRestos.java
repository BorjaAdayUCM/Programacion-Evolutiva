package algoritmoGenetico.seleccion;

import java.util.Random;

import algoritmoGenetico.individuos.Individuo;
import algoritmoGenetico.individuos.IndividuoFuncion1;
import algoritmoGenetico.individuos.IndividuoFuncion2;
import algoritmoGenetico.individuos.IndividuoFuncion3;
import algoritmoGenetico.individuos.IndividuoFuncion4;
import algoritmoGenetico.individuos.IndividuoFuncion5;

@SuppressWarnings("rawtypes")
public class SeleccionRestos extends Seleccion {

	public SeleccionRestos(double[] fitness, Individuo[] poblacion, int tamPoblacion, Random rand, int tamTorneo, double escogerMejor, double umbralTruncamiento, int numProblema) {
		super(fitness, poblacion, tamPoblacion, rand, tamTorneo, escogerMejor, umbralTruncamiento, numProblema);
	}

	
	@Override
	public Individuo[] run() {
		
		Individuo poblacionFinal[] = new Individuo[this.tamPoblacion];
		
		int numSeleccionados = 0, copiasActual = 0, individuoActual = 0;
		while(numSeleccionados < this.tamPoblacion && individuoActual < this.tamPoblacion) {
			int copiasEsperadas = (int) Math.round(this.fitness[individuoActual] * this.tamPoblacion);
			copiasActual = 0;
			while(copiasActual < copiasEsperadas && individuoActual < this.tamPoblacion) {
				switch(this.numProblema) {
					case 1: poblacionFinal[numSeleccionados] = new IndividuoFuncion1(this.poblacion[individuoActual]); break;
					case 2: poblacionFinal[numSeleccionados] = new IndividuoFuncion2(this.poblacion[individuoActual]); break;
					case 3: poblacionFinal[numSeleccionados] = new IndividuoFuncion3(this.poblacion[individuoActual]); break;
					case 4: poblacionFinal[numSeleccionados] = new IndividuoFuncion4((IndividuoFuncion4) this.poblacion[individuoActual]); break;
					case 5: poblacionFinal[numSeleccionados] = new IndividuoFuncion5((IndividuoFuncion5) this.poblacion[individuoActual]); break;
				}
				numSeleccionados++; copiasActual++;
			}
			individuoActual++;
		}
		
		int restantes = this.tamPoblacion - numSeleccionados;
		Individuo poblacionUnir[] = new Individuo[restantes];
		poblacionUnir = new SeleccionRuleta(this.fitness, this.poblacion, restantes, this.rand, this.tamTorneo, this.escogerMejor, this.umbralTruncamiento, this.numProblema).run();
		
		for(int i = 0; numSeleccionados < this.tamPoblacion && i < restantes; i++, numSeleccionados++) {
			switch(this.numProblema) {
				case 1: poblacionFinal[numSeleccionados] = new IndividuoFuncion1(poblacionUnir[i]); break;
				case 2: poblacionFinal[numSeleccionados] = new IndividuoFuncion2(poblacionUnir[i]); break;
				case 3: poblacionFinal[numSeleccionados] = new IndividuoFuncion3(poblacionUnir[i]); break;
				case 4: poblacionFinal[numSeleccionados] = new IndividuoFuncion4((IndividuoFuncion4) poblacionUnir[i]); break;
				case 5: poblacionFinal[numSeleccionados] = new IndividuoFuncion5((IndividuoFuncion5) poblacionUnir[i]); break;
			}
		}
		
		return poblacionFinal;
	}
}