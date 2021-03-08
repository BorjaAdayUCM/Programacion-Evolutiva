package algoritmoGenetico.individuos;

@SuppressWarnings("rawtypes")
public class IndividuoFuncion3 extends Individuo<Boolean> {

	public IndividuoFuncion3(double valorError) {
		super(valorError);
		this.tamGenes = new int[2];
		this.min = new double[2];
		this.max = new double[2];
		this.tamGenes[0] = 14;
		this.tamGenes[1] = 14;
		this.min[0] = -10.000;
		this.min[1] = -10.000;
		this.max[0] = 10.000;
		this.max[1] = 10.000;
		this.tamGenes[0] = this.tamGen(this.valorError, min[0], max[0]);
		this.tamGenes[1] = this.tamGen(this.valorError, min[1], max[1]);
		int tamTotal = tamGenes[0] + tamGenes[1];
		this.cromosoma = new Boolean[tamTotal];
		for(int i = 0; i < tamTotal; i++) this.cromosoma[i] = this.rand.nextBoolean();
	}
	
	public IndividuoFuncion3(Individuo individuo) {
		super(individuo);
		this.cromosoma = new Boolean[individuo.cromosoma.length];
		for(int i = 0; i < individuo.cromosoma.length; i++) this.cromosoma[i] = (Boolean) individuo.cromosoma[i];
	}

	@Override
	public void mutacionBasica() {
		int pos = this.rand.nextInt(this.cromosoma.length);
		if(this.cromosoma[pos]) this.cromosoma[pos] = false;
		else this.cromosoma[pos] = true;
	}
	
	@Override
	public void mutacionUniforme() {}

	@Override
	public double getValor() {
		double x1 = this.getFenotipo(0), x2 = this.getFenotipo(1);
		double factor1 = 0.0, factor2 = 0.0;
		for(int i = 1; i <= 5; i++) {
			factor1 += i * Math.cos((i + 1) * x1 + i);
			factor2 += i * Math.cos((i + 1) * x2 + i);
		}
		return (double) factor1 * factor2;
	}

	@Override
	public double getFitness() {
		return this.getValor();
	}

	@Override
	public String toString() {
		return "Variable X1 = " + this.getFenotipo(0) + ", Variable X2 = " + this.getFenotipo(1) + ", Valor de la función = " + this.getValor();
	}

}