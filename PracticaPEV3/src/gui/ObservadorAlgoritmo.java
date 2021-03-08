package gui;


public interface ObservadorAlgoritmo {
	
	public void inicia();
	
	public void actualiza(int generacionActual, int maxGeneraciones, DatosTabla datosTabla);
	
	public void finaliza();
}