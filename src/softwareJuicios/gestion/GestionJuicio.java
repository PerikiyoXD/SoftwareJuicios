package softwareJuicios.gestion;

import javax.swing.JOptionPane;

import org.neodatis.odb.Objects;

import softwareJuicios.entidades.Juicio;
import softwareJuicios.operaciones.Consultas;

public class GestionJuicio {
	public static Objects<Juicio> juicios;

	public void alta(Juicio juicio) {
		Consultas.actualizarDatos();
		if (!Consultas.comprobarRegistro(juicio)) {
			Consultas.alta(juicio);
		} else {
			JOptionPane.showMessageDialog(null, "registro existente");
		}
		Consultas.finalizar();
	}

	public void baja(Juicio juicio) {
		Consultas.actualizarDatos();
		if (Consultas.comprobarRegistro(juicio)) {
			Consultas.delete(juicio);
		} else {
			JOptionPane.showMessageDialog(null, "registro no existente");
		}
		Consultas.finalizar();
	}

	public void modificar(Juicio juicio) {
		Consultas.actualizarDatos();
		if (Consultas.comprobarRegistro(juicio)) {
			Consultas.modificar(juicio);
		} else {
			JOptionPane.showMessageDialog(null, "registro no existente");
		}
		Consultas.finalizar();
	}

	public String listar() {
		Consultas.alta(juicios);
		String mensaje = "";
		for (Juicio juicio : juicios) {
			mensaje += juicio.toString() + '\n';
		}
		Consultas.finalizar();
		return mensaje;

	}

}
