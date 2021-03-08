package algoritmoGenetico;

import java.util.Random;
import algoritmoGenetico.cruces.CruceAritmetico;
import algoritmoGenetico.cruces.CruceBLX;
import algoritmoGenetico.cruces.CruceMonopunto;
import algoritmoGenetico.cruces.CruceSBX;
import algoritmoGenetico.cruces.CruceUniforme;
import algoritmoGenetico.individuos.Individuo;
import algoritmoGenetico.individuos.IndividuoFuncion1;
import algoritmoGenetico.individuos.IndividuoFuncion2;
import algoritmoGenetico.individuos.IndividuoFuncion3;
import algoritmoGenetico.individuos.IndividuoFuncion4;
import algoritmoGenetico.individuos.IndividuoFuncion5;
import algoritmoGenetico.mutaciones.MutacionBasica;
import algoritmoGenetico.mutaciones.MutacionUniforme;
import algoritmoGenetico.seleccion.SeleccionEstocasticaUniversal;
import algoritmoGenetico.seleccion.SeleccionRestos;
import algoritmoGenetico.seleccion.SeleccionRuleta;
import algoritmoGenetico.seleccion.SeleccionTorneoDeterministico;
import algoritmoGenetico.seleccion.SeleccionTorneoProbabilistico;
import algoritmoGenetico.seleccion.SeleccionTruncamiento;
import gui.Graficas;

@SuppressWarnings("rawtypes")
public class AlgoritmoGenetico {
	
	private int tamPoblacion;
	private Individuo[] poblacion;
	private Individuo[] elite;
	private double[] fitness;
	private int maxGeneraciones;
	private double probCruce;
	private double probMutacion;
	private double probElitismo;
	private Graficas grafica;
	private int numProblema;
	private String tipoSeleccion;
	private String tipoCruce;
	private String tipoMutacion;
	private int generacionActual;
	private Individuo mejorIndividuo;
	private Individuo mejorIndividuoGeneracion;
	private Random rand;
	private int valorN;
	private double valorError;
	private double escogerMejor;
	private int tamTorneo;
	private double umbralTruncamiento;
	private boolean variedad;
	
	public AlgoritmoGenetico() {
		super();
		this.grafica = new Graficas();
		this.rand = new Random();
	}
	
	public void corrigeMaximizar(double min) {
		min *= 1.05;
		for(int i = 0; i < this.tamPoblacion; i++) this.fitness[i] = this.fitness[i] + Math.abs(min);
	}
	
	public void corrigeMinimizar(double max) {
		max *= 1.05;
		for(int i = 0; i < this.tamPoblacion; i++) this.fitness[i] = max - this.fitness[i];
	}
	
	public void evaluar() {
		//Evaluacion y calculo de min y max
		double min = Double.MAX_VALUE, max = Double.MIN_VALUE;
		for(int i = 0; i < this.tamPoblacion; i++) {
			this.fitness[i] = this.poblacion[i].getFitness();
			if(this.fitness[i] < min) min = this.fitness[i];
			if(this.fitness[i] > max) max = this.fitness[i];
		}
		
		//Correccion Evaluacion
		if(this.numProblema == 1) this.corrigeMaximizar(min);
		else this.corrigeMinimizar(max);
		
		double fitnessTotal = 0.0;
		for(int i = 0; i < this.tamPoblacion; i++) fitnessTotal += this.fitness[i];
		for(int i = 0; i < this.tamPoblacion; i++) this.fitness[i] = this.fitness[i] / fitnessTotal;
		this.quicksort(0, this.tamPoblacion - 1);
	}
	
	public void iniciarPoblacion() {
		this.generacionActual = 0;
		for(int i = 0; i < this.tamPoblacion; i++) {
			switch(this.numProblema) {
				case 1: this.poblacion[i] = new IndividuoFuncion1(this.valorError); break;
				case 2: this.poblacion[i] = new IndividuoFuncion2(this.valorError); break;
				case 3: this.poblacion[i] = new IndividuoFuncion3(this.valorError); break;
				case 4: this.poblacion[i] = new IndividuoFuncion4(this.valorN, this.valorError); break;
				case 5: this.poblacion[i] = new IndividuoFuncion5(this.valorN, this.valorError); break;
			}
		}
		
		this.evaluar();
	}
	
