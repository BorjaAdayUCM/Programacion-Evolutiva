package algoritmoGenetico.seleccion;

import java.util.Random;

import algoritmoGenetico.individuos.Individuo;

public class SeleccionRanking extends Seleccion {
	
	public SeleccionRanking(double[] fitness, Individuo[] poblacion, int tamPoblacion, Random rand, int tamTorneo, double escogerMejor, double umbralTruncamiento) {
		super(fitness, poblacion, tamPoblacion, rand, tamTorneo, escogerMejor, umbralTruncamiento);
	}

	@Override
	public Individuo[] run() {
		Individuo[] poblacionFinal = new Individuo[this.poblacion.length];
		double media = 0;
		for(int i = 0; i < this.poblacion.length; i++) {
			media += fitness[i];
		}
		media /= this.poblacion.length;
		
		double presionSelectiva = fitness[0] / media > 2 ? 2 : fitness[0] / media;
		double fitnessRanking[] = new double[this.poblacion.length];
		
		for(int i = 0; i < this.poblacion.length; i++) {
			fitnessRanking[i] = ((double) 1 / (double) this.poblacion.length) * (presionSelectiva - (2 * (presionSelectiva - 1)) * (i / (this.poblacion.length - 1)));
		}
		
		poblacionFinal = new SeleccionRuleta(fitnessRanking, this.poblacion, this.tamPoblacion, this.rand,this.tamTorneo, this.escogerMejor, this.umbralTruncamiento).run();
				
		return poblacionFinal;
	}
	
}
