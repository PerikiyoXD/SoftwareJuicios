package softwareJuicios.utilidades;

import java.util.ArrayList;
import java.util.Iterator;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;

import softwareJuicios.entidades.Denuncia;
import softwareJuicios.entidades.Juez;
import softwareJuicios.entidades.Juicio;
import softwareJuicios.entidades.Persona;

public class ConectorNeodatis {
	public static ODB baseDatos;

	/***
	 * Abre base de datos
	 * 
	 * @param databaseFileName Ruta de la base de datos
	 * @return
	 */
	public static void abrirBaseDatos() {
		System.out.println("ABRIENDO BD");
		System.out.println("BD: " + baseDatos);
		if (baseDatos == null) {
			baseDatos = ODBFactory.open("juicio.db");
			System.out.println("BD: " + baseDatos);
			System.out.println(baseDatos.getObjects(Juez.class));
			System.out.println(baseDatos.getObjects(Juicio.class));
			System.out.println(baseDatos.getObjects(Denuncia.class));
			System.out.println(baseDatos.getObjects(Persona.class));
		}
	}

	/***
	 * Cierra base de datos
	 */
	public static void cerrarBaseDatos() {
		System.out.println("CERRANDO BD");
		baseDatos.close();
		baseDatos = null;
	}

	/***
	 * Genera una consulta
	 * 
	 * @param query Objeto de consulta
	 * @see org.neodatis.odb.core.query.IQuery
	 * @param orderBy String de orden, "nombre, edad" ordena por nombre y edad.
	 *                Siempre ascendente
	 * @return ArrayList de objetos
	 */
	public static ArrayList<Object> hacerConsulta(IQuery query, String orderBy) {
		ArrayList<Object> resultado = null;
		Objects<Object> objects = null;
		Iterator<Object> objectIterator = null;

		if (baseDatos == null) {
			System.out.println("ATENCION: ¡Base de datos cerrada!");
		}
		if (orderBy != null) {
			query.orderByAsc(orderBy);
		}
		objects = baseDatos.getObjects(query);
		objectIterator = objects.iterator();
		resultado = new ArrayList<Object>();
		while (objectIterator.hasNext()) {
			resultado.add(objectIterator.next());
		}
		return resultado;

	}
}
