package algoritmoGenetico.cruces;

import java.util.Random;

import algoritmoGenetico.individuos.Individuo;

public class CruceCX extends Cruce {

	public CruceCX(Individuo[] poblacion, int tamPoblacion, Random rand, double probCruce, int numProblema) {
		super(poblacion, tamPoblacion, rand, probCruce, numProblema);
	}
	
	@Override
	public Individuo[] run() {
		Individuo[] nuevaPoblacion = new Individuo[this.tamPoblacion];
		int tamIndividuos = this.poblacion[0].cromosoma.size();
				
		//Creo individuos vacios
		for(int i = 0; i < this.tamPoblacion; i++) nuevaPoblacion[i] = new Individuo(this.poblacion[i]);
		for(int i = 0; i < this.tamPoblacion - 1; i+=2) {
			if(this.rand.nextDouble() < this.probCruce) {
				for(int j = 0; j < tamIndividuos; j++) {
					nuevaPoblacion[i].cromosoma.set(j, -1);
					nuevaPoblacion[i + 1].cromosoma.set(j, -1);
				}
				
				int numColocar1 = this.poblacion[i].cromosoma.get(0), numColocar2 = this.poblacion[i + 1].cromosoma.get(0), indexColocar1 = 0, indexColocar2 = 0;
				while(!nuevaPoblacion[i].cromosoma.contains(numColocar1)) {
					nuevaPoblacion[i].cromosoma.set(indexColocar1, numColocar1);
					numColocar1 = this.poblacion[i + 1].cromosoma.get(indexColocar1);
					indexColocar1 = this.poblacion[i].cromosoma.indexOf(numColocar1);
				}
				
				while(!nuevaPoblacion[i + 1].cromosoma.contains(numColocar2)) {
					nuevaPoblacion[i + 1].cromosoma.set(indexColocar2, numColocar2);
					numColocar2 = this.poblacion[i].cromosoma.get(indexColocar2);
					indexColocar2 = this.poblacion[i + 1].cromosoma.indexOf(numColocar2);
				}
				
				
				for(int j = 0; j < tamIndividuos; j++) {
					if(nuevaPoblacion[i].cromosoma.get(j).equals(-1)) nuevaPoblacion[i].cromosoma.set(j, this.poblacion[i + 1].cromosoma.get(j));
					if(nuevaPoblacion[i + 1].cromosoma.get(j).equals(-1)) nuevaPoblacion[i + 1].cromosoma.set(j, this.poblacion[i].cromosoma.get(j));
				}
				
			}
		}
		return nuevaPoblacion;
	}
}

	

