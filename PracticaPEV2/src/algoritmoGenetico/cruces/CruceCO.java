package algoritmoGenetico.cruces;

import java.util.ArrayList;
import java.util.Random;

import algoritmoGenetico.individuos.Individuo;

public class CruceCO extends Cruce {

	public CruceCO(Individuo[] poblacion, int tamPoblacion, Random rand, double probCruce, int numProblema) {
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
				
				ArrayList<Integer> listOrd1 = new ArrayList<Integer>(), listOrd2 = new ArrayList<Integer>();
				for(int j = 0; j < tamIndividuos; j++) {
					listOrd1.add(j);
					listOrd2.add(j);
				}
				
				//Codificar los nuevos Individuos
				for(int j = 0; j < tamIndividuos; j++) {
					
					int aux1 = listOrd1.indexOf(nuevaPoblacion[i].cromosoma.get(j)), aux2 = listOrd2.indexOf(nuevaPoblacion[i + 1].cromosoma.get(j));
					
					listOrd1.remove(nuevaPoblacion[i].cromosoma.get(j));
					nuevaPoblacion[i].cromosoma.set(j, aux1);
					
					listOrd2.remove(nuevaPoblacion[i + 1].cromosoma.get(j));
					nuevaPoblacion[i + 1].cromosoma.set(j, aux2);
				}
				
				//Cruce monopunto
				int tamCromosoma = this.poblacion[i].cromosoma.size();
				int puntoCorte = this.rand.nextInt(tamCromosoma);
				for(int j = puntoCorte; j < tamCromosoma; j++) {
					int aux = nuevaPoblacion[i].cromosoma.get(j);
					nuevaPoblacion[i].cromosoma.set(j, nuevaPoblacion[i + 1].cromosoma.get(j));
					nuevaPoblacion[i + 1].cromosoma.set(j, aux);
				}
				
				//Decodificar individuos
				listOrd1.clear();
				listOrd2.clear();
				for(int j = 0; j < tamIndividuos; j++) {
					listOrd1.add(j);
					listOrd2.add(j);
				}
				
				for(int j = 0; j < tamIndividuos; j++) {
					
					int aux1 = listOrd1.get(nuevaPoblacion[i].cromosoma.get(j)), aux2 = listOrd2.get(nuevaPoblacion[i + 1].cromosoma.get(j));
					
					listOrd1.remove(listOrd1.get(nuevaPoblacion[i].cromosoma.get(j)));
					nuevaPoblacion[i].cromosoma.set(j, aux1);
					
					listOrd2.remove(listOrd2.get(nuevaPoblacion[i + 1].cromosoma.get(j)));
					nuevaPoblacion[i + 1].cromosoma.set(j, aux2);
				}
			}
		}
		return nuevaPoblacion;
	}
}

	

