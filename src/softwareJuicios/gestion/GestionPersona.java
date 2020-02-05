package softwareJuicios.gestion;

import javax.swing.JOptionPane;

import org.neodatis.odb.Objects;

import softwareJuicios.entidades.Persona;
import softwareJuicios.operaciones.Consultas;

public class GestionPersona {
	public static Objects<Persona> personas;

	public static void alta(Persona persona) {
		Consultas.actualizarDatos();
		if (!Consultas.comprobarRegistro(persona)) {
			Consultas.insertar(persona);
		} else {
			JOptionPane.showMessageDialog(null, "registro existente");
		}
	}

	public static void baja(Persona persona) {
		Consultas.actualizarDatos();
		if (Consultas.comprobarRegistro(persona)) {
			Consultas.borrar(persona);
		} else {
			JOptionPane.showMessageDialog(null, "registro no existente");
		}

	}

	public static void modificar(Persona persona) {
		Consultas.actualizarDatos();
		if (Consultas.comprobarRegistro(persona)) {
			Consultas.modificar(persona);
		} else {
			JOptionPane.showMessageDialog(null, "registro no existente");
		}

	}

	public static String listar() {
		Consultas.actualizarDatos();
		String mensaje = "";
		for (Persona persona : personas) {
			mensaje += persona.toString() + '\n';
		}
		return mensaje;
	}
}
