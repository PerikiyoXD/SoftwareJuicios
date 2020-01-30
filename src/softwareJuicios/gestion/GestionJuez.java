package softwareJuicios.gestion;

import java.util.ArrayList;

import softwareJuicios.entidades.Juez;
import softwareJuicios.operaciones.Consultas;

public class GestionJuez {
	public static ArrayList<Juez> jueces = new ArrayList<Juez>();

	public void alta(Juez juez) {

	}

	public void baja(Juez juez) {

	}
	public void modificar(Juez juez) {

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