	public void generaElite() {

		int tamElite = (int) ((this.probElitismo * 10000) / this.tamPoblacion);
		this.quicksort(0, this.tamPoblacion - 1);
		this.elite = new Individuo[tamElite];
		for(int i = 0; i < tamElite; i++) {
			switch(this.numProblema) {
				case 1: this.elite[i] = new IndividuoFuncion1(this.poblacion[i]); break;
				case 2: this.elite[i] = new IndividuoFuncion2(this.poblacion[i]); break;
				case 3: this.elite[i] = new IndividuoFuncion3(this.poblacion[i]); break;
				case 4: this.elite[i] = new IndividuoFuncion4((IndividuoFuncion4) this.poblacion[i]); break;
				case 5: this.elite[i] = new IndividuoFuncion5((IndividuoFuncion5) this.poblacion[i]); break;
			}
		}
	}
	
	public void introducirElite() {
		this.evaluar();
		this.quicksort(0, this.tamPoblacion - 1);
		int tamElite = (int) ((this.probElitismo * 10000) / this.tamPoblacion);
		for(int i = 0; i < tamElite; i++) this.poblacion[this.tamPoblacion - 1 - i] = this.elite[i];
	}
	
	public void quicksort (int izq, int der){
	    int i = izq;
	    int j = der;
	    double pivote = this.fitness[(i + j) / 2];
	    do {
	        while (this.fitness[i] > pivote) i++;
	        while (this.fitness[j] < pivote) j--;
	        if (i <= j){
	        	Individuo auxIndividuo = this.poblacion[i];
	        	this.poblacion[i] = this.poblacion[j];
	            this.poblacion[j] = auxIndividuo;
	            double aux = this.fitness[i];
	            this.fitness[i] = this.fitness[j];
	            this.fitness[j] = aux;
	            i++;
	            j--;
	        }
	    } while(i <= j);
	    if (izq < j){
	        quicksort(izq, j);
	    }
	    if (i < der){
	        quicksort(i, der);
	    }
	}

	public void generaGrafica() {
		double media = 0.0, aptitudMedia = 0.0;
		this.mejorIndividuoGeneracion = this.poblacion[0];
		
		for(int i = 0; i < this.tamPoblacion; i++)  {
			media += this.poblacion[i].getValor();
			aptitudMedia += this.fitness[i];
		}
		media /= this.tamPoblacion;
		aptitudMedia /= this.tamPoblacion;
		
		if(this.numProblema == 1 && (this.mejorIndividuo == null || this.mejorIndividuoGeneracion.getFitness() > this.mejorIndividuo.getFitness())) this.mejorIndividuo = new IndividuoFuncion1(this.mejorIndividuoGeneracion);
		else if (this.mejorIndividuo == null || this.mejorIndividuoGeneracion.getFitness() < this.mejorIndividuo.getFitness()) {
			switch (this.numProblema) {
				case 2: this.mejorIndividuo = new IndividuoFuncion2(this.mejorIndividuoGeneracion); break;
				case 3: this.mejorIndividuo = new IndividuoFuncion3(this.mejorIndividuoGeneracion); break;
				case 4: this.mejorIndividuo = new IndividuoFuncion4((IndividuoFuncion4) this.mejorIndividuoGeneracion); break;
				case 5: this.mejorIndividuo = new IndividuoFuncion5((IndividuoFuncion5) this.mejorIndividuoGeneracion); break;
			}
		}
		
		this.grafica.getMediaGeneracion().add(media);
		this.grafica.getMejorGeneracion().add(this.mejorIndividuoGeneracion.getValor());
		this.grafica.getMejorAbsoluto().add(this.mejorIndividuo.getValor());
		this.grafica.getPresionSelectivaGeneracion().add(this.fitness[0] / aptitudMedia);
		
	}
	
