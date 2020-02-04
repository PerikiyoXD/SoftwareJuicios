package softwareJuicios.operaciones;

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
		actualizarDatos();
		ConectorNeodatis.abrirBaseDatos();
		if (object instanceof Persona) {
			Persona persona = (Persona) object;
			ConectorNeodatis.baseDatos.store(persona);
		}
		if (object instanceof Denuncia) {
			Denuncia denuncia = (Denuncia) object;
			ConectorNeodatis.baseDatos.store(denuncia);
		}
		if (object instanceof Juicio) {
			Juicio juicio = (Juicio) object;
			ConectorNeodatis.baseDatos.store(juicio);
		}
		if (object instanceof Juez) {
			Juez juez = (Juez) object;
			ConectorNeodatis.baseDatos.store(juez);
		}
		finalizar();
	}

	public static void actualizarDatos() {
		ConectorNeodatis.abrirBaseDatos();
		try {
			GestionDenuncia.denuncias = ConectorNeodatis.baseDatos.getObjects(Denuncia.class);
		} catch (Exception e) {
			System.out.println("denuncias = NULL!" + e.getMessage());
		}
		try {
			GestionJuez.jueces = ConectorNeodatis.baseDatos.getObjects(Juez.class);
		} catch (Exception e) {
			System.out.println("jueces = NULL!" + e.getMessage());
		}
		try {
			GestionJuicio.juicios = ConectorNeodatis.baseDatos.getObjects(Juicio.class);
		} catch (Exception e) {
			System.out.println("juicios = NULL!" + e.getMessage());
		}
		try {
			GestionPersona.personas = ConectorNeodatis.baseDatos.getObjects(Persona.class);
		} catch (Exception e) {
			System.out.println("personas = NULL!" + e.getMessage());
		}
		ConectorNeodatis.cerrarBaseDatos();
	}

	public static void finalizar() {
		System.out.println("Llama finalizar");
		ConectorNeodatis.cerrarBaseDatos();
	}

	public static boolean comprobarRegistro(Object object) {

		actualizarDatos();
		ConectorNeodatis.abrirBaseDatos();

		System.out.println(object);
		if (object instanceof Persona) {
			Persona persona = (Persona) object;
			for (Persona personaaux : GestionPersona.personas) {
				if (personaaux.equals(persona)) {
					finalizar();
					return true;
				}
			}
		} else if (object instanceof Denuncia) {
			Denuncia denuncia = (Denuncia) object;
			for (Denuncia denunciaaux : GestionDenuncia.denuncias) {
				if (denunciaaux.getIdDenuncia() == denuncia.getIdDenuncia()) {
					finalizar();
					return true;
				}
			}
		} else if (object instanceof Juicio) {
			Juicio juicio = (Juicio) object;
			for (Juicio juicioaux : GestionJuicio.juicios) {
				if (juicioaux.getIdJuicio() == juicio.getIdJuicio()) {
					finalizar();
					return true;
				}
			}
		} else if (object instanceof Juez) {
			Juez juez = (Juez) object;
			for (Juez juezaux : GestionJuez.jueces) {
				if (juezaux.getDniJuez().equals(juez.getDniJuez())) {
					finalizar();
					return true;
				}
			}
		} else {
			System.out.println("ALGO VA MAL, EEL TIPO NO ES EL CORRECTO?");
		}
		finalizar();
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

	public static int count(Class<?> clase) {
		int cuenta = -1;

		actualizarDatos();
		if (clase == Juez.class) {
			cuenta = GestionJuez.jueces.size();
		} else if (clase == Persona.class) {
			cuenta = GestionPersona.personas.size();
		} else if (clase == Juicio.class) {
			cuenta = GestionJuicio.juicios.size();
		} else if (clase == Denuncia.class) {
			cuenta = GestionDenuncia.denuncias.size();
		}
		finalizar();
		return cuenta;
	}

}
