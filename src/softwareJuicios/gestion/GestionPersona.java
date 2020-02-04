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
			Consultas.alta(persona);
		} else {
			JOptionPane.showMessageDialog(null, "registro existente");
		}
		Consultas.finalizar();
	}

	public static void baja(Persona persona) {
		Consultas.actualizarDatos();
		if (Consultas.comprobarRegistro(persona)) {
			Consultas.delete(persona);
		} else {
			JOptionPane.showMessageDialog(null, "registro no existente");
		}
		Consultas.finalizar();
	}

	public static void modificar(Persona persona) {
		Consultas.actualizarDatos();
		if (Consultas.comprobarRegistro(persona)) {
			Consultas.modificar(persona);
		} else {
			JOptionPane.showMessageDialog(null, "registro no existente");
		}
		Consultas.finalizar();
	}

	public static String listar() {
		Consultas.actualizarDatos();
		String mensaje = "";
		for (Persona persona : personas) {
			mensaje += persona.toString() + '\n';
		}
		Consultas.finalizar();
		return mensaje;
	}
}
