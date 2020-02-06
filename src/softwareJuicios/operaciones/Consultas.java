package softwareJuicios.operaciones;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

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

	public static void insertar(Object object) {
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
		ConectorNeodatis.cerrarBaseDatos();
	}

	public static void borrar(Object object, Object id) {
		ConectorNeodatis.abrirBaseDatos();
		IQuery query;
		if (object instanceof Persona) {
			query = new CriteriaQuery(Persona.class, Where.equal("dni", id));
			Objects<Persona> objetos = ConectorNeodatis.baseDatos.getObjects(query);
			Persona aux = objetos.getFirst();
			ConectorNeodatis.baseDatos.delete(aux);
		}
		if (object instanceof Denuncia) {
			query = new CriteriaQuery(Denuncia.class, Where.equal("idDenuncia", id));
			Objects<Denuncia> objetos = ConectorNeodatis.baseDatos.getObjects(query);
			Denuncia aux = objetos.getFirst();
			ConectorNeodatis.baseDatos.delete(aux);
		}
		if (object instanceof Juicio) {
			query = new CriteriaQuery(Juicio.class, Where.equal("idJuicio", id));
			Objects<Juicio> objetos = ConectorNeodatis.baseDatos.getObjects(query);
			Juicio aux = objetos.getFirst();
			ConectorNeodatis.baseDatos.delete(aux);
		}
		if (object instanceof Juez) {
			query = new CriteriaQuery(Juez.class, Where.equal("dniJuez", id));
			Objects<Juez> objetos = ConectorNeodatis.baseDatos.getObjects(query);
			Juez aux = objetos.getFirst();
			ConectorNeodatis.baseDatos.delete(aux);
		}
		ConectorNeodatis.cerrarBaseDatos();
	}

	public static boolean comprobarRegistro(Object object) {

		actualizarDatos();
		ConectorNeodatis.abrirBaseDatos();

		System.out.println("The object:" + object);
		if (object instanceof Persona) {
			for (Persona personaaux : GestionPersona.personas) {
				if (personaaux.dni.equals(((Persona) object).dni)) {

					System.out.println("IOP: " + personaaux);
					System.out.println("IOP: " + (Persona) object);
					ConectorNeodatis.cerrarBaseDatos();
					return true;
				}
			}
		} else if (object instanceof Denuncia) {
			for (Denuncia denunciaaux : GestionDenuncia.denuncias) {
				if (denunciaaux.idDenuncia == ((Denuncia) object).idDenuncia) {
					ConectorNeodatis.cerrarBaseDatos();
					return true;
				}
			}
		} else if (object instanceof Juicio) {
			for (Juicio juicioaux : GestionJuicio.juicios) {
				if (juicioaux.idJuicio == ((Juicio) object).idJuicio) {
					ConectorNeodatis.cerrarBaseDatos();
					return true;
				}
			}
		} else if (object instanceof Juez) {
			for (Juez juezaux : GestionJuez.jueces) {
				if (juezaux.getDniJuez().equals(((Juez) object).getDniJuez())) {
					ConectorNeodatis.cerrarBaseDatos();
					return true;
				}
			}
		} else {
			System.out.println("ALGO VA MAL, EL TIPO NO ES EL CORRECTO?");
		}
		ConectorNeodatis.cerrarBaseDatos();
		return false;
	}

	public static void modificar(Object objeto, String campo, String dato, String id) {
		IQuery query;
		if (objeto instanceof Persona) {

			query = new CriteriaQuery(Persona.class, org.neodatis.odb.core.query.criteria.Where.equal("dni", id));
			Persona aux = (Persona) ConectorNeodatis.baseDatos.getObjects(query).getFirst();
			switch (campo) {
			case "nombre":
				aux.setNombre(dato);
				ConectorNeodatis.baseDatos.store(aux);
				break;
			case "apellido":
				aux.setApellido(dato);
				ConectorNeodatis.baseDatos.store(aux);

			default:
				break;
			}
		} else if (objeto instanceof Denuncia) {
			query = new CriteriaQuery(Denuncia.class, Where.equal("idDenuncia", id));
			Denuncia aux = (Denuncia) ConectorNeodatis.baseDatos.getObjects(query).getFirst();
			switch (campo) {
			case "dniAcusado":
				if (comprobarRegistro(getObject(0, dato))) {
					aux.setDniAcusado(dato);
					ConectorNeodatis.baseDatos.store(aux);
				}

				break;
			case "dniVicima":
				if (comprobarRegistro(getObject(0, dato))) {
					aux.setDniAcusado(dato);
					ConectorNeodatis.baseDatos.store(aux);
				}
				break;
			case "descripcion":
				aux.setDescripcion(dato);
				ConectorNeodatis.baseDatos.store(aux);
				break;
			case "fechaFormalizacion":
				Date date = null;
				SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

				try {
					date = formato.parse(dato);
				} catch (ParseException ex) {
					JOptionPane.showMessageDialog(null, "error formato de fecha");
				}
				aux.setFechaFormalizacion(date);
				ConectorNeodatis.baseDatos.store(aux);
				break;

			default:
				break;
			}
		} else if (objeto instanceof Juicio) {
			query = new CriteriaQuery(Juicio.class, Where.equal("idJuicio", id));
			Juicio aux = (Juicio) ConectorNeodatis.baseDatos.getObjects(query).getFirst();
			switch (campo) {
			case "idDenuncia":
				if (comprobarRegistro(getObject(1, dato))) {
					aux.setIdDenuncia(Integer.valueOf(dato));
					ConectorNeodatis.baseDatos.store(aux);
					break;
				}

			case "fechaInicio":
				Date date = null;
				SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

				try {
					date = formato.parse(dato);
				} catch (ParseException ex) {
					JOptionPane.showMessageDialog(null, "error formato de fecha");
				}
				aux.setFechaInicio(date);
				ConectorNeodatis.baseDatos.store(aux);
				break;
			case "fechaFinalizacion":
				Date date2 = null;
				SimpleDateFormat formato2 = new SimpleDateFormat("dd/MM/yyyy");

				try {
					date2 = formato2.parse(dato);
				} catch (ParseException ex) {
					JOptionPane.showMessageDialog(null, "error formato de fecha");
				}
				aux.setFechaFinalizacion(date2);
				ConectorNeodatis.baseDatos.store(aux);
				break;
			case "localidad":
				aux.setLocalidad(dato);
				ConectorNeodatis.baseDatos.store(aux);
				break;
			case "juicioAnterior":
				if (comprobarRegistro(getObject(3, dato))) {
					aux.setJuicioAnterior((Juicio) getObject(3, dato));
					ConectorNeodatis.baseDatos.store(aux);
				}

			default:
				break;
			}
		} else if (objeto instanceof Juez) {
			query = new CriteriaQuery(Juez.class, Where.equal("dniJuez", id));
			Juez aux = (Juez) ConectorNeodatis.baseDatos.getObjects(query).getFirst();
			switch (campo) {
			case "nombre":
				aux.setNombre(dato);
				ConectorNeodatis.baseDatos.store(aux);
				break;

			case "apellido":
				aux.setApellidos(dato);
				ConectorNeodatis.baseDatos.store(aux);
				break;
			default:
				break;
			}
		}

	}

	public static Object getObject(int i, String clave) {
		Object objetoreturn = null;

		switch (i) {
		case 0:
			for (Persona p : GestionPersona.personas) {
				if (p.getDni().equals(clave)) {
					return p;
				}
			}
			break;
		case 1:
			for (Denuncia d : GestionDenuncia.denuncias) {
				if (d.getIdDenuncia() == Integer.valueOf(clave)) {
					return d;
				}
			}
			break;
		case 2:
			for (Juez j : GestionJuez.jueces) {
				if (j.getDniJuez().equals(clave)) {
					return j;
				}
			}
			break;
		case 3:
			for (Juicio j : GestionJuicio.juicios) {
				if (j.getIdJuicio() == Integer.parseInt(clave)) {
					return j;
				}
			}
			break;
		default:
			break;
		}
		if (objetoreturn == null) {
			JOptionPane.showMessageDialog(null, "objeto no encontrado");
		}
		return objetoreturn;
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
		ConectorNeodatis.cerrarBaseDatos();
		return cuenta;
	}

}
