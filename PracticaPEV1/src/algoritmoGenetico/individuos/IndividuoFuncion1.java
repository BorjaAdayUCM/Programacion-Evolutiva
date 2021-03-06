package algoritmoGenetico.individuos;

public class IndividuoFuncion1 extends Individuo<Boolean> {

	public IndividuoFuncion1(double ValorError) {
		super(ValorError);
		this.tamGenes = new int[2];
		this.min = new double[2];
		this.max = new double[2];
		this.min[0] = -3.000;
		this.min[1] = 4.100;
		this.max[0] = 12.100;
		this.max[1] = 5.800;
		this.tamGenes[0] = this.tamGen(this.valorError, min[0], max[0]);
		this.tamGenes[1] = this.tamGen(this.valorError, min[1], max[1]);
		int tamTotal = tamGenes[0] + tamGenes[1];
		this.cromosoma = new Boolean[tamTotal];
		for (int i = 0; i < tamTotal; i++)
			this.cromosoma[i] = this.rand.nextBoolean();
	}

	@SuppressWarnings("rawtypes")
	public IndividuoFuncion1(Individuo individuo) {
		super(individuo);
		this.cromosoma = new Boolean[individuo.cromosoma.length];
		for (int i = 0; i < individuo.cromosoma.length; i++)
			this.cromosoma[i] = (Boolean) individuo.cromosoma[i];
	}

	@Override
	public void mutacionBasica() {
		int pos = this.rand.nextInt(this.cromosoma.length);
		if (this.cromosoma[pos])
			this.cromosoma[pos] = false;
		else
			this.cromosoma[pos] = true;
	}

	@Override
	public void mutacionUniforme() {
	}

	@Override
	public double getValor() {
		double x1 = this.getFenotipo(0), x2 = this.getFenotipo(1);
		return (21.5 + x1 * Math.sin(4 * Math.PI * x1) + x2 * Math.sin(20 * Math.PI * x2));
	}

	@Override
	public double getFitness() {
		return this.getValor();
	}

	@Override
	public String toString() {
		return "Variable X1 = " + this.getFenotipo(0) + ", Variable X2 = " + this.getFenotipo(1)
				+ ", Valor de la función = " + this.getValor();
	}

}
