package algoritmoGenetico.cruces;

import java.util.ArrayList;
import java.util.Random;

import algoritmoGenetico.individuos.Individuo;

public class CruceERX extends Cruce {

	public CruceERX(Individuo[] poblacion, int tamPoblacion, Random rand, double probCruce, int numProblema) {
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
				
				
				ArrayList<ArrayList<Integer>> mat = new ArrayList<ArrayList<Integer>>();
				for(int j = 0; j < tamIndividuos; j++) {
					mat.add(new ArrayList<Integer>());
					int index1 = this.poblacion[i].cromosoma.indexOf(j), index2 = this.poblacion[i + 1].cromosoma.indexOf(j), izq1 = index1 - 1, izq2 = index2 - 1, der1 = index1 + 1, der2 = index2 + 1;
					if(izq1 == -1) izq1 = tamIndividuos - 1;
					if(der1 == tamIndividuos) der1 = 0;
					if(izq2 == -1) izq2 = tamIndividuos - 1;
					if(der2 == tamIndividuos) der2 = 0;
					
					if(!mat.get(j).contains(this.poblacion[i].cromosoma.get(izq1))) {
						mat.get(j).add(this.poblacion[i].cromosoma.get(izq1));
					}
					if(!mat.get(j).contains(this.poblacion[i].cromosoma.get(der1))) {
						mat.get(j).add(this.poblacion[i].cromosoma.get(der1));
					}
					if(!mat.get(j).contains(this.poblacion[i + 1].cromosoma.get(izq2))) {
						mat.get(j).add(this.poblacion[i + 1].cromosoma.get(izq2));
					}
					if(!mat.get(j).contains(this.poblacion[i + 1].cromosoma.get(der2))) {
						mat.get(j).add(this.poblacion[i + 1].cromosoma.get(der2));
					}
				}
				
				//Rellenar individuos
				boolean fin = false, bloqueo;
				int intento = 0;
				while(!fin && intento < 1000) {
					bloqueo = false; fin = true;
					nuevaPoblacion[i].cromosoma.set(0, this.poblacion[i].cromosoma.get(intento % tamIndividuos));
					intento ++;
					
					for(int j = 1; j < tamIndividuos && !bloqueo; j++) {
						ArrayList<Integer> posibles = new ArrayList<Integer>();
						for(Integer integer: mat.get(nuevaPoblacion[i].cromosoma.get(j - 1))) {
							if(!nuevaPoblacion[i].cromosoma.contains(integer)) posibles.add(integer);
						}
						
						ArrayList<Integer> posiblesFinal = new ArrayList<Integer>();
						int min = Integer.MAX_VALUE;
						for(int k = 0; k < posibles.size(); k++) {
							if(mat.get(posibles.get(k)).size() <= min) {
								if(mat.get(posibles.get(k)).size() < min) {
									posiblesFinal.clear();
									min = mat.get(posibles.get(k)).size();
								}
								posiblesFinal.add(posibles.get(k));
							}
						}
						
						if(!posiblesFinal.isEmpty()) {
							if(posiblesFinal.size() == 1) nuevaPoblacion[i].cromosoma.set(j, posiblesFinal.get(0));
							else nuevaPoblacion[i].cromosoma.set(j, posiblesFinal.get(this.rand.nextInt(posiblesFinal.size())));
						}
						else {
							bloqueo = true;
						}
					}
					if(bloqueo) {
						fin = false;
						for(int k = 0; k < tamIndividuos; k++) nuevaPoblacion[i].cromosoma.set(k, -1);
					}
					
				}
				if(intento == 1000) nuevaPoblacion[i] = new Individuo(this.poblacion[i]);
				
				intento = 0;
				fin = false; 
				while(!fin && intento < 1000) {
					bloqueo = false; fin = true;
					nuevaPoblacion[i + 1].cromosoma.set(0, this.poblacion[i + 1].cromosoma.get(intento % tamIndividuos));
					intento ++;
					
					for(int j = 1; j < tamIndividuos && !bloqueo; j++) {
						ArrayList<Integer> posibles = new ArrayList<Integer>();
						for(Integer integer: mat.get(nuevaPoblacion[i + 1].cromosoma.get(j - 1))) {
							if(!nuevaPoblacion[i + 1].cromosoma.contains(integer)) posibles.add(integer);
						}
						
						ArrayList<Integer> posiblesFinal = new ArrayList<Integer>();
						int min = Integer.MAX_VALUE;
						for(int k = 0; k < posibles.size(); k++) {
							if(mat.get(posibles.get(k)).size() <= min) {
								if(mat.get(posibles.get(k)).size() < min) {
									posiblesFinal.clear();
									min = mat.get(posibles.get(k)).size();
								}
								posiblesFinal.add(posibles.get(k));
							}
						}
						
						if(!posiblesFinal.isEmpty()) {
							if(posiblesFinal.size() == 1) nuevaPoblacion[i + 1].cromosoma.set(j, posiblesFinal.get(0));
							else nuevaPoblacion[i + 1].cromosoma.set(j, posiblesFinal.get(this.rand.nextInt(posiblesFinal.size())));
						}
						else {
							bloqueo = true;
						}
						
					}
					if(bloqueo) {
						fin = false;
						for(int k = 0; k < tamIndividuos; k++) nuevaPoblacion[i + 1].cromosoma.set(k, -1);
					}
					
				}
				if(intento == 1000) nuevaPoblacion[i + 1] = new Individuo(this.poblacion[i + 1]);
			}
		}
		return nuevaPoblacion;
	}
}
	

	


