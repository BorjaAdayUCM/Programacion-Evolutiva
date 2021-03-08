package main;

import gui.PanelPrincipal;

public class Main {

	public static void main(String[] args) {
	        /* Create and display the form */
			java.awt.EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                new PanelPrincipal().setVisible(true);
	            }
	        });
	        
	}

}
