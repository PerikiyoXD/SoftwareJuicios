package softwareJuicios.gestion;

import java.util.ArrayList;

import softwareJuicios.entidades.Juicio;
import softwareJuicios.operaciones.Consultas;

public class GestionJuicio {
	public static ArrayList<Juicio> juicios = new ArrayList<Juicio>();

	public void alta() {

	}

	public void baja() {

	}

	public void modificar() {

	}

	public String listar() {
		Consultas.actualizarDatos();
		String mensaje = "";
		for (Juicio juicio : juicios) {
			mensaje += juicio.toString() + '\n';
		}
		return mensaje;

	}

}
