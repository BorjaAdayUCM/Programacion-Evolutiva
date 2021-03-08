package algoritmoGenetico.cruces;

import java.util.Random;

import algoritmoGenetico.individuos.Individuo;

@SuppressWarnings("rawtypes")
public abstract class Cruce {
	
	protected Individuo poblacion[];
	protected int tamPoblacion;
	protected Random rand;
	protected double probCruce;
	protected int numProblema;
	protected int valorN;
	
	public Cruce(Individuo[] poblacion, int tamPoblacion, Random rand, double probCruce, int numProblema) {
		super();
		this.poblacion = poblacion;
		this.tamPoblacion = tamPoblacion;
		this.rand = rand;
		this.probCruce = probCruce;
		this.numProblema = numProblema;
	}
	
	public abstract Individuo[] run();
	
}
