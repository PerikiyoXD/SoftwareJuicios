package softwareJuicios.gestion;

import javax.swing.JOptionPane;

import org.neodatis.odb.Objects;

import softwareJuicios.entidades.Denuncia;
import softwareJuicios.operaciones.Consultas;

public class GestionDenuncia {
	public static Objects<Denuncia> denuncias;

	public void alta(Denuncia denuncia) {
		Consultas.actualizarDatos();
		if (!Consultas.comprobarRegistro(denuncia)) {
			Consultas.alta(denuncia);
		} else {
			JOptionPane.showMessageDialog(null, "registro existente");
		}
		Consultas.finalizar();
	}

	public void baja(Denuncia denuncia) {
		Consultas.actualizarDatos();
		if (Consultas.comprobarRegistro(denuncia)) {
			Consultas.delete(denuncia);
		} else {
			JOptionPane.showMessageDialog(null, "registro no existente");
		}
		Consultas.finalizar();
	}

	public void modificar(Denuncia denuncia) {
		Consultas.actualizarDatos();
		if (Consultas.comprobarRegistro(denuncia)) {
			Consultas.modificar(denuncia);
		} else {
			JOptionPane.showMessageDialog(null, "registro no existente");
		}
		Consultas.finalizar();
	}

	public String listar() {
		Consultas.actualizarDatos();
		String mensaje = "";
		for (Denuncia denuncia : denuncias) {
			mensaje += denuncia.toString() + '\n';
		}
		Consultas.finalizar();
		return mensaje;
	}
}
