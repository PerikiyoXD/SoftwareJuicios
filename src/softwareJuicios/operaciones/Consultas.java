package softwareJuicios.operaciones;

import softwareJuicios.entidades.Denuncia;
import softwareJuicios.entidades.Juez;
import softwareJuicios.entidades.Juicio;
import softwareJuicios.entidades.Persona;

public class Consultas {

	public static void actualizarDatos(Object object) {
		if (object instanceof Persona) {
			Persona persona = (Persona) object;

		}
		if (object instanceof Denuncia) {
			Denuncia denuncia = (Denuncia) object;

		}
		if (object instanceof Juicio) {
			Juicio juicio = (Juicio) object;

		}
		if (object instanceof Juez) {
			Juez juez = (Juez) object;

		}
	}

	public static boolean comprobarRegistro(Object object) {
		// TODO Auto-generated method stub
		if (object instanceof Persona) {
			Persona persona = (Persona) object;
			return true;
		}
		if (object instanceof Denuncia) {
			Denuncia denuncia = (Denuncia) object;
			return true;
		}
		if (object instanceof Juicio) {
			Juicio juicio = (Juicio) object;
			return true;
		}
		if (object instanceof Juez) {
			Juez juez = (Juez) object;
			return true;
		}
		return false;
	}

	public static void commit(Object object) {
		// TODO Auto-generated method stub
		if (object instanceof Persona) {
			Persona persona = (Persona) object;

		}
		if (object instanceof Denuncia) {
			Denuncia denuncia = (Denuncia) object;

		}
		if (object instanceof Juicio) {
			Juicio juicio = (Juicio) object;

		}
		if (object instanceof Juez) {
			Juez juez = (Juez) object;

		}
	}

	public static void delete(Object object) {
		// TODO Auto-generated method stub
		if (object instanceof Persona) {
			Persona persona = (Persona) object;

		}
		if (object instanceof Denuncia) {
			Denuncia denuncia = (Denuncia) object;

		}
		if (object instanceof Juicio) {
			Juicio juicio = (Juicio) object;

		}
		if (object instanceof Juez) {
			Juez juez = (Juez) object;

		}

	}

}
