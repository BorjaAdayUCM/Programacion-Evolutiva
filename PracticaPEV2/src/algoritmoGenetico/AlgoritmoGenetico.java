package algoritmoGenetico;

import java.io.FileNotFoundException;
import java.util.Random;

import algoritmoGenetico.cruces.CruceCO;
import algoritmoGenetico.cruces.CruceCX;
import algoritmoGenetico.cruces.CruceERX;
import algoritmoGenetico.cruces.CruceOX;
import algoritmoGenetico.cruces.CruceOXPP;
import algoritmoGenetico.cruces.CrucePMX;
import algoritmoGenetico.individuos.Individuo;
import algoritmoGenetico.mutaciones.MutacionHeuristica;
import algoritmoGenetico.mutaciones.MutacionInsercion;
import algoritmoGenetico.mutaciones.MutacionIntercambio;
import algoritmoGenetico.mutaciones.MutacionInversion;
import algoritmoGenetico.seleccion.SeleccionEstocasticaUniversal;
import algoritmoGenetico.seleccion.SeleccionRanking;
import algoritmoGenetico.seleccion.SeleccionRestos;
import algoritmoGenetico.seleccion.SeleccionRuleta;
import algoritmoGenetico.seleccion.SeleccionTorneoDeterministico;
import algoritmoGenetico.seleccion.SeleccionTorneoProbabilistico;
import algoritmoGenetico.seleccion.SeleccionTruncamiento;
import gui.Graficas;

public class AlgoritmoGenetico {
	
	private int tamPoblacion;
	private CargadorFicheros cargadorFicheros;
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
	private double escogerMejor;
	private int tamTorneo;
	private double umbralTruncamiento;
	
	public AlgoritmoGenetico() {
		super();
		this.grafica = new Graficas();
		this.cargadorFicheros = new CargadorFicheros();
		this.rand = new Random();
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
		this.corrigeMinimizar(max);
		
		double fitnessTotal = 0.0;
		for(int i = 0; i < this.tamPoblacion; i++) fitnessTotal += this.fitness[i];
		for(int i = 0; i < this.tamPoblacion; i++) this.fitness[i] = this.fitness[i] / fitnessTotal;
		this.quicksort(0, this.tamPoblacion - 1);
	}
	
	public void iniciarPoblacion() {
		this.generacionActual = 0;
		for(int i = 0; i < this.tamPoblacion; i++) this.poblacion[i] = new Individuo(this.cargadorFicheros.matFlujo, this.cargadorFicheros.matDistancias, this.rand);
		this.evaluar();
	}
	
	public void generaElite() {
		int tamElite = (int) ((this.probElitismo * 10000) / this.tamPoblacion);
		this.quicksort(0, this.tamPoblacion - 1);
		this.elite = new Individuo[tamElite];
		for(int i = 0; i < tamElite; i++) this.elite[i] = new Individuo(this.poblacion[i]);
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
			media += this.poblacion[i].getFitness();
			aptitudMedia += this.fitness[i];
		}
		media /= this.tamPoblacion;
		aptitudMedia /= this.tamPoblacion;
		
		if (this.mejorIndividuo == null || this.mejorIndividuoGeneracion.getFitness() < this.mejorIndividuo.getFitness()) this.mejorIndividuo = new Individuo(this.mejorIndividuoGeneracion);
		
		this.grafica.getMediaGeneracion().add(media);
		this.grafica.getMejorGeneracion().add(this.mejorIndividuoGeneracion.getFitness());
		this.grafica.getMejorAbsoluto().add(this.mejorIndividuo.getFitness());
		this.grafica.getPresionSelectivaGeneracion().add(this.fitness[0] / aptitudMedia);
		
	}

	public void runAlgoritmo(int tamPoblacion, int maxGeneraciones, double probCruce, double probMutacion, double probElitismo, int numProblema, double escogerMejor, int tamTorneo, double umbralTruncamiento, boolean variedad,
							 String tipoSeleccion, String tipoCruce, String tipoMutacion) throws FileNotFoundException {
		this.numProblema = numProblema;
		this.cargadorFicheros.cargaFichero(numProblema);
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
		this.tipoSeleccion = tipoSeleccion;
		this.tipoCruce = tipoCruce;
		this.tipoMutacion = tipoMutacion;
		this.generacionActual = 0;
		this.tamTorneo = tamTorneo;
		this.escogerMejor = escogerMejor;
		this.umbralTruncamiento = umbralTruncamiento;
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
				case "Seleccion Ranking" : this.poblacion = new SeleccionRanking(this.fitness, this.poblacion, this.tamPoblacion, this.rand,this.tamTorneo, this.escogerMejor, this.umbralTruncamiento, this.numProblema).run(); break;
			}
			
			//Reproduccion
			switch(this.tipoCruce) {
				case "Cruce PMX": this.poblacion = new CrucePMX(this.poblacion, this.tamPoblacion, this.rand, this.probCruce, this.numProblema).run(); break;
				case "Cruce OX": this.poblacion = new CruceOX(this.poblacion, this.tamPoblacion, this.rand, this.probCruce, this.numProblema).run(); break;
				case "Cruce OX-PP": this.poblacion = new CruceOXPP(this.poblacion, this.tamPoblacion, this.rand, this.probCruce, this.numProblema).run(); break;
				case "Cruce CO": this.poblacion = new CruceCO(this.poblacion, this.tamPoblacion, this.rand, this.probCruce, this.numProblema).run(); break;
				case "Cruce ERX": this.poblacion = new CruceERX(this.poblacion, this.tamPoblacion, this.rand, this.probCruce, this.numProblema).run(); break;
				case "Cruce CX": this.poblacion = new CruceCX(this.poblacion, this.tamPoblacion, this.rand, this.probCruce, this.numProblema).run(); break;
			}
			
			//Mutacion
			switch(this.tipoMutacion)  {
				case "Mutacion Insercion": new MutacionInsercion(this.poblacion, this.tamPoblacion, this.rand, this.probMutacion).run(); break;
				case "Mutacion Intercambio": new MutacionIntercambio(this.poblacion, this.tamPoblacion, this.rand, this.probMutacion).run(); break;
				case "Mutacion Heuristica": new MutacionHeuristica(this.poblacion, this.tamPoblacion, this.rand, this.probMutacion).run(); break;
				case "Mutacion Inversion": new MutacionInversion(this.poblacion, this.tamPoblacion, this.rand, this.probMutacion).run(); break;
			}
			
			//Introduccion de la elite por los peores de la poblacion.
			this.introducirElite();
			
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
