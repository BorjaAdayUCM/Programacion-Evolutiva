package algoritmoGenetico.individuos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class Individuo {
	
	public ArrayList<Integer> cromosoma;
	protected Random rand;
	protected int[][] matFlujo;
	protected int[][] matDistancias;
	
	public Individuo(int[][] matFlujo, int [][] matDistancias, Random rand) {
		this.matFlujo = matFlujo;
		this.matDistancias = matDistancias;
		this.cromosoma = new ArrayList<Integer>();
		this.rand = rand;
		for(int i = 0; i < matDistancias.length; i++) this.cromosoma.add(i);
		for(int i = 0; i < this.cromosoma.size() * 2; i++) {
			int pos1 = this.rand.nextInt(this.cromosoma.size()), pos2 = this.rand.nextInt(this.cromosoma.size()), aux = this.cromosoma.get(pos1);
			this.cromosoma.set(pos1, this.cromosoma.get(pos2));
			this.cromosoma.set(pos2, aux);
		}
	}; 
	
	public Individuo(Individuo individuo) {
		this.matFlujo = individuo.matFlujo;
		this.matDistancias = individuo.matDistancias;
		this.rand = individuo.rand;
		this.cromosoma = new ArrayList<Integer>();
		for(int i = 0; i < individuo.cromosoma.size(); i++) this.cromosoma.add(individuo.cromosoma.get(i));
	}
	
	protected ArrayList<Integer> getCromosoma() {
		return this.cromosoma;
	}
	
	public void mutacionInsercion() {
		
		int posCambiar = this.rand.nextInt(this.cromosoma.size()), num = this.rand.nextInt(this.cromosoma.size());
		
		//Encontrar posNumero
		int posNumero = this.cromosoma.indexOf(num);
		
		if(posCambiar < posNumero) {
			for(int i = posNumero; i > posCambiar; i--) {
				this.cromosoma.set(i, this.cromosoma.get(i - 1));
			}
		}
		else if(posCambiar > posNumero) {
			for(int i = posNumero; i < posCambiar; i++) {
				this.cromosoma.set(i, this.cromosoma.get(i + 1));
			}
		}
		this.cromosoma.set(posCambiar,  num);
	}
	
	public void mutacionIntercambio() {
		int pos1 = this.rand.nextInt(this.cromosoma.size()), pos2 = this.rand.nextInt(this.cromosoma.size()), aux = this.cromosoma.get(pos1);
		this.cromosoma.set(pos1, this.cromosoma.get(pos2));
		this.cromosoma.set(pos2, aux);
	}
	
	public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> array) {
		ArrayList<ArrayList<Integer>> mat = new ArrayList<ArrayList<Integer>>();

		if( array.size() == 1 ){
			mat.add( new ArrayList<Integer>(array) );
		    return mat;
		}
		
		for( int i = 0 ; i < array.size(); i++ ){
		    int current = array.get( i );
		    ArrayList<Integer> tmp = new ArrayList<Integer>(array);
		    tmp.remove( i );

		   ArrayList<ArrayList<Integer>> res = permute(tmp);
		   
		   for( int j = 0 ; j < res.size() ; j++ ){
		       ArrayList<Integer> toAdd = new ArrayList<Integer>();
		       toAdd.add( current );
		       toAdd.addAll( res.get( j ) );
		       
		       mat.add( toAdd );
		   }
		}
		
		return mat;
	}
	
	public void mutacionHeuristica() {
		ArrayList<Integer> posAzar = new ArrayList<Integer>();
		while(posAzar.size() < 3) {
			int numAleatorio = this.rand.nextInt(this.cromosoma.size());
			if(!posAzar.contains(numAleatorio)) posAzar.add(numAleatorio);
		}
		
		ArrayList<Integer> numPosiciones = new ArrayList<Integer>();
		for(int i = 0; i < 3; i++) {
			numPosiciones.add(this.cromosoma.get(posAzar.get(i)));
		}
		
		ArrayList<Individuo> nuevaPoblacion = new ArrayList<Individuo>();
		ArrayList<ArrayList<Integer>> mat = this.permute(numPosiciones);
		for(int i = 0; i < 6; i++) {
			nuevaPoblacion.add(new Individuo(this));
			for(int j = 0; j < 3; j++) {
				nuevaPoblacion.get(i).cromosoma.set(posAzar.get(j), mat.get(i).get(j));
			}
		}
		
		Individuo individuoFinal = null;
		double max = Double.MIN_VALUE;
		for(Individuo ind: nuevaPoblacion) {
			if(ind.getFitness() > max) {
				max = ind.getFitness();
				individuoFinal = ind;
			}
		}
		
		this.cromosoma = individuoFinal.cromosoma;
	}
	
	public void mutacionInversion() {
		int corte1 = this.rand.nextInt(this.cromosoma.size()), corte2 = this.rand.nextInt(this.cromosoma.size());
		if(corte1 > corte2) {
			int auxCorte1 = corte1;
			corte1 = corte2;
			corte2 = auxCorte1;
		}
		
		
		if(corte1 != corte2) {
			ArrayList<Integer> cromosomaReverse = new ArrayList<Integer>(this.cromosoma.subList(corte1, corte2 + 1));
			Collections.reverse(cromosomaReverse);
			
			int w = 0;
			for(int i = corte1; i <= corte2; i++) {
				this.cromosoma.set(i, cromosomaReverse.get(w));
				w++;
			}
		}
		if(!this.valido()) System.err.println("ERROR");
	}
	
	public int getFitness() {
		int fitness = 0;
		for(int i = 0; i < this.matDistancias.length; i++) {
			for(int j = 0; j < this.matDistancias.length; j++) {
				fitness += this.matDistancias[i][j] * this.matFlujo[this.cromosoma.get(i)][this.cromosoma.get(j)];
			}
		}
		return fitness;
	}
	
	public boolean valido() {
		for(int i = 0; i < this.cromosoma.size(); i++) {
			if(this.cromosoma.get(i) == -1) return false;
			for(int j = 0; j < this.cromosoma.size(); j++) {
				if(i != j && this.cromosoma.get(i).equals(this.cromosoma.get(j))) return false;
			}
		}
		return true;
	}
	
	@Override
	public String toString() {
		String text = "";
		for(int i = 0; i < this.cromosoma.size() - 1; i++) {
			text += this.cromosoma.get(i) + " ";
		}
		text += this.cromosoma.get(this.cromosoma.size() - 1) + ": " + this.getFitness();
		return text;
	}

	
	
}
