package algoritmoGenetico;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class CargadorFicheros {
	
	int tamMatriz;
	int[][] matDistancias;
	int[][] matFlujo;
	
	public CargadorFicheros() {
		this.tamMatriz = 0;
		this.matDistancias = null;
		this.matFlujo = null;
	}
	
	public void cargaFichero(int numProblema) throws FileNotFoundException {
		File file = null;
		switch(numProblema) {
			case 1: file = new File("data/ajuste.txt"); break;
			case 2: file = new File("data/datos12.txt"); break;
			case 3: file = new File("data/datos15.txt"); break;
			case 4: file = new File("data/datos30.txt"); break;
			case 5: file = new File("data/tai100a.txt"); break;
			case 6: file = new File("data/tai256c.txt"); break;
		}
		
		@SuppressWarnings("resource")
		Scanner s = new Scanner(file);
		
		this.tamMatriz = s.nextInt();
		this.matDistancias = new int[this.tamMatriz][this.tamMatriz];
		this.matFlujo = new int[this.tamMatriz][this.tamMatriz];
		
		for (int i = 0; i < this.tamMatriz;i++) {
			for (int j = 0; j < this.tamMatriz;j++) {
				this.matDistancias[i][j] = s.nextInt();
			}
		}
		
		for (int i = 0; i < this.tamMatriz;i++) {
			for (int j = 0; j < this.tamMatriz;j++) {
				this.matFlujo[i][j] = s.nextInt();
			}
		}
		
	}
}
