package algoritmoGenetico.seleccion;

import java.util.Random;

import algoritmoGenetico.individuos.Individuo;

public abstract class Seleccion {
	
	protected int tamTorneo;
	protected double escogerMejor;
	protected double fitness[];
	protected Individuo poblacion[];
	protected int tamPoblacion;
	protected double umbralTruncamiento;
	protected Random rand;
	
	public Seleccion(double[] fitness, Individuo[] poblacion, int tamPoblacion, Random rand, int tamTorneo, double escogerMejor, double umbralTruncamiento) {
		super();
		this.escogerMejor = escogerMejor;
		this.tamTorneo = tamTorneo;
		this.fitness = fitness;
		this.poblacion = poblacion;
		this.tamPoblacion = tamPoblacion;
		this.umbralTruncamiento = umbralTruncamiento;
		this.rand = rand;
	}
	
	public abstract Individuo[] run();
	
}