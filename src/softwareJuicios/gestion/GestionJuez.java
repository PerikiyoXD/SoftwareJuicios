package softwareJuicios.gestion;

import java.util.ArrayList;

import softwareJuicios.entidades.Juez;
import softwareJuicios.operaciones.Consultas;

public class GestionJuez {
	public static ArrayList<Juez> jueces = new ArrayList<Juez>();

	public void alta() {

	}

	public void baja() {

	}

	public void modificar() {

	}

	public String listar() {
		Consultas.actualizarDatos();
		String mensaje = "";
		for (Juez juez : jueces) {
			mensaje += juez.toString() + '\n';
		}
		return mensaje;

	}
}
