package softwareJuicios.gestion;

import java.util.ArrayList;

import softwareJuicios.entidades.Persona;
import softwareJuicios.operaciones.Consultas;

public class GestionPersona {

	public static ArrayList<Persona> personas = new ArrayList<Persona>();

	public void alta(Persona persona) {

	}

	public void baja(Persona persona) {

	}

	public void modificar(Persona persona) {

	}

	public String listar() {
		Consultas.actualizarDatos();
		String mensaje = "";
		for (Persona persona : personas) {
			mensaje += persona.toString() + '\n';
		}
		return mensaje;
	}
}