	public double desviacionTipicaPoblacion() {
		double mediasVariables[], desviacionVariables[], mediaDesviaciones = 0, minValores[], maxValores[];
		int numVariables = (this.numProblema == 4 || this.numProblema == 5) ? this.valorN : 2;
		mediasVariables = new double[numVariables];
		desviacionVariables = new double[numVariables];
		minValores = new double[numVariables];
		maxValores = new double[numVariables];
		for(int i = 0; i < numVariables; i++) {
			minValores[i] = Double.MAX_VALUE;
			maxValores[i] = Double.MIN_VALUE;
		}
		for(int i = 0; i < numVariables; i++) {
			for(int j = 0; j < this.tamPoblacion; j++) {
				double valor = this.poblacion[j].getFenotipo(i);
				mediasVariables[i] += valor;
				if(valor < minValores[i]) minValores[i] = valor;
				if(valor > maxValores[i]) maxValores[i] = valor;
			}
			mediasVariables[i] /= this.tamPoblacion;
		}
		
		for(int i = 0; i < numVariables; i++) {
			if(maxValores[i] - minValores[i] == 0.0) desviacionVariables[i] = 0.0;
			else {
				for(int j = 0; j < this.tamPoblacion; j++) desviacionVariables[i] += Math.pow(this.poblacion[j].getFenotipo(i) - mediasVariables[i], 2);
				desviacionVariables[i] = Math.sqrt(desviacionVariables[i] / this.tamPoblacion);
				desviacionVariables[i] = desviacionVariables[i] / (maxValores[i] - minValores[i]);
			}
		}
		
		for(int i = 0; i < numVariables; i++) mediaDesviaciones += desviacionVariables[i];
		return mediaDesviaciones / numVariables;
	}
	
	public void introducirVariedad() {
		if(variedad) {
			double desviacion = this.desviacionTipicaPoblacion();
			this.grafica.getDesviacionTipicaGeneracion().add(desviacion);
			if(desviacion < this.valorError) {
				this.quicksort(0, this.tamPoblacion - 1);
				//QUITAR PEORES
				for(int i = this.tamPoblacion - 1; i >= this.tamPoblacion - ((20 * this.tamPoblacion) / 100); i--) {
					switch(this.numProblema) {
						case 1: this.poblacion[i] = new IndividuoFuncion1(this.valorError); break;
						case 2: this.poblacion[i] = new IndividuoFuncion2(this.valorError); break;
						case 3: this.poblacion[i] = new IndividuoFuncion3(this.valorError); break;
						case 4: this.poblacion[i] = new IndividuoFuncion4(this.valorN, this.valorError); break;
						case 5: this.poblacion[i] = new IndividuoFuncion5(this.valorN, this.valorError); break;
					}
				}
			}
		}
	}

	public void runAlgoritmo(int tamPoblacion, int maxGeneraciones, double probCruce, double probMutacion, double probElitismo, int numProblema, int valorN, double valorError, double escogerMejor, int tamTorneo, double umbralTruncamiento, boolean variedad,
							 String tipoSeleccion, String tipoCruce, String tipoMutacion) {
		this.tamPoblacion = tamPoblacion;
		this.poblacion = new Individuo[this.tamPoblacion];
		this.fitness = new double[this.tamPoblacion];
		this.maxGeneraciones = maxGeneraciones;
		this.probCruce = probCruce / 100;
		this.probMutacion = probMutacion / 100;
		this.probElitismo = probElitismo / 100;
		this.grafica.clear();
		this.mejorIndividuo = null;
		this.mejorIndividuoGeneracion = null;
		this.numProblema = numProblema;
		this.tipoSeleccion = tipoSeleccion;
		this.tipoCruce = tipoCruce;
		this.tipoMutacion = tipoMutacion;
		this.generacionActual = 0;
		this.valorN = valorN;
		this.tamTorneo = tamTorneo;
		this.valorError = valorError;
		this.escogerMejor = escogerMejor;
		this.umbralTruncamiento = umbralTruncamiento;
		this.variedad = variedad;
        this.run();
	}

