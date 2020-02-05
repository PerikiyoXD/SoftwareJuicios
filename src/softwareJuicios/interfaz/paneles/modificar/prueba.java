package softwareJuicios.interfaz.paneles.modificar;

import javax.swing.JPanel;

import softwareJuicios.interfaz.paneles.listar.ListaDenunciaPanel;
import softwareJuicios.interfaz.paneles.listar.ListaJuezPanel;
import softwareJuicios.interfaz.paneles.listar.ListaJuicioPanel;
import softwareJuicios.interfaz.paneles.listar.ListaPersonaPanel;

public class prueba extends JPanel {
	private ListaDenunciaPanel lista;
	private ListaPersonaPanel lista2;
	private ListaJuezPanel lista3;
	private ListaJuicioPanel lista4;
	/**
	 * Create the panel.
	 */
	public prueba() {

		lista= new ListaDenunciaPanel();
		lista2=new ListaPersonaPanel();
		lista3= new ListaJuezPanel();
		lista4=new ListaJuicioPanel();
		add(lista, "cell 0 0,alignx left,aligny top");
		add(lista2, "cell 0 0,alignx left,aligny top");
		add(lista3, "cell 0 0,alignx left,aligny top");
		add(lista4, "cell 0 0,alignx left,aligny top");
	}

}
