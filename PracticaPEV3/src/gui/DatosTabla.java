package gui;

public class DatosTabla {
	private int generacionActual, mejor;
	private double mediaNodos, mediaFitness;
	
	public DatosTabla(int generacionActual, int mejor, double mediaNodos, double mediaFitness) {
		super();
		this.generacionActual = generacionActual;
		this.mejor = mejor;
		this.mediaNodos = mediaNodos;
		this.mediaFitness = mediaFitness;
	}

	public int getGeneracionActual() {
		return generacionActual;
	}

	public int getMejor() {
		return mejor;
	}

	public double getMediaNodos() {
		return mediaNodos;
	}

	public double getMediaFitness() {
		return mediaFitness;
	}
	
	
	
}