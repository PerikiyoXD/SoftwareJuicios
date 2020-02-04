package softwareJuicios.gestion;

import javax.swing.JOptionPane;

import org.neodatis.odb.Objects;

import softwareJuicios.entidades.Juez;
import softwareJuicios.operaciones.Consultas;

public class GestionJuez {
	public static Objects<Juez> jueces;

	public void alta(Juez juez) {
		Consultas.actualizarDatos();
		if (!Consultas.comprobarRegistro(juez)) {
			Consultas.alta(juez);
		} else {
			JOptionPane.showMessageDialog(null, "registro existente");
		}
		Consultas.finalizar();
	}

	public void baja(Juez juez) {
		Consultas.actualizarDatos();
		if (Consultas.comprobarRegistro(juez)) {
			Consultas.delete(juez);
		} else {
			JOptionPane.showMessageDialog(null, "registro no existente");
		}
		Consultas.finalizar();
	}

	public void modificar(Juez juez) {
		Consultas.actualizarDatos();
		if (Consultas.comprobarRegistro(juez)) {
			Consultas.modificar(juez);
		} else {
			JOptionPane.showMessageDialog(null, "registro no existente");
		}
		Consultas.finalizar();
	}

	public String listar() {
		Consultas.actualizarDatos();
		String mensaje = "";
		for (Juez juez : jueces) {
			mensaje += juez.toString() + '\n';
		}
		Consultas.finalizar();
		return mensaje;

	}
}
