package algoritmoGenetico.cruces;

import java.util.Random;

import algoritmoGenetico.individuos.Individuo;

public class CruceOX extends Cruce {

	public CruceOX(Individuo[] poblacion, int tamPoblacion, Random rand, double probCruce, int numProblema) {
		super(poblacion, tamPoblacion, rand, probCruce, numProblema);
	}

	@Override
	public Individuo[] run() {
		Individuo[] nuevaPoblacion = new Individuo[this.tamPoblacion];
		int tamIndividuos = this.poblacion[0].cromosoma.size();

		// Creo individuos vacios
		for (int i = 0; i < this.tamPoblacion; i++)
			nuevaPoblacion[i] = new Individuo(this.poblacion[i]);
		for (int i = 0; i < this.tamPoblacion - 1; i += 2) {
			if (this.rand.nextDouble() < this.probCruce) {
				for (int j = 0; j < tamIndividuos; j++) {
					nuevaPoblacion[i].cromosoma.set(j, -1);
					nuevaPoblacion[i + 1].cromosoma.set(j, -1);
				}
				int corte1 = this.rand.nextInt(tamIndividuos), corte2 = this.rand.nextInt(tamIndividuos);
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
				int r1 = (corte2 + 1) % tamIndividuos, r2 = (corte2 + 1) % tamIndividuos,
						w1 = (corte2 + 1) % tamIndividuos, w2 = (corte2 + 1) % tamIndividuos;
				for (int j = 0; j < tamIndividuos; j++) {
					if (nuevaPoblacion[i].cromosoma.get(w1) == -1) {
						if (!nuevaPoblacion[i].cromosoma.contains(this.poblacion[i].cromosoma.get(r1))) {
							nuevaPoblacion[i].cromosoma.set(w1, this.poblacion[i].cromosoma.get(r1));
							w1 = (w1 + 1) % tamIndividuos;
						}
						r1 = (r1 + 1) % tamIndividuos;
					}
					if (nuevaPoblacion[i + 1].cromosoma.get(w2) == -1) {
						if (!nuevaPoblacion[i + 1].cromosoma.contains(this.poblacion[i + 1].cromosoma.get(r2))) {
							nuevaPoblacion[i + 1].cromosoma.set(w2, this.poblacion[i + 1].cromosoma.get(r2));
							w2 = (w2 + 1) % tamIndividuos;
						}
						r2 = (r2 + 1) % tamIndividuos;
					}
				}
			}
		}
		return nuevaPoblacion;
	}

}