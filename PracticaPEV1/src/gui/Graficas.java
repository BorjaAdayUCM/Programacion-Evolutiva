package gui;

import java.util.ArrayList;

public class Graficas {
	private ArrayList<Double> mejorAbsoluto;
	private ArrayList<Double> mejorGeneracion;
	private ArrayList<Double> mediaGeneracion;
	private ArrayList<Double> desviacionTipicaGeneracion;
	private ArrayList<Double> presionSelectivaGeneracion;
	
	
	
	public Graficas() {
		super();
		this.mejorAbsoluto = new ArrayList<Double>();
		this.mejorGeneracion = new ArrayList<Double>();
		this.mediaGeneracion = new ArrayList<Double>();
		this.desviacionTipicaGeneracion = new ArrayList<Double>();
		this.presionSelectivaGeneracion = new ArrayList<Double>();
	}
	
	public void clear() {
		this.mejorAbsoluto.clear();
		this.mejorGeneracion.clear();
		this.mediaGeneracion.clear();
		this.desviacionTipicaGeneracion.clear();
		this.presionSelectivaGeneracion.clear();
	}

	public ArrayList<Double> getMejorAbsoluto() {
		return mejorAbsoluto;
	}
	
	public ArrayList<Double> getMejorGeneracion() {
		return mejorGeneracion;
	}

	public ArrayList<Double> getMediaGeneracion() {
		return mediaGeneracion;
	}
	
	public ArrayList<Double> getDesviacionTipicaGeneracion() {
		return desviacionTipicaGeneracion;
	}
	
	public ArrayList<Double> getPresionSelectivaGeneracion() {
		return this.presionSelectivaGeneracion;
	}
	
	
}
