package algoritmoGenetico.individuos;

import java.util.ArrayList;
import java.util.Random;

public class Arbol {

	private static final double PROB_FUNCION = 0.5;
	private String valor;
	private ArrayList<Arbol> hijos;
	private int numHijos;
	private int numNodos;
	private int max_prof; 
	private int profundidad;
	private boolean useIF;
	private boolean esHoja;
	private boolean esRaiz; 
	private ArrayList<String> terminales;
	
	public Arbol(int maxProf, boolean useIF, ArrayList<String> terminales) {
		this.max_prof = maxProf;
		this.useIF = useIF;
		this.terminales = terminales;
		this.hijos = new ArrayList<Arbol>();
	}
	
	public Arbol(String valor) {
		this.hijos = new ArrayList<Arbol>();
		this.valor = valor;
	}
	
	public String toString() {
		String valor = this.valor;
		if (!this.esHoja) {
			valor += "(";
			for (int i = 0; i < this.numHijos; i++) valor += this.hijos.get(i).toString();
			valor += ")";
		}
		return valor += " ";
	}
	
	public ArrayList<String> toArray(){
		ArrayList<String> array = new ArrayList<String>();
		toArrayAux(array, this);
		return array;
	}
	
	public Arbol insert(String valor, int index){
		Arbol a = new Arbol(valor);
		if(index == -1) {
			this.hijos.add(a);
			this.numHijos = this.hijos.size();
		}  
		else hijos.set(index, a);
		return a;
	}    
	
	public void insert(Arbol a, int index){
		if(index == -1){
			this.hijos.add(a);
			this.numHijos = this.hijos.size();
		}   
		else hijos.set(index, a);
	}  
	
	public Arbol at(int index){
		return at(this, 0, index);
	}    
	
	private Arbol at(Arbol a, int pos, int index){
		Arbol s = null;
		if(pos >= index) s = a;
		else if(a.getNumHijos() > 0) {
			for(int i = 0; i < a.getNumHijos(); i++) {
				if(s == null) s = at(a.hijos.get(i), pos + i + 1, index);
			}
		}
		return s;
	} 
	 
	private void toArrayAux(ArrayList<String> array, Arbol a){
		array.add(a.valor);
		for(int i = 0; i < a.hijos.size(); i++) toArrayAux(array, a.hijos.get(i));
	} 

	public int inicializacionCompleta(int p, int nodos){
		int n = nodos;
		int nHijos = 2;
		if(p < max_prof){
			this.setProfundidad(p);
			Random rnd = new Random();
			int func = 0;
			
			if(this.useIF) func = rnd.nextInt(Individuo.funciones.length);
			else func = rnd.nextInt(Individuo.funciones.length-1);
			
			this.valor = Individuo.funciones[func];
			this.setEsRaiz(true);
			
			if(this.valor.equals("IF")) nHijos = 3;
			if(this.valor.equals("NOT")) nHijos = 1;
			
			for(int i = 0; i < nHijos; i++){
				Arbol hijo = new Arbol(this.max_prof, this.useIF, this.terminales);
				this.esRaiz = true;
				n++;
				n = hijo.inicializacionCompleta(p + 1, n);
				this.hijos.add(hijo);
				this.numHijos++;   
			}  
		}  
		else{   
			this.setProfundidad(p);
			this.setEsHoja(true);
			this.valor = this.terminales.get(new Random().nextInt(this.terminales.size()));
			this.esHoja = true;
			this.numHijos = 0;
		}  
		
		this.setNumNodos(n);
		return n;
	}     
			 
	public int inicializacionCreciente(int p, int nodos) {
		int n = nodos;
		int nHijos = 2;
		if((p == 0) || (p < max_prof && Math.random() < PROB_FUNCION)){
			this.setProfundidad(p);
			Random rnd = new Random();
			int func = 0;
			
			if(this.useIF) func = rnd.nextInt(Individuo.funciones.length);
			else func = rnd.nextInt(Individuo.funciones.length-1);
			
			this.valor = Individuo.funciones[func];
			this.setEsRaiz(true);
			
			if(this.valor.equals("IF")) nHijos = 3;
			if(this.valor.equals("NOT")) nHijos = 1;
			
			for(int i = 0; i < nHijos; i++){
				Arbol hijo = new Arbol(this.max_prof, this.useIF, this.terminales);
				this.esRaiz = true;
				n++;
				n = hijo.inicializacionCreciente(p + 1, n);
				this.hijos.add(hijo);
				this.numHijos++;   
			}  
		}  
		else{   
			this.setProfundidad(p);
			this.setEsHoja(true);
			this.valor = this.terminales.get(new Random().nextInt(this.terminales.size()));
			this.esHoja = true;
			this.numHijos = 0;
		}  
		
		this.setNumNodos(n);
		return n;
	}
	
	@SuppressWarnings("unused")
	private int creaHijos(int p, int nodos) {
		int n = nodos;
		int nHijos = 2;
		
		if(this.valor.equals("IF")) nHijos = 3;
		if(this.valor.equals("NOT")) nHijos = 1;
		
		for(int i = 0; i < nHijos; i++){
			Arbol hijo = new Arbol(this.max_prof, this.useIF, this.terminales);
			n++;
			n = hijo.inicializacionCreciente(p+1, n);
			this.hijos.add(hijo); 
			this.numHijos++;
		} 
		return n;
	}
	
