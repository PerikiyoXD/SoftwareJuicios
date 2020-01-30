package softwareJuicios.gestion;

import java.util.ArrayList;

import softwareJuicios.entidades.Juez;
import softwareJuicios.operaciones.Consultas;

public class GestionJuez {
	public static ArrayList<Juez> jueces = new ArrayList<Juez>();

	public void alta(Juez juez) {
		Consultas.actualizarDatos(jueces);
		
		if (Consultas.comprobarRegistro(juez)) {
				jueces.add(juez);
		Consultas.commit(juez);
		}
	
	}

	public void baja(Juez juez) {
		Consultas.actualizarDatos(jueces);
		
		if (Consultas.comprobarRegistro(juez)) {
			Consultas.delete(juez);
		Consultas.actualizarDatos(jueces);
		}
		
	}
	public void modificar(Juez juez) {

	}

	public String listar() {
		Consultas.actualizarDatos(jueces);
		String mensaje = "";
		for (Juez juez : jueces) {
			mensaje += juez.toString() + '\n';
		}
		return mensaje;

	}
}
