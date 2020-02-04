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

	public static void alta(Object object) {
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

	public static void actualizarDatos() {
		ODB bd = ConectorNeodatis.abrirBaseDatos();
		GestionDenuncia.denuncias = bd.getObjects(Denuncia.class);
		GestionJuez.jueces = bd.getObjects(Juez.class);
		GestionJuicio.juicios = bd.getObjects(Juicio.class);
		GestionPersona.personas = bd.getObjects(Persona.class);
	}

	public static void finalizar() {
		ConectorNeodatis.cerrarBaseDatos();
	}

	public static boolean comprobarRegistro(Object object) {

		actualizarDatos();

		if (object instanceof Persona) {
			Persona persona = (Persona) object;
			for (Persona personaaux : GestionPersona.personas) {
				if (personaaux.equals(persona)) {
					return true;
				}
			}
		} else if (object instanceof Denuncia) {
			Denuncia denuncia = (Denuncia) object;
			for (Denuncia denunciaaux : GestionDenuncia.denuncias) {
				if (denunciaaux.getIdDenuncia() == denuncia.getIdDenuncia()) {
					return true;
				}
			}
		} else if (object instanceof Juicio) {
			Juicio juicio = (Juicio) object;
			actualizarDatos();
			for (Juicio juicioaux : GestionJuicio.juicios) {
				if (juicioaux.getIdJuicio() == juicio.getIdJuicio()) {
					return true;
				}
			}
		} else if (object instanceof Juez) {
			Juez juez = (Juez) object;
			for (Juez juezaux : GestionJuez.jueces) {
				if (juezaux.getDniJuez().equals(juez.getDniJuez())) {
					return true;
				}
			}
		}
		return false;
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

	public static void modificar(Object objeto) {
		// TODO Auto-generated method stub
		
	}

}