	public void run() {
		
		//Reinicio del algoritmo
		this.iniciarPoblacion();
		
		while(this.generacionActual < this.maxGeneraciones) {
			
			//Ordenacion y calculo de la elite
			this.generaElite();
			
			//Seleccion
			switch(this.tipoSeleccion) {
				case "Seleccion Ruleta": this.poblacion = new SeleccionRuleta(this.fitness, this.poblacion, this.tamPoblacion, this.rand,this.tamTorneo, this.escogerMejor, this.umbralTruncamiento, this.numProblema).run(); break;
				case "Seleccion Estocastica": this.poblacion = new SeleccionEstocasticaUniversal(this.fitness, this.poblacion, this.tamPoblacion, this.rand,this.tamTorneo, this.escogerMejor, this.umbralTruncamiento, this.numProblema).run(); break;
				case "Seleccion Torneos Deterministico" : this.poblacion = new SeleccionTorneoDeterministico(this.fitness, this.poblacion, this.tamPoblacion, this.rand,this.tamTorneo, this.escogerMejor, this.umbralTruncamiento, this.numProblema).run(); break;
				case "Seleccion Torneos Probabilistico" : this.poblacion = new SeleccionTorneoProbabilistico(this.fitness, this.poblacion, this.tamPoblacion, this.rand,this.tamTorneo, this.escogerMejor, this.umbralTruncamiento, this.numProblema).run(); break;
				case "Seleccion Truncamiento" : this.poblacion = new SeleccionTruncamiento(this.fitness, this.poblacion, this.tamPoblacion, this.rand,this.tamTorneo, this.escogerMejor, this.umbralTruncamiento, this.numProblema).run(); break;
				case "Seleccion Restos" : this.poblacion = new SeleccionRestos(this.fitness, this.poblacion, this.tamPoblacion, this.rand,this.tamTorneo, this.escogerMejor, this.umbralTruncamiento, this.numProblema).run(); break;
			}
			
			//Reproduccion
			switch(this.tipoCruce) {
				case "Cruce Monopunto" : this.poblacion = new CruceMonopunto(this.poblacion, this.tamPoblacion, this.rand, this.probCruce, this.numProblema).run(); break;
				case "Cruce Uniforme" : this.poblacion = new CruceUniforme(this.poblacion, this.tamPoblacion, this.rand, this.probCruce, this.numProblema).run(); break;
				case "Cruce Aritmetico" : this.poblacion = new CruceAritmetico(this.poblacion, this.tamPoblacion, this.rand, this.probCruce, this.numProblema).run(); break;
				case "Cruce SBX" : this.poblacion = new CruceSBX(this.poblacion, this.tamPoblacion, this.rand, this.probCruce, this.numProblema).run(); break;
				case "Cruce BLX" : this.poblacion = new CruceBLX(this.poblacion, this.tamPoblacion, this.rand, this.probCruce, this.numProblema).run(); break;
			}
			
			//Mutacion
			switch(this.tipoMutacion)  {
				case "Mutacion Basica": new MutacionBasica(this.poblacion, this.tamPoblacion, this.rand, this.probMutacion).run(); break;
				case "Mutacion Uniforme": new MutacionUniforme(this.poblacion, this.tamPoblacion, this.rand, this.probMutacion).run(); break;
			}
			
			//Introduccion de la elite por los peores de la poblacion.
			this.introducirElite();
			
			//Introducir variedad a la población si es necesario.
			this.introducirVariedad();
			
			//Evaluar
			this.evaluar();
			
			//Calculos de graficas
			this.generaGrafica();
			
			//Siguiente generacion
			this.generacionActual++;
		}
		
	}
	
	public Individuo getMejorIndividuo() {
		return mejorIndividuo;
	}

	public Graficas getGrafica() {
		return grafica;
	}
	
	
}
