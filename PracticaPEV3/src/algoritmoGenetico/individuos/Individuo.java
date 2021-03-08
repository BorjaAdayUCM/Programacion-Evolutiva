package algoritmoGenetico.individuos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Individuo {
	
	private int aciertos;
	private Random random;
	private Arbol arbol;
	private int tipoMultiplexor;
	private ArrayList<String> terminales;
	public static final String terminales6[] = {"A0", "A1", "D0", "D1", "D2", "D3" };
	public static final String terminales11[] = {"A0", "A1", "A3", "D0", "D1", "D2", "D3", "D4", "D5", "D6", "D7"};
	public static final String funciones[] = { "AND", "OR", "NOT", "IF" };
	private boolean[][] casos;
	private boolean[] soluciones;
	
	
	
	public Individuo(int profundidad, String tipoCreacion, boolean useIf, int tipoMultiplexor, boolean[][] casos, boolean[] soluciones) {
		this.tipoMultiplexor = tipoMultiplexor;
		switch(this.tipoMultiplexor) {
			case 2: this.terminales = new ArrayList<String>(Arrays.asList(terminales6)); break;
			case 3: this.terminales = new ArrayList<String>(Arrays.asList(terminales11)); break;
		}
		this.arbol = new Arbol(profundidad, useIf, this.terminales);
		this.casos = casos;
		this.soluciones = soluciones;
		this.random = new Random();
		
		switch(tipoCreacion){
			case "Inicializacion creciente": this.arbol.inicializacionCreciente(0, 0); break;
			case "Inicializacion completa": this.arbol.inicializacionCompleta(0,0); break;
			case "Inicializacion ramped & half": {
				if(new Random().nextInt(2) == 0) this.arbol.inicializacionCreciente(0, 0);
				else this.arbol.inicializacionCompleta(0,0);
				break;
			}
		}
	}
	
	public Individuo(Individuo individuo) {
		this.arbol = individuo.arbol.copia();
		this.tipoMultiplexor = individuo.tipoMultiplexor;
		this.terminales = new ArrayList<String>(individuo.terminales);
		this.casos = individuo.casos;
		this.soluciones = individuo.soluciones;
		this.random = individuo.random;
		this.aciertos = individuo.aciertos;
	}
	
	public int getAciertosConcurrente(int numHebras) {
		AtomicInteger aciertos = new AtomicInteger(0);
		try {
			int ini = 0, fin = ini + this.soluciones.length / numHebras;
			
			ArrayList<Evaluador> hebras = new ArrayList<Evaluador>();
			for(int i = 0; i < numHebras; i++) {
				hebras.add(new Evaluador(ini, fin, this.casos, this.soluciones, this.arbol, this.terminales, aciertos));
				ini = fin;
				fin = ini + this.soluciones.length / numHebras;
			}
			for(int i = 0; i < numHebras; i++) hebras.get(i).start();
			for(int i = 0; i < numHebras; i++) hebras.get(i).join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return aciertos.get();
	}
	
	public int getAciertosLineal() {
		int aciertos = 0;
		for(int i = 0; i < this.casos.length; i++) {
			if(this.arbol.evalua(this.casos[i], this.terminales) == this.soluciones[i]) aciertos++;
		}
		return aciertos;
	}
	
	public double getFitness(String tipoEvaluacion, int numHebras) {
		int aciertos;
		if(tipoEvaluacion.equalsIgnoreCase("Evaluacion lineal")) aciertos = this.getAciertosLineal();
		else aciertos = this.getAciertosConcurrente(numHebras);
		this.aciertos = aciertos;
		return aciertos;
	}

	public double getFitnessTarpeian(int aciertos, double mediaTam, double limitacion, String tipoEvaluacion, int numHebras) {
		if(this.arbol.getNumNodos() > mediaTam) {
			double penalizacion = (limitacion * aciertos) / 100;
			double nodosExtra = this.arbol.getNumNodos() - mediaTam;
			double fitness = aciertos - (penalizacion * (Math.log(Math.max(1, nodosExtra)) / 3));
			if(fitness <= 0) return 0;
			else return fitness;
		}
		else return aciertos;
	}
	
	public double getFitnessPenalizacion(int aciertos, double penalizacion, String tipoEvaluacion, int numHebras) {
		if(penalizacion <= 0) return aciertos;
		else return aciertos - (penalizacion * this.arbol.getNumNodos());
	}

	@Override
	public String toString() {
		return this.arbol.toString();
	}

	public void mutacionFuncionalSimple() {
		ArrayList<Arbol> nodos = new ArrayList<Arbol>();
        this.arbol.getFunciones(this.arbol.getHijos(), nodos);
        if (nodos.size() > 0) {
            int i = 0, nodoAleatorio = this.random.nextInt(nodos.size());
            while(i < 50 && nodos.get(nodoAleatorio).getValor().equalsIgnoreCase("OR") && nodos.get(nodoAleatorio).getValor().equalsIgnoreCase("AND")) {
                nodoAleatorio = this.random.nextInt(nodos.size());
                i++;
            }
            if(nodos.get(nodoAleatorio).getValor().equalsIgnoreCase("OR")) nodos.get(nodoAleatorio).setValor("AND");
            else if(nodos.get(nodoAleatorio).getValor().equalsIgnoreCase("AND")) nodos.get(nodoAleatorio).setValor("OR");
        }
	}
	
	public void mutacionTerminalSimple() {
		ArrayList<Arbol> nodos = new ArrayList<Arbol>();
        this.arbol.getTerminales(this.arbol.getHijos(), nodos);
        if (nodos.size() > 0) {
            nodos.get(this.random.nextInt(nodos.size())).setValor(this.terminales.get(this.random.nextInt(this.terminales.size())));
        }
	}
	
	public void mutacionPermutacion() {
		ArrayList<Arbol> nodos = new ArrayList<Arbol>();
        this.arbol.getFunciones(this.arbol.getHijos(), nodos);
        if (nodos.size() > 0) {
        	int contador = 0;
        	Arbol nodoAleatorio = nodos.get(this.random.nextInt(nodos.size()));
        	while(contador < 50 && !nodoAleatorio.getValor().equalsIgnoreCase("IF")) {
        		contador++;
        		nodoAleatorio = nodos.get(this.random.nextInt(nodos.size()));
        	}
        	//No tiene sentido permutar los hijos de and o or.
        	if(nodoAleatorio.getValor().equalsIgnoreCase("IF")) {
        		int nodo1 = this.random.nextInt(nodoAleatorio.getHijos().size()), nodo2;
            	nodo2 = this.random.nextInt(nodoAleatorio.getHijos().size());
            	while(nodo2 == nodo1) nodo2 = this.random.nextInt(nodoAleatorio.getHijos().size());
            	Arbol aux = nodoAleatorio.getHijos().get(nodo1);
            	nodoAleatorio.getHijos().set(nodo1, nodoAleatorio.getHijos().get(nodo2));
            	nodoAleatorio.getHijos().set(nodo2, aux);
        	}
        }
	}
	
	public void mutacionHoist() {
		ArrayList<Arbol> nodos = new ArrayList<Arbol>();
        this.arbol.getFunciones(this.arbol.getHijos(), nodos);
        if (nodos.size() > 0) this.arbol = nodos.get(this.random.nextInt(nodos.size()));
	}
	
	public void mutacionExpansion() {
		ArrayList<Arbol> nodos = new ArrayList<Arbol>();
        this.arbol.getTerminales(this.arbol.getHijos(), nodos);
        if (nodos.size() > 0) {
        	Arbol arbol = new Arbol(2 + this.random.nextInt(3), nodos.get(0).isUseIF(), nodos.get(0).getTerminales());
        	arbol.inicializacionCreciente(0,  0);
        	nodos.get(this.random.nextInt(nodos.size())).intercambia(arbol);
        	this.arbol.corrigeArbol();
        }
	}
	
	public void mutacionContraccion() {
		ArrayList<Arbol> nodos = new ArrayList<Arbol>();
        this.arbol.getFunciones(this.arbol.getHijos(), nodos);
        if (nodos.size() > 0) {
        	nodos.get(this.random.nextInt(nodos.size())).convierteEnTerminal();
        	this.arbol.corrigeArbol();
        }
	}
	
	public void mutacionSubarbol() {
		ArrayList<Arbol> nodos = new ArrayList<Arbol>();
        this.arbol.getFunciones(this.arbol.getHijos(), nodos);
        if (nodos.size() > 0) {
        	Arbol arbol = new Arbol(2 + this.random.nextInt(3), nodos.get(0).isUseIF(), nodos.get(0).getTerminales());
        	arbol.inicializacionCreciente(0,  0);
        	nodos.get(this.random.nextInt(nodos.size())).intercambia(arbol);
        	this.arbol.corrigeArbol();
        }
	}

	public Arbol getArbol() {
		return this.arbol;
	}

	public int getAciertos() {
		return this.aciertos;
	}
	
	
}
