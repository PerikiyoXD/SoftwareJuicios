package softwareJuicios.gestion;

import java.util.ArrayList;

import softwareJuicios.entidades.Denuncia;
import softwareJuicios.operaciones.Consultas;

public class GestionDenuncia {
	public static ArrayList<Denuncia> denuncias = new ArrayList<Denuncia>();

	public void alta() {
		
	}

	public void baja() {

	}

	public void modificar() {
		
	}

	public String listar() {
		Consultas.actualizarDatos();
		String mensaje = "";
		for (Denuncia denuncia : denuncias) {
			mensaje += denuncia.toString() + '\n';
		}
		return mensaje;

	}
}
