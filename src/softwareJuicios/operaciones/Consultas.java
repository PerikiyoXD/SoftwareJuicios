package softwareJuicios.operaciones;

import org.neodatis.odb.ODB;

import softwareJuicios.entidades.Denuncia;
import softwareJuicios.entidades.Juez;
import softwareJuicios.entidades.Juicio;
import softwareJuicios.entidades.Persona;
import softwareJuicios.gestion.GestionDenuncia;
import softwareJuicios.gestion.GestionJuez;
import softwareJuicios.gestion.GestionJuicio;
import softwareJuicios.gestion.GestionPersona;
import softwareJuicios.utilidades.ConectorNeodatis;

public class Consultas {

	public static void actualizarDatos(Object object) {
		if (object instanceof Persona) {
			Persona persona = (Persona) object;
			ODB bd = ConectorNeodatis.abrirBaseDatos();
			bd.store(persona);

		}
		if (object instanceof Denuncia) {
			Denuncia denuncia = (Denuncia) object;
			ODB bd = ConectorNeodatis.abrirBaseDatos();
			bd.store(denuncia);
		}
		if (object instanceof Juicio) {
			Juicio juicio = (Juicio) object;
			ODB bd = ConectorNeodatis.abrirBaseDatos();
			bd.store(juicio);
		}
		if (object instanceof Juez) {
			Juez juez = (Juez) object;
			ODB bd = ConectorNeodatis.abrirBaseDatos();
			bd.store(juez);
		}
		ConectorNeodatis.cerrarBaseDatos();

	}

	public static void recuperar() {
		ODB bd = ConectorNeodatis.abrirBaseDatos();
		GestionDenuncia.denuncias = bd.getObjects(Denuncia.class);
		GestionJuez.jueces = bd.getObjects(Juez.class);
		GestionJuicio.juicios = bd.getObjects(Juicio.class);
		GestionPersona.personas = bd.getObjects(Persona.class);
	}

	public static boolean comprobarRegistro(Object object) {
		// TODO Auto-generated method stub
		if (object instanceof Persona) {
			Persona persona = (Persona) object;
			recuperar();
			for (Persona personaaux : GestionPersona.personas) {
				if (personaaux.equals(persona)) {
					return true;
				}
			}
		}
		if (object instanceof Denuncia) {
			Denuncia denuncia = (Denuncia) object;
			recuperar();
			for (Denuncia denunciaaux : GestionDenuncia.denuncias) {
				if (denunciaaux.equals(denuncia)) {
					return true;
				}
			}
		}
		if (object instanceof Juicio) {
			Juicio juicio = (Juicio) object;
			recuperar();
			for (Juicio juicioaux : GestionJuicio.juicios) {
				if (juicioaux.equals(juicio)) {
					return true;
				}
			}
		}
		if (object instanceof Juez) {
			Juez juez = (Juez) object;
			for (Juez juezaux : GestionJuez.jueces) {
				if (juezaux.equals(juez)) {
					return true;
				}
			}
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
