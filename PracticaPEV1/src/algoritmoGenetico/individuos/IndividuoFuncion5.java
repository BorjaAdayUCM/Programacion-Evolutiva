package algoritmoGenetico.individuos;

public class IndividuoFuncion5 extends Individuo<Double> {

	private int valorN;

	public IndividuoFuncion5(int valorN, double valorError) {
		super(valorError);
		this.valorN = valorN;
		this.cromosoma = new Double[valorN];
		this.min = new double[valorN];
		this.max = new double[valorN];
		this.tamGenes = new int[valorN];
		for(int i = 0; i < valorN; i++) {
			this.min[i] = 0.000;
			this.max[i] = 180.000;
		}
		for(int i = 0; i < cromosoma.length; i++) {
			cromosoma[i] = this.min[i] + (this.max[i] - this.min[i]) * this.rand.nextDouble();
		}
	}
	
	@SuppressWarnings("deprecation")
	public IndividuoFuncion5(IndividuoFuncion5 individuo) {
		super(individuo);
		this.cromosoma = new Double[individuo.cromosoma.length];
		for(int i = 0; i < individuo.cromosoma.length; i++) this.cromosoma[i] = (Double) new Double(individuo.cromosoma[i]);
		this.valorN = individuo.valorN;
	}
	
	@Override
	public double getFenotipo(int numVariable) {
		return this.cromosoma[numVariable];
	}

	@Override
	public void mutacionBasica() {}

	@Override
	public void mutacionUniforme() {
		int muta = this.rand.nextInt(this.valorN);
		this.cromosoma[muta] = this.min[muta] + (this.max[muta] - this.min[muta]) * this.rand.nextDouble();
	}

	@Override
	public double getValor() {
		double valor = 0;
		for(int i = 1; i <= this.valorN; i++) {
			double x = this.cromosoma[i - 1];
			valor += Math.sin(x) * Math.pow(Math.sin(((i + 1) * (x * x)) / (Math.PI)), 20);
		}
		return valor * -1;
	}

	@Override
	public double getFitness() {
		return this.getValor();
	}

	@Override
	public String toString() {
		String text = "";
		for(int i = 0; i < this.valorN - 1; i++) text += "X" + (i + 1) + " = " + this.cromosoma[i] + ", ";
		return text + "X" + (this.valorN) + " = " + this.cromosoma[this.valorN - 1] + ", Valor de la función = " + this.getValor();
	}
	
	

}