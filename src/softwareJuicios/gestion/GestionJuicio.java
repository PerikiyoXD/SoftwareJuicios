package softwareJuicios.gestion;

import java.util.ArrayList;

import softwareJuicios.entidades.Juicio;
import softwareJuicios.operaciones.Consultas;

public class GestionJuicio {
	public static ArrayList<Juicio> juicios = new ArrayList<Juicio>();

	public void alta(Juicio juicio) {
		Consultas.actualizarDatos(juicios);

		if (Consultas.comprobarRegistro(juicio)) {
			juicios.add(juicio);
			Consultas.commit(juicio);
		}

	}

	public void baja(Juicio juicio) {
		Consultas.actualizarDatos(juicios);

		if (Consultas.comprobarRegistro(juicio)) {
			Consultas.delete(juicio);
			Consultas.actualizarDatos(juicios);
		}
	}

	public void modificar(Juicio juicio) {

	}

	public String listar() {
		Consultas.actualizarDatos(juicios);
		String mensaje = "";
		for (Juicio juicio : juicios) {
			mensaje += juicio.toString() + '\n';
		}
		return mensaje;

	}

}
