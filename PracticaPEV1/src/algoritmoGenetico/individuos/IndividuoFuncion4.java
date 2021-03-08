package algoritmoGenetico.individuos;

public class IndividuoFuncion4 extends Individuo<Boolean> {

	protected int valorN;
	
	public IndividuoFuncion4(int valorN, double valorError) {
		super(valorError);
		this.valorN = valorN;
		this.tamGenes = new int[valorN];
		this.min = new double[valorN];
		this.max = new double[valorN];
		for(int i = 0; i < valorN; i++) {
			this.min[i] = 0.000;
			this.max[i] = 180.000;
			this.tamGenes[i] = this.tamGen(valorError, min[i], max[i]);
		}
		int tamTotal = 0;
		for(int i = 0; i < valorN; i++) tamTotal += this.tamGenes[i];
		this.cromosoma = new Boolean[tamTotal];
		for(int i = 0; i < tamTotal; i++) this.cromosoma[i] = this.rand.nextBoolean();
	}
	
	public IndividuoFuncion4(IndividuoFuncion4 individuo) {
		super(individuo);
		this.cromosoma = new Boolean[individuo.cromosoma.length];
		for(int i = 0; i < individuo.cromosoma.length; i++) this.cromosoma[i] = (Boolean) individuo.cromosoma[i];
		this.valorN = individuo.valorN;
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
		double valor = 0;
		for(int i = 1; i <= this.valorN; i++) {
			double x = this.getFenotipo(i - 1);
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
		for(int i = 0; i < this.valorN - 1; i++) text += "X" + (i + 1) + " = " + this.getFenotipo(i) + ", ";
		return text + "X" + (this.valorN) + " = " + this.getFenotipo(this.valorN - 1) + ", Valor de la función = " + this.getValor();
	}
}