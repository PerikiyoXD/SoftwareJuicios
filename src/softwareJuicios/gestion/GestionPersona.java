package softwareJuicios.gestion;

import javax.swing.JOptionPane;

import org.neodatis.odb.Objects;

import softwareJuicios.entidades.Persona;
import softwareJuicios.operaciones.Consultas;
import softwareJuicios.utilidades.ConectorNeodatis;

public class GestionPersona {
	public static Objects<Persona> personas;

	public void alta(Persona persona) {
		Consultas.actualizarDatos();
		if (!Consultas.comprobarRegistro(persona)) {
			Consultas.alta(persona);
		} else {
			JOptionPane.showMessageDialog(null, "registro existente");
		}
		Consultas.finalizar();
	}

	public void baja(Persona persona) {
		Consultas.actualizarDatos();
		if (Consultas.comprobarRegistro(persona)) {
			Consultas.delete(persona);
		} else {
			JOptionPane.showMessageDialog(null, "registro no existente");
		}
		Consultas.finalizar();
	}

	public void modificar(Persona persona) {
		Consultas.actualizarDatos();
		if (Consultas.comprobarRegistro(persona)) {
			Consultas.modificar(persona);
		} else {
			JOptionPane.showMessageDialog(null, "registro no existente");
		}
		Consultas.finalizar();
	}

	public String listar() {
		Consultas.actualizarDatos();
		String mensaje = "";
		for (Persona persona : personas) {
			mensaje += persona.toString() + '\n';
		}
		Consultas.finalizar();
		return mensaje;
	}
}
