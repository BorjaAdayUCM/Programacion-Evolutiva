package algoritmoGenetico.mutaciones;

import java.util.Random;

import algoritmoGenetico.individuos.Individuo;

public abstract class Mutacion {
	
	protected Individuo poblacion[];
	protected int tamPoblacion;
	protected Random rand;
	protected double probMutacion;
	
	public Mutacion(Individuo[] poblacion, int tamPoblacion, Random rand, double probMutacion) {
		super();
		this.poblacion = poblacion;
		this.tamPoblacion = tamPoblacion;
		this.rand = rand;
		this.probMutacion = probMutacion;
	}
	
	public abstract void run();
}