	public void getTerminales(ArrayList<Arbol> hijos, ArrayList<Arbol> nodos) {
		for(int i = 0; i < hijos.size(); i++) {
			if(hijos.get(i).isEsHoja())nodos.add(hijos.get(i));
			else getTerminales(hijos.get(i).hijos, nodos);
		}
	}
	
	public int insertTerminal(ArrayList<Arbol> list_hijos, Arbol terminal, int index, int pos){
		int p = pos;
		for(int i = 0; i < list_hijos.size() && p != -1; i++) {
			if(list_hijos.get(i).isEsHoja() && (p == index)) {
				list_hijos.set(i, terminal.copia());
				p = -1;
			}
			else if (list_hijos.get(i).esHoja && (p != index)) p++;
			else p = insertTerminal(list_hijos.get(i).hijos,terminal, index, p);
		}
		return p;
	}  
	
	public int insertFuncion(ArrayList<Arbol> list_hijos, Arbol terminal, int index, int pos){
		int p = pos;
		for(int i = 0; i < list_hijos.size() && p != -1; i++) {
			if(list_hijos.get(i).esRaiz && (p == index)) {
				list_hijos.set(i, terminal.copia());
				p = -1;
			}
			else if(list_hijos.get(i).esRaiz && (p != index)){
				p++;
				p = insertFuncion(list_hijos.get(i).hijos, terminal, index, p);
			}
		}
		return p;
	}
	
	public void getFunciones(ArrayList<Arbol> hijos, ArrayList<Arbol> nodos) {
		for(int i = 0; i < hijos.size(); i++){
			if(hijos.get(i).isEsRaiz()){
				nodos.add(hijos.get(i));
				getFunciones(hijos.get(i).hijos, nodos);
			}
		}
	}

	public Arbol copia(){
		Arbol copia = new Arbol(this.max_prof, this.useIF, this.terminales);
		copia.setEsHoja(this.esHoja);
		copia.setEsRaiz(this.esRaiz);
		copia.setNumHijos(this.numHijos);
		copia.setNumNodos(this.numNodos);
		copia.setProfundidad(this.profundidad);
		copia.setValor(this.valor);
		ArrayList<Arbol> aux = new ArrayList<Arbol>();
		aux = copiaHijos();
		copia.setHijos(aux);
		return copia;
	}
	
	private ArrayList<Arbol> copiaHijos() {
		ArrayList<Arbol> array = new ArrayList<Arbol>();
		for(int i = 0; i < this.hijos.size(); i++) array.add(this.hijos.get(i).copia());
		return array;
	}

	public int obtieneNodos(Arbol nodo, int n){
		if(nodo.esHoja) return n;
		if(nodo.valor.equals("IF")) {
			n = obtieneNodos(nodo.hijos.get(0), n + 1);
			n = obtieneNodos(nodo.hijos.get(1), n + 1);
			n = obtieneNodos(nodo.hijos.get(2), n + 1);
		}
		else if(nodo.valor.equals("AND") || nodo.valor.equals("OR")) {
			n = obtieneNodos(nodo.hijos.get(0), n + 1);
			n = obtieneNodos(nodo.hijos.get(1), n + 1);
		}
		else n = obtieneNodos(nodo.hijos.get(0), n + 1);
		return n;
	}
	
	public boolean evalua(boolean[] caso, ArrayList<String> terminales) {
		if(this.esHoja) return caso[terminales.indexOf(this.valor)];
		else {
			if(this.valor.equalsIgnoreCase("NOT")) return !this.hijos.get(0).evalua(caso, terminales);
			else if(this.valor.equalsIgnoreCase("OR")) return this.hijos.get(0).evalua(caso, terminales) || this.hijos.get(1).evalua(caso, terminales);
			else if(this.valor.equalsIgnoreCase("AND")) return this.hijos.get(0).evalua(caso, terminales) && this.hijos.get(1).evalua(caso, terminales);
			else if(this.valor.equalsIgnoreCase("IF")) {
				if(this.hijos.get(0).evalua(caso, terminales)) return this.hijos.get(1).evalua(caso, terminales);
				else return this.hijos.get(2).evalua(caso, terminales);
			}
		}
		return false;
	}
	
