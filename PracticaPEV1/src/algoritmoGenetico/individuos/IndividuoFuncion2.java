package algoritmoGenetico.individuos;

@SuppressWarnings("rawtypes")
public class IndividuoFuncion2 extends Individuo<Boolean> {

	public IndividuoFuncion2(double valorError) {
		super(valorError);
		this.tamGenes = new int[2];
		this.min = new double[2];
		this.max = new double[2];
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
	
	public IndividuoFuncion2(Individuo individuo) {
		super(individuo);
		this.cromosoma = new Boolean[individuo.cromosoma.length];
		for(int i = 0; i < individuo.cromosoma.length; i++) this.cromosoma[i] = (Boolean) individuo.cromosoma[i];
	}

	@Override
	public void mutacionBasica() {
		
	}
	
	@Override
	public void mutacionUniforme() {}

	@Override
	public double getValor() {
		double x1 = this.getFenotipo(0), x2 = this.getFenotipo(1);
		return (double) -Math.abs(Math.sin(x1) * Math.cos(x2) * Math.exp(Math.abs(1 - ((Math.sqrt(Math.pow(x1, 2) + Math.pow(x2, 2)) / Math.PI)))));
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