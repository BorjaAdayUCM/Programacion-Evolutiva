package gui;

import java.util.ArrayList;

import javax.swing.SwingUtilities;

import algoritmoGenetico.AlgoritmoGenetico;

@SuppressWarnings("serial")
public class ModeloTablaAlgoritmo extends ModeloTabla<DatosTabla> {


	public ModeloTablaAlgoritmo(String[] columnIdEventos, AlgoritmoGenetico AlgoritmoGenetico) {
		super(columnIdEventos, AlgoritmoGenetico);
		this.lista = new ArrayList<DatosTabla>();
	}

	@Override // necesario para que se visualicen los datos
	public Object getValueAt(int indiceFil, int indiceCol) {
		Object s = null;
		switch (indiceCol) {
			case 0: s = this.lista.get(indiceFil).getGeneracionActual(); break;
			case 1: s = this.lista.get(indiceFil).getMejor(); break;
			case 2: s = this.lista.get(indiceFil).getMediaNodos(); break;
			case 3: s = this.lista.get(indiceFil).getMediaFitness(); break;
			default: assert (false);
		}
		return s; 
	}

	@Override
	public void inicia() {
		this.lista.clear();
	}

	@Override
	public void finaliza() {}

	@Override
	public void actualiza(int generacionActual, int maxGeneraciones, DatosTabla datosTabla) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				lista.add(datosTabla);
				fireTableStructureChanged();
			}
		});
		
	}

}
