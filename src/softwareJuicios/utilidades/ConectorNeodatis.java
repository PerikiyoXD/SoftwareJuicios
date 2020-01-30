package softwareJuicios.utilidades;

import java.util.ArrayList;
import java.util.Iterator;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;

public class ConectorNeodatis {
	private ODB baseDatos;

	/***
	 * Abre base de datos
	 * 
	 * @param databaseFileName Ruta de la base de datos
	 */
	public void abrirBaseDatos(String databaseFileName) {
		baseDatos = ODBFactory.open(databaseFileName);
	}

	/***
	 * Cierra base de datos
	 */
	public void cerrarBaseDatos() {
		baseDatos.close();
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
	public ArrayList<Object> hacerConsulta(IQuery query, String orderBy) {
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
