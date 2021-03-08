package algoritmoGenetico.seleccion;

import java.util.Random;

import algoritmoGenetico.individuos.Individuo;

@SuppressWarnings("rawtypes")
public abstract class Seleccion {
	
	protected int tamTorneo;
	protected double escogerMejor;
	protected int numProblema;
	protected double fitnessTotal;
	protected double fitness[];
	protected Individuo poblacion[];
	protected int tamPoblacion;
	protected double umbralTruncamiento;
	protected Random rand;
	
	public Seleccion(double[] fitness, Individuo[] poblacion, int tamPoblacion, Random rand, int tamTorneo, double escogerMejor, double umbralTruncamiento, int numProblema) {
		super();
		this.escogerMejor = escogerMejor;
		this.tamTorneo = tamTorneo;
		this.numProblema = numProblema;
		this.fitness = fitness;
		this.poblacion = poblacion;
		this.tamPoblacion = tamPoblacion;
		this.umbralTruncamiento = umbralTruncamiento;
		this.rand = rand;
	}
	
	public abstract Individuo[] run();
	
}