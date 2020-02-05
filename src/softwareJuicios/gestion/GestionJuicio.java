package softwareJuicios.gestion;

import javax.swing.JOptionPane;

import org.neodatis.odb.Objects;

import softwareJuicios.entidades.Juicio;
import softwareJuicios.operaciones.Consultas;

public class GestionJuicio {
	public static Objects<Juicio> juicios;

	public static void alta(Juicio juicio) {
		Consultas.actualizarDatos();
		if (!Consultas.comprobarRegistro(juicio)) {
			Consultas.insertar(juicio);
		} else {
			JOptionPane.showMessageDialog(null, "registro existente");
		}
		Consultas.finalizar();
	}

	public static void baja(Juicio juicio) {
		Consultas.actualizarDatos();
		if (Consultas.comprobarRegistro(juicio)) {
			Consultas.borrar(juicio);
		} else {
			JOptionPane.showMessageDialog(null, "registro no existente");
		}
		Consultas.finalizar();
	}

	public static void modificar(Juicio juicio,String campo[],String dato[],String id) {
		Consultas.actualizarDatos();
		if (Consultas.comprobarRegistro(juicio)) {
			for (int i = 0; i < campo.length; i++) {
				Consultas.modificar(juicio,campo[i],dato[i],id);
			}
			
		} else {
			JOptionPane.showMessageDialog(null, "registro no existente");
		}
		Consultas.finalizar();
	}

	public static String listar() {
		Consultas.insertar(juicios);
		String mensaje = "";
		for (Juicio juicio : juicios) {
			mensaje += juicio.toString() + '\n';
		}
		Consultas.finalizar();
		return mensaje;

	}

}