	public boolean equals(Arbol arbol) {
		boolean equalsIf = false;
		if(this.esHoja && arbol.esHoja && this.valor.equalsIgnoreCase(arbol.valor)) return true;
		if (this.valor.equalsIgnoreCase("NOT") && arbol.valor.equalsIgnoreCase("NOT")) return this.equals(arbol.hijos.get(0));
		else if (this.valor.equalsIgnoreCase("IF") && arbol.valor.equalsIgnoreCase("IF")) {
			Arbol hijo1 = arbol.hijos.get(0), hijo2 = arbol.hijos.get(1), hijo3 = arbol.hijos.get(2);
			if (this.hijos.get(1).valor.equalsIgnoreCase(hijo3.valor) && this.hijos.get(2).valor.equalsIgnoreCase(hijo2.valor) ) equalsIf = this.hijos.get(1).equals(hijo3) && this.hijos.get(2).equals(hijo2);
			else if (this.hijos.get(1).valor.equalsIgnoreCase(hijo2.valor) && this.hijos.get(2).valor.equalsIgnoreCase(hijo3.valor) ) equalsIf= this.hijos.get(1).equals(hijo2) && this.hijos.get(2).equals(hijo3);
			return this.hijos.get(0).equals(hijo1) && equalsIf; 
		}
		else if (this.valor.equalsIgnoreCase("OR") && arbol.valor.equalsIgnoreCase("OR") || this.valor.equalsIgnoreCase("AND") && arbol.valor.equalsIgnoreCase("AND")) {
			Arbol hijo1 = arbol.hijos.get(0), hijo2 = arbol.hijos.get(1);
			if (this.hijos.get(1).valor.equalsIgnoreCase(hijo1.valor) && this.hijos.get(0).valor.equalsIgnoreCase(hijo2.valor) ) return this.hijos.get(1).equals(hijo1) && this.hijos.get(0).equals(hijo2);
			else if ( this.hijos.get(1).valor.equalsIgnoreCase(hijo2.valor) && this.hijos.get(0).valor.equalsIgnoreCase(hijo1.valor) ) return this.hijos.get(1).equals(hijo2) && this.hijos.get(0).equals(hijo1);
		}
		return false;
	}
	
	public void convierteEnTerminal() {
		this.valor = this.terminales.get(new Random().nextInt(this.terminales.size()));
		this.esHoja = true;
		this.esRaiz = false;
		this.numHijos = 0;
		this.numNodos = 0;
		this.hijos.clear();
	}
	
	public void intercambia(Arbol nodoIntercambiar) {
		this.valor = nodoIntercambiar.valor;
		this.esHoja = nodoIntercambiar.esHoja;
		this.esRaiz = nodoIntercambiar.esRaiz;
		this.numHijos = nodoIntercambiar.numHijos;
		this.numNodos = nodoIntercambiar.numNodos;
		this.profundidad = nodoIntercambiar.profundidad;
		this.useIF = nodoIntercambiar.useIF;
		this.terminales = nodoIntercambiar.terminales;
		this.max_prof = nodoIntercambiar.max_prof;
		this.hijos = nodoIntercambiar.hijos;
	}
	
	public void corrigeArbol() {
		this.corrigeIntrones();
		this.numNodos = this.CorrigeNumNodos();
	}
	
	public int CorrigeNumNodos() {
		if(this.esHoja) {
			this.numNodos = 1;
			return 1;
		}
		else {
			this.numNodos = 0;
			for(int i = 0; i < this.numHijos; i++) this.numNodos += this.hijos.get(i).CorrigeNumNodos();
			return this.numNodos + 1;
		}
	}
	
	public void corrigeIntrones() {
		for(int i = 0; i < this.hijos.size(); i++) this.hijos.get(i).corrigeIntrones();
		
		if(this.valor.equalsIgnoreCase("NOT") && this.hijos.get(0).valor.equalsIgnoreCase("NOT")) this.intercambia(this.hijos.get(0).hijos.get(0));
		else if((this.valor.equalsIgnoreCase("OR") || this.valor.equalsIgnoreCase("AND")) && this.hijos.get(0).equals(this.hijos.get(1))) this.intercambia(this.hijos.get(0));
		else if(this.valor.equalsIgnoreCase("IF") && this.hijos.get(1).equals(this.hijos.get(2))) this.intercambia(this.hijos.get(1));
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public ArrayList<Arbol> getHijos() {
		return hijos;
	}

	public void setHijos(ArrayList<Arbol> hijos) {
		this.hijos = hijos;
	}

	public int getNumHijos() {
		return numHijos;
	}

	public void setNumHijos(int numHijos) {
		this.numHijos = numHijos;
	}

	public int getNumNodos() {
		return numNodos;
	}

	public void setNumNodos(int numNodos) {
		this.numNodos = numNodos;
	}

	public int getMax_prof() {
		return max_prof;
	}

	public void setMax_prof(int max_prof) {
		this.max_prof = max_prof;
	}

	public int getProfundidad() {
		return profundidad;
	}

	public void setProfundidad(int profundidad) {
		this.profundidad = profundidad;
	}

	public boolean isUseIF() {
		return useIF;
	}

	public void setUseIF(boolean useIF) {
		this.useIF = useIF;
	}

	public boolean isEsHoja() {
		return esHoja;
	}

	public void setEsHoja(boolean esHoja) {
		this.esHoja = esHoja;
	}

	public boolean isEsRaiz() {
		return esRaiz;
	}

	public void setEsRaiz(boolean esRaiz) {
		this.esRaiz = esRaiz;
	}

	public ArrayList<String> getTerminales() {
		return terminales;
	}

	public void setTerminales(ArrayList<String> terminales) {
		this.terminales = terminales;
	}
	
	
	
}
