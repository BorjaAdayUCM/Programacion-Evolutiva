package algoritmoGenetico;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import algoritmoGenetico.cruces.CruceSimple;
import algoritmoGenetico.individuos.GeneradorMultiplexor;
import algoritmoGenetico.individuos.Individuo;
import algoritmoGenetico.mutaciones.MutacionContraccion;
import algoritmoGenetico.mutaciones.MutacionExpansion;
import algoritmoGenetico.mutaciones.MutacionFuncionalSimple;
import algoritmoGenetico.mutaciones.MutacionHoist;
import algoritmoGenetico.mutaciones.MutacionPermutacion;
import algoritmoGenetico.mutaciones.MutacionSubarbol;
import algoritmoGenetico.mutaciones.MutacionTerminalSimple;
import algoritmoGenetico.seleccion.SeleccionEstocasticaUniversal;
import algoritmoGenetico.seleccion.SeleccionRanking;
import algoritmoGenetico.seleccion.SeleccionRestos;
import algoritmoGenetico.seleccion.SeleccionRuleta;
import algoritmoGenetico.seleccion.SeleccionTorneoDeterministico;
import algoritmoGenetico.seleccion.SeleccionTorneoProbabilistico;
import algoritmoGenetico.seleccion.SeleccionTruncamiento;
import gui.DatosTabla;
import gui.Graficas;
import gui.Observador;
import gui.ObservadorAlgoritmo;

public class AlgoritmoGenetico implements Observador<ObservadorAlgoritmo> {
	
	private List<ObservadorAlgoritmo> observadores;
	private int tamPoblacion;
	private GeneradorMultiplexor generadorMultiplexor;
	private Individuo[] poblacion;
	private Individuo[] elite;
	private double[] fitness;
	private int maxGeneraciones;
	private double probCruce;
	private double probMutacion;
	private double probElitismo;
	private Graficas grafica;
	private int tipoMultiplexor;
	private String tipoSeleccion;
	private String tipoCruce;
	private String tipoMutacion;
	private String tipoCreacion;
	private String tipoLimitacion;
	private String tipoEvaluacion;
	private double limitacion;
	private int generacionActual;
	private double mejorSolucionDouble;
	private String mejorSolucionString;
	private Random rand;
	private double escogerMejor;
	private int tamTorneo;
	private double umbralTruncamiento;
	private int profundidad_max;
	private boolean useIf;
	private int numHebras;
	
	public AlgoritmoGenetico() {
		super();
		this.observadores = new ArrayList<ObservadorAlgoritmo>();
		this.grafica = new Graficas();
		this.generadorMultiplexor = new GeneradorMultiplexor();
		this.rand = new Random();
	}
	
	public void corrigeMaximizar(double min) {
		min *= 1.05;
		for(int i = 0; i < this.tamPoblacion; i++) this.fitness[i] = this.fitness[i] + Math.abs(min);
	}
	
	public void evaluar(String tipoLimitacion) {
		for(int i = 0; i < this.tamPoblacion; i++) this.fitness[i] = this.poblacion[i].getFitness(this.tipoEvaluacion, this.numHebras);
		if(tipoLimitacion.equalsIgnoreCase("Metodo Tarpeian")){
			double mediaTam = 0;
			for(int i = 0; i < this.tamPoblacion; i++) mediaTam += this.poblacion[i].getArbol().getNumNodos();
			mediaTam /= this.tamPoblacion;
			for(int i = 0; i < this.tamPoblacion; i++) {
				if(this.generacionActual % 2 != 0) this.fitness[i] = this.poblacion[i].getFitnessTarpeian(this.poblacion[i].getAciertos(), mediaTam, this.limitacion, this.tipoEvaluacion, this.numHebras);
			}
		}
		else if(tipoLimitacion.equalsIgnoreCase("Penalizacion bien fundamentada")) {
			double mediaTam = 0, mediaFitness = 0;
			for(int i = 0; i < this.tamPoblacion; i++) {
				mediaTam += this.poblacion[i].getArbol().getNumNodos();
				mediaFitness += this.poblacion[i].getAciertos();
			}
			mediaTam /= this.tamPoblacion;
			mediaFitness /= this.tamPoblacion;
			double varianza = 0, covarianza = 0;
			for(int i = 0; i < this.tamPoblacion; i++) {
				varianza += Math.pow((this.poblacion[i].getArbol().getNumNodos() - mediaTam), 2);
				covarianza += ((this.poblacion[i].getArbol().getNumNodos() - mediaTam)*(this.poblacion[i].getAciertos() - mediaFitness));
			}
			varianza /= this.tamPoblacion;
			covarianza /= this.tamPoblacion;
			for(int i = 0; i < this.tamPoblacion; i++) {
				if(this.generacionActual % 2 != 0) this.fitness[i] = this.poblacion[i].getFitnessPenalizacion(this.poblacion[i].getAciertos(), covarianza / varianza, this.tipoEvaluacion, this.numHebras);
			}
		}

		double min = Double.MAX_VALUE, max = Double.MIN_VALUE;
		for(int i = 0; i < this.tamPoblacion; i++) {
			if(this.fitness[i] < min) min = this.fitness[i];
			if(this.fitness[i] > max) max = this.fitness[i];
		}
		
		//Correccion Evaluacion
		this.corrigeMaximizar(min);
		
		double fitnessTotal = 0.0;
		for(int i = 0; i < this.tamPoblacion; i++) fitnessTotal += this.fitness[i];
		for(int i = 0; i < this.tamPoblacion; i++) this.fitness[i] = this.fitness[i] / fitnessTotal;
		this.quicksort(0, this.tamPoblacion - 1);
	}
	
	public void iniciarPoblacion() {
		this.generacionActual = 0;
		for(int i = 0; i < this.tamPoblacion; i++) this.poblacion[i] = new Individuo(this.profundidad_max, this.tipoCreacion, this.useIf, this.tipoMultiplexor,
																					 this.generadorMultiplexor.getCasos(), this.generadorMultiplexor.getSoluciones());
		this.corrigeIndividuos();
	}
	
	public void generaElite() {
		this.evaluar("Sin limite");
		int tamElite = (int) ((this.probElitismo * 100) * this.tamPoblacion / 100);
		this.elite = new Individuo[tamElite];
		for(int i = 0; i < tamElite; i++) this.elite[i] = new Individuo(this.poblacion[i]);
		this.evaluar(this.tipoLimitacion);
	}
	
	public void introducirElite() {
		this.evaluar("Sin limite");
		int tamElite = (int) ((this.probElitismo * 100) * this.tamPoblacion / 100);
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
	
	public void corrigeIndividuos() {
		for(int i = 0; i < this.tamPoblacion; i++) {
			this.poblacion[i].getArbol().corrigeArbol();
			if(this.poblacion[i].getArbol().getNumNodos() == 1) {
				this.poblacion[i] = new Individuo(this.profundidad_max, this.tipoCreacion, this.useIf, this.tipoMultiplexor,
						 this.generadorMultiplexor.getCasos(), this.generadorMultiplexor.getSoluciones());
			}
		}
	}

	public void generaGrafica() {
		int mejor = Integer.MIN_VALUE;
		double media = 0, mediaNodos = 0;
		int posMejor = 0;
		for(int i = 0; i < this.tamPoblacion; i++) {
			if(this.poblacion[i].getAciertos() > mejor) {
				mejor = this.poblacion[i].getAciertos();
				posMejor = i;
			}
			media += this.poblacion[i].getAciertos();
			mediaNodos += this.poblacion[i].getArbol().getNumNodos();
		}
		media/= this.tamPoblacion;
		mediaNodos /= this.tamPoblacion;
		if(this.poblacion[posMejor].getAciertos() > this.mejorSolucionDouble) {
			this.mejorSolucionDouble = this.poblacion[posMejor].getAciertos();
			this.mejorSolucionString = this.poblacion[posMejor].toString();
		}
		this.grafica.getMediaGeneracion().add(media);
		this.grafica.getMejorGeneracion().add((double) mejor);
		this.grafica.getMejorAbsoluto().add(this.mejorSolucionDouble);
		this.grafica.getPresionSelectivaGeneracion().add(mejor / media);
		this.notifica("actualiza", this.generacionActual + 1, this.maxGeneraciones, new DatosTabla(this.generacionActual + 1, (int) this.mejorSolucionDouble, mediaNodos, media));
		
	}

	public void runAlgoritmo(int tamPoblacion, int maxGeneraciones, double probCruce, double probMutacion, double probElitismo, int tipoMultiplexor, double escogerMejor, int tamTorneo, double umbralTruncamiento, boolean variedad,
							 String tipoSeleccion, String tipoCruce, String tipoMutacion, String tipoCreacion, String tipoLimitacion, double limitacion, int profundidad_max, boolean useIf, String tipoEvaluacion,
							 int numHebras) throws FileNotFoundException {
		
		this.notifica("inicia", 0, 0, new DatosTabla(0,0,0,0));
		
		this.tipoLimitacion = tipoLimitacion;
		this.limitacion = limitacion;
		this.tipoMultiplexor = tipoMultiplexor;
		this.profundidad_max = profundidad_max;
		this.tipoCreacion = tipoCreacion;
		this.useIf = useIf;
		this.generadorMultiplexor.generaMultiplexor(this.tipoMultiplexor);
		this.tamPoblacion = tamPoblacion;
		this.poblacion = new Individuo[this.tamPoblacion];
		this.fitness = new double[this.tamPoblacion];
		this.maxGeneraciones = maxGeneraciones;
		this.probCruce = probCruce / 100;
		this.probMutacion = probMutacion / 100;
		this.probElitismo = probElitismo / 100;
		this.grafica.clear();
		this.tipoSeleccion = tipoSeleccion;
		this.tipoCruce = tipoCruce;
		this.tipoMutacion = tipoMutacion;
		this.generacionActual = 0;
		this.tamTorneo = tamTorneo;
		this.escogerMejor = escogerMejor;
		this.umbralTruncamiento = umbralTruncamiento;
		this.mejorSolucionDouble = 0;
		this.mejorSolucionString = "";
		this.tipoEvaluacion = tipoEvaluacion;
		this.numHebras = numHebras;
        this.run();
        
        this.notifica("finaliza", 0, 0, new DatosTabla(0,0,0,0));
	}

	public void run() {
		
		//Reinicio del algoritmo
		this.iniciarPoblacion();
		
		while(this.generacionActual < this.maxGeneraciones) {
			
			//Ordenacion y calculo de la elite
			this.generaElite();
			
			//Seleccion
			switch(this.tipoSeleccion) {
				case "Seleccion Ruleta": this.poblacion = new SeleccionRuleta(this.fitness, this.poblacion, this.tamPoblacion, this.rand,this.tamTorneo, this.escogerMejor, this.umbralTruncamiento).run(); break;
				case "Seleccion Estocastica": this.poblacion = new SeleccionEstocasticaUniversal(this.fitness, this.poblacion, this.tamPoblacion, this.rand,this.tamTorneo, this.escogerMejor, this.umbralTruncamiento).run(); break;
				case "Seleccion Torneos Deterministico" : this.poblacion = new SeleccionTorneoDeterministico(this.fitness, this.poblacion, this.tamPoblacion, this.rand,this.tamTorneo, this.escogerMejor, this.umbralTruncamiento).run(); break;
				case "Seleccion Torneos Probabilistico" : this.poblacion = new SeleccionTorneoProbabilistico(this.fitness, this.poblacion, this.tamPoblacion, this.rand,this.tamTorneo, this.escogerMejor, this.umbralTruncamiento).run(); break;
				case "Seleccion Truncamiento" : this.poblacion = new SeleccionTruncamiento(this.fitness, this.poblacion, this.tamPoblacion, this.rand,this.tamTorneo, this.escogerMejor, this.umbralTruncamiento).run(); break;
				case "Seleccion Restos" : this.poblacion = new SeleccionRestos(this.fitness, this.poblacion, this.tamPoblacion, this.rand,this.tamTorneo, this.escogerMejor, this.umbralTruncamiento).run(); break;
				case "Seleccion Ranking" : this.poblacion = new SeleccionRanking(this.fitness, this.poblacion, this.tamPoblacion, this.rand,this.tamTorneo, this.escogerMejor, this.umbralTruncamiento).run(); break;
			}
			
			//Reproduccion
			switch(this.tipoCruce) {
				case "Cruce simple": this.poblacion = new CruceSimple(this.poblacion, this.tamPoblacion, this.rand, this.probCruce, this.tipoMultiplexor).run(); break;
			}
			
			//Mutacion
			switch(this.tipoMutacion)  {
				case "Mutacion funcional simple": new MutacionFuncionalSimple(this.poblacion, this.tamPoblacion, this.rand, this.probMutacion).run(); break;
				case "Mutacion terminal simple": new MutacionTerminalSimple(this.poblacion, this.tamPoblacion, this.rand, this.probMutacion).run(); break;
				case "Mutacion permutacion": new MutacionPermutacion(this.poblacion, this.tamPoblacion, this.rand, this.probMutacion).run(); break;
				case "Mutacion hoist": new MutacionHoist(this.poblacion, this.tamPoblacion, this.rand, this.probMutacion).run(); break;
				case "Mutacion expansion": new MutacionExpansion(this.poblacion, this.tamPoblacion, this.rand, this.probMutacion).run(); break;
				case "Mutacion contraccion": new MutacionContraccion(this.poblacion, this.tamPoblacion, this.rand, this.probMutacion).run(); break;
				case "Mutacion subarbol": new MutacionSubarbol(this.poblacion, this.tamPoblacion, this.rand, this.probMutacion).run(); break;
			}
			
			//Corregimos intrones generados por el cruce y la mutacion.
			this.corrigeIndividuos();
			
			//Introduccion de la elite por los peores de la poblacion.
			this.introducirElite();
			
			//Calculos de graficas
			this.generaGrafica();
			
			
			//Siguiente generacion
			this.generacionActual++;
		}
		
	}

	public double getMejorSolucionDouble() {
		return mejorSolucionDouble;
	}

	public String getMejorSolucionString() {
		return mejorSolucionString;
	}

	public Graficas getGrafica() {
		return grafica;
	}

	@Override
	public void addObservador(ObservadorAlgoritmo o) {
		if (o != null && !this.observadores.contains(o)) this.observadores.add(o);
	}

	@Override
	public void removeObservador(ObservadorAlgoritmo o) {
		if (o != null && this.observadores.contains(o)) this.observadores.remove(o);
	}
	
	private void notifica(String tipo, int generacionActual, int maxGeneraciones, DatosTabla datos) {
		if(tipo.equals("actualiza")) for (ObservadorAlgoritmo o : this.observadores) o.actualiza(generacionActual, maxGeneraciones, datos);
		else if(tipo.equals("inicia")) for (ObservadorAlgoritmo o : this.observadores) o.inicia();
		else if(tipo.equals("finaliza")) for (ObservadorAlgoritmo o : this.observadores) o.finaliza();
	}
	
}
