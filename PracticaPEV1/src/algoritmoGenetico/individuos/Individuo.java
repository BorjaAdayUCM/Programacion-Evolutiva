package algoritmoGenetico.individuos;

import java.util.Random;

@SuppressWarnings("rawtypes")
public abstract class Individuo<T> {
	
	protected T[] cromosoma;
	protected int[] tamGenes;
	protected Random rand;
	protected double[] min;
	protected double[] max;
	protected double valorError;
	
	public Individuo(double valorError) {
		this.valorError = valorError;
		this.rand = new Random();
	}
	
	public Individuo(Individuo individuo) {
		this.tamGenes = new int[individuo.tamGenes.length];
		for(int i = 0; i < individuo.tamGenes.length; i++) this.tamGenes[i] = individuo.tamGenes[i];
		this.min = new double[individuo.min.length];
		for(int i = 0; i < individuo.min.length; i++) this.min[i] = individuo.min[i];
		this.max = new double[individuo.max.length];
		for(int i = 0; i < individuo.max.length; i++) this.max[i] = individuo.max[i];
		this.rand = individuo.rand;
	}
	
	public T[] getCromosoma() {
		return this.cromosoma;
	}
	
	public int tamGen(double valorError, double min, double max) {
		return (int) (Math.log10(((max - min) / valorError) + 1) / Math.log10(2));
	}
	
	public double getFenotipo(int numVariable) {
		int inicio = 0, contador = 0;
		double valor = 0;
		
		for(int i = 0; i < numVariable; i++) inicio += this.tamGenes[i];
		for(int i = inicio; i < inicio + this.tamGenes[numVariable]; i++) {
			if((boolean) this.cromosoma[i]) valor += Math.pow(2, this.tamGenes[numVariable] - (1 + contador));
			contador++;
		}
		return this.min[numVariable] + (valor * ((this.max[numVariable] - this.min[numVariable]) / ((Math.pow(2, this.tamGenes[numVariable]) - 1))));
	}
	
	public double getTamIntervaloVariable(int numVariable) {
		return this.max[numVariable] - this.min[numVariable];
	}
	
	public abstract void mutacionBasica();
	
	public abstract void mutacionUniforme();
	
	public abstract double getValor();
	
	public abstract double getFitness();
	
}
