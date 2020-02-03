package softwareJuicios.gestion;

import javax.swing.JOptionPane;

import org.neodatis.odb.Objects;

import softwareJuicios.entidades.Denuncia;
import softwareJuicios.operaciones.Consultas;

public class GestionDenuncia {
	public static Objects<Denuncia> denuncias;

	public void alta(Denuncia denuncia) {
		Consultas.actualizarDatos(denuncias);

		if (Consultas.comprobarRegistro(denuncia)) {
			JOptionPane.showMessageDialog(null, "registro existente");
		}else {
			denuncias.add(denuncia);
		}

	}

	public void baja(Denuncia denuncia) {
		Consultas.actualizarDatos(denuncias);

		if (Consultas.comprobarRegistro(denuncia)) {
			Consultas.delete(denuncia);
			Consultas.actualizarDatos(denuncias);
		}else {
			JOptionPane.showMessageDialog(null, "No existe registro");
		}

	}

	public void modificar(Denuncia denuncia) {

	}

	public String listar() {
		Consultas.actualizarDatos(denuncias);
		String mensaje = "";
		for (Denuncia denuncia : denuncias) {
			mensaje += denuncia.toString() + '\n';
		}
		return mensaje;

	}
}
