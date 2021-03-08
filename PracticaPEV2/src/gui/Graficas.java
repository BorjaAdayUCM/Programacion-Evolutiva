package gui;

import java.util.ArrayList;

public class Graficas {
	private ArrayList<Integer> mejorAbsoluto;
	private ArrayList<Integer> mejorGeneracion;
	private ArrayList<Double> mediaGeneracion;
	private ArrayList<Double> desviacionTipicaGeneracion;
	private ArrayList<Double> presionSelectivaGeneracion;
	
	
	
	public Graficas() {
		super();
		this.mejorAbsoluto = new ArrayList<Integer>();
		this.mejorGeneracion = new ArrayList<Integer>();
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

	public ArrayList<Integer> getMejorAbsoluto() {
		return mejorAbsoluto;
	}
	
	public ArrayList<Integer> getMejorGeneracion() {
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
