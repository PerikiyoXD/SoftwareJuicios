package softwareJuicios.gestion;

import javax.swing.JOptionPane;

import org.neodatis.odb.Objects;

import softwareJuicios.entidades.Juez;
import softwareJuicios.operaciones.Consultas;

public class GestionJuez {
	public static Objects<Juez> jueces;

	public static void alta(Juez juez) {
		Consultas.actualizarDatos();
		if (!Consultas.comprobarRegistro(juez)) {
			Consultas.insertar(juez);
		} else {
			JOptionPane.showMessageDialog(null, "registro existente");
		}

	}

	public static void baja(Juez juez) {
		Consultas.actualizarDatos();
		if (Consultas.comprobarRegistro(juez)) {
			Consultas.borrar(juez, juez.getDniJuez());
		} else {
			JOptionPane.showMessageDialog(null, "registro no existente");
		}

	}

	public static void modificar(Juez juez) {
		Consultas.actualizarDatos();
		if (Consultas.comprobarRegistro(juez)) {
			Consultas.modificar(juez);
		} else {
			JOptionPane.showMessageDialog(null, "registro no existente");
		}

	}

	public static String listar() {
		Consultas.actualizarDatos();
		String mensaje = "";
		for (Juez juez : jueces) {
			mensaje += juez.toString() + '\n';
		}

		return mensaje;

	}
}
