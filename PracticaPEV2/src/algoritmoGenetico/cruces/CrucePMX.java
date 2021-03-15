package algoritmoGenetico.cruces;

import java.util.Random;

import algoritmoGenetico.individuos.Individuo;

public class CrucePMX extends Cruce {

	public CrucePMX(Individuo[] poblacion, int tamPoblacion, Random rand, double probCruce, int numProblema) {
		super(poblacion, tamPoblacion, rand, probCruce, numProblema);
	}

	@Override
	public Individuo[] run() {
		Individuo[] nuevaPoblacion = new Individuo[this.tamPoblacion];

		// Creo individuos vacios
		for (int i = 0; i < this.tamPoblacion; i++)
			nuevaPoblacion[i] = new Individuo(this.poblacion[i]);
		for (int i = 0; i < this.tamPoblacion - 1; i += 2) {
			if (this.rand.nextDouble() < this.probCruce) {
				for (int j = 0; j < nuevaPoblacion[i].cromosoma.size(); j++) {
					nuevaPoblacion[i].cromosoma.set(j, -1);
					nuevaPoblacion[i + 1].cromosoma.set(j, -1);
				}
				int corte1 = this.rand.nextInt(this.poblacion[0].cromosoma.size()),
						corte2 = this.rand.nextInt(this.poblacion[0].cromosoma.size());
				if (corte1 > corte2) {
					int aux = corte1;
					corte1 = corte2;
					corte2 = aux;
				}

				// Copio el fragmento interno
				for (int j = corte1; j <= corte2; j++) {
					nuevaPoblacion[i].cromosoma.set(j, this.poblacion[i + 1].cromosoma.get(j));
					nuevaPoblacion[i + 1].cromosoma.set(j, this.poblacion[i].cromosoma.get(j));
				}

				// Añado las x restantes
				for (int j = 0; j < this.poblacion[0].cromosoma.size(); j++) {
					int numFinal;
					if (nuevaPoblacion[i].cromosoma.get(j) == -1) {
						if (!nuevaPoblacion[i].cromosoma.contains(this.poblacion[i].cromosoma.get(j))) {
							nuevaPoblacion[i].cromosoma.set(j, this.poblacion[i].cromosoma.get(j));
						} else {
							numFinal = this.poblacion[i].cromosoma
									.get(this.poblacion[i + 1].cromosoma.indexOf(this.poblacion[i].cromosoma.get(j)));
							while (nuevaPoblacion[i].cromosoma.contains(numFinal)) {
								numFinal = this.poblacion[i].cromosoma
										.get(this.poblacion[i + 1].cromosoma.indexOf(numFinal));
							}
							nuevaPoblacion[i].cromosoma.set(j, numFinal);
						}
					}
					if (nuevaPoblacion[i + 1].cromosoma.get(j) == -1) {
						if (!nuevaPoblacion[i + 1].cromosoma.contains(this.poblacion[i + 1].cromosoma.get(j))) {
							nuevaPoblacion[i + 1].cromosoma.set(j, this.poblacion[i + 1].cromosoma.get(j));
						} else {
							numFinal = this.poblacion[i + 1].cromosoma
									.get(this.poblacion[i].cromosoma.indexOf(this.poblacion[i + 1].cromosoma.get(j)));
							while (nuevaPoblacion[i + 1].cromosoma.contains(numFinal)) {
								numFinal = this.poblacion[i + 1].cromosoma
										.get(this.poblacion[i].cromosoma.indexOf(numFinal));
							}
							nuevaPoblacion[i + 1].cromosoma.set(j, numFinal);
						}
					}
				}
			}
		}
		return nuevaPoblacion;
	}
}