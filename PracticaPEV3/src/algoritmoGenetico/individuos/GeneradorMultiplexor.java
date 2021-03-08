package algoritmoGenetico.individuos;
import java.util.ArrayList;

public class GeneradorMultiplexor {
	
	public boolean[][] casos;
	public boolean[] soluciones;
	
	public void generaMultiplexor(int tipoMultiplexor) {
		this.generaCasos(tipoMultiplexor);
		this.generaSoluciones(tipoMultiplexor);
	}
	
	public ArrayList<Boolean> obtenerBinario(int numero){
		String numBinario = Integer.toBinaryString(numero);
		ArrayList<Boolean> devolver = new ArrayList<Boolean>();
		for(int i = 0; i < numBinario.length(); i++) devolver.add(0, numBinario.charAt(i) == '0' ? false : true);
		return devolver;
	}
	
	public void generaCasos(int tipoMultiplexor) {
		int numControles = tipoMultiplexor;
		int numEntradas = (int) Math.pow(2, numControles);
		int columnas = numControles + numEntradas;
		int filas = (int) Math.pow(2, columnas);
		
		this.casos = new boolean[filas][columnas];
		for(int i = 0; i < filas; i++) {
			for(int j = 0; j < columnas; j++) {
				this.casos[i][j] = false;
			}
		}
		
		for(int i = 0; i < filas; i++) {
			ArrayList<Boolean> numBinario = this.obtenerBinario(i);
			for(int j = numBinario.size() - 1; j >= 0; j--) {
				this.casos[i][this.casos[i].length - 1 - j] = numBinario.get(j);
			}
			
		}
	}
	
	private boolean solucionCaso(boolean caso[], int tipoMultiplexor) {
		int pos = 0;
		for(int i = 0; i < tipoMultiplexor; i++) {
			if(caso[i]) pos += Math.pow(2, tipoMultiplexor - i - 1);
		}
		if(caso[tipoMultiplexor + pos]) return true;
		return false;
	}
	
	private void generaSoluciones(int tipoMultiplexor) {
		int numControles = tipoMultiplexor;
		int numEntradas = (int) Math.pow(2, numControles);
		int columnas = numControles + numEntradas;
		int casosTotales = (int) Math.pow(2, columnas);
		this.soluciones = new boolean[casosTotales];
		for(int i = 0; i < this.casos.length; i++) {
			this.soluciones[i] = this.solucionCaso(this.casos[i], tipoMultiplexor);
		}
	}
	
	public boolean[][] getCasos() {
		return casos;
	}

	public boolean[] getSoluciones() {
		return soluciones;
	}
	
	
}
