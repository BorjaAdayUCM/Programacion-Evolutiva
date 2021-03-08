package algoritmoGenetico.cruces;

import java.util.ArrayList;
import java.util.Random;

import algoritmoGenetico.individuos.Arbol;
import algoritmoGenetico.individuos.Individuo;

public class CruceSimple extends Cruce {
	
	private static final double PROB_FUNC = 0.9;

	public CruceSimple(Individuo[] poblacion, int tamPoblacion, Random rand, double probCruce, int numProblema) {
		super(poblacion, tamPoblacion, rand, probCruce, numProblema);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Individuo[] run() {
		Individuo[] nuevaPoblacion = new Individuo[this.tamPoblacion];
		for(int i = 0; i < this.tamPoblacion; i++) nuevaPoblacion[i] = new Individuo(this.poblacion[i]);
		for(int i = 0; i < this.tamPoblacion - 1; i+=2) {
			if(this.rand.nextDouble() < this.probCruce) {
				ArrayList<Arbol> nodos_selec1 = new ArrayList<Arbol>();
				ArrayList<Arbol> nodos_selec2 = new ArrayList<Arbol>();
				
				nodos_selec1 = obtieneNodos(this.poblacion[i].getArbol().copia());
				nodos_selec2 = obtieneNodos(this.poblacion[i + 1].getArbol().copia());
				
				//obtenemos los puntos de cruce a partir de los nodos seleccionados
				int puntoCruce1 = (int) (Math.random()*nodos_selec1.size());
				int puntoCruce2 = (int) (Math.random()*nodos_selec2.size());
				
				//Cogemos los nodos de cruce seleccionados
				Arbol temp1 = nodos_selec1.get(puntoCruce1).copia();
				Arbol temp2 = nodos_selec2.get(puntoCruce2).copia();
				
				//realizamos el corte sobre los arboles de los hijos
				corte(nuevaPoblacion[i], temp2, puntoCruce1, temp1.isEsRaiz());
				corte(nuevaPoblacion[i + 1], temp1, puntoCruce2, temp2.isEsRaiz());
				int nodos = nuevaPoblacion[i].getArbol().obtieneNodos(nuevaPoblacion[i].getArbol(), 0);
				nuevaPoblacion[i].getArbol().setNumNodos(nodos);
				nodos = nuevaPoblacion[i + 1].getArbol().obtieneNodos(nuevaPoblacion[i + 1].getArbol(), 0);
				nuevaPoblacion[i + 1].getArbol().setNumNodos(nodos);
			}
		}
		return nuevaPoblacion;
	}
	
	private void corte(Individuo hijo, Arbol temp, int puntoCruce, boolean esRaiz) {
		if(!esRaiz) hijo.getArbol().insertTerminal(hijo.getArbol().getHijos(), temp, puntoCruce, 0);
		else hijo.getArbol().insertFuncion(hijo.getArbol().getHijos(), temp, puntoCruce, 0);
	}
	
	private ArrayList<Arbol> obtieneNodos(Arbol arbol) {
		ArrayList<Arbol> nodos = new ArrayList<Arbol>();
		if(Math.random() < PROB_FUNC) {
			//Si devuelve true, el corte se hará en una función
			arbol.getFunciones(arbol.getHijos(), nodos);
			if(nodos.size() == 0) {
				//Si no existen funciones, se seleccionan los terminales
				arbol.getTerminales(arbol.getHijos(), nodos);
			}
		}
		else {
			//Si devuelve false, el corte se hará por un terminal
			arbol.getTerminales(arbol.getHijos(), nodos);
		}
		return nodos;
	}

}
