package softwareJuicios.gestion;

import javax.swing.JOptionPane;

import org.neodatis.odb.Objects;

import softwareJuicios.entidades.Denuncia;
import softwareJuicios.operaciones.Consultas;

public class GestionDenuncia {
	public static Objects<Denuncia> denuncias;

	public static void alta(Denuncia denuncia) {
		Consultas.actualizarDatos();
		if (!Consultas.comprobarRegistro(denuncia)) {
			Consultas.insertar(denuncia);
		} else {
			JOptionPane.showMessageDialog(null, "registro existente");
		}

	}

	public static void baja(Denuncia denuncia) {
		Consultas.actualizarDatos();
		if (Consultas.comprobarRegistro(denuncia)) {
			Consultas.borrar(denuncia, denuncia.getIdDenuncia());
		} else {
			JOptionPane.showMessageDialog(null, "registro no existente");
		}

	}

	public static void modificar(Denuncia denuncia, String[] campo, String[] dato, String id) {
		Consultas.actualizarDatos();
		if (Consultas.comprobarRegistro(denuncia)) {
			for (int i = 0; i < campo.length; i++) {
				Consultas.modificar(denuncia, campo[i], dato[i], id);
			}

		} else {
			JOptionPane.showMessageDialog(null, "registro no existente");
		}

	}

	public static String listar() {
		Consultas.actualizarDatos();
		String mensaje = "";
		for (Denuncia denuncia : denuncias) {
			mensaje += denuncia.toString() + '\n';
		}

		return mensaje;
	}
}
