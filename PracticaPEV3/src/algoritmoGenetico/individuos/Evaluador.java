package algoritmoGenetico.individuos;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Evaluador extends Thread {
	
	private int ini, fin;
	private AtomicInteger aciertos;
	private boolean[][] casos;
	private boolean[] soluciones;
	private Arbol arbol;
	private ArrayList<String> terminales;
	
	@SuppressWarnings("deprecation")
	public Evaluador(int ini, int fin, boolean[][] casos, boolean[] soluciones, Arbol arbol, ArrayList<String> terminales, AtomicInteger aciertos) {
		this.ini = new Integer(ini);
		this.fin = new Integer(fin);
		this.aciertos = aciertos;
		this.casos = casos;
		this.soluciones = soluciones;
		this.arbol = arbol;
		this.terminales = terminales;
	}
	
	public void run() {
		for(; ini < fin ; ini++) {
			if(this.arbol.evalua(this.casos[ini], this.terminales) == this.soluciones[ini]) this.aciertos.incrementAndGet();
		}
	}
	
}
