package algoritmoGenetico.seleccion;

import java.util.Random;

import algoritmoGenetico.individuos.Individuo;
import algoritmoGenetico.individuos.IndividuoFuncion1;
import algoritmoGenetico.individuos.IndividuoFuncion2;
import algoritmoGenetico.individuos.IndividuoFuncion3;
import algoritmoGenetico.individuos.IndividuoFuncion4;
import algoritmoGenetico.individuos.IndividuoFuncion5;

@SuppressWarnings("rawtypes")
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
		
		return poblacionFinal;
	}
}

