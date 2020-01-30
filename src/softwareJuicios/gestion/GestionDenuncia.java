package softwareJuicios.gestion;

import java.util.ArrayList;

import softwareJuicios.entidades.Denuncia;
import softwareJuicios.operaciones.Consultas;

public class GestionDenuncia {
	public static ArrayList<Denuncia> denuncias = new ArrayList<Denuncia>();

	public void alta(Denuncia denuncia) {
		Consultas.actualizarDatos(denuncias);
		Consultas.comprobarRegistro(denuncia);
		denuncias.add(denuncia);
		Consultas.commit(denuncia);
	}

	public void baja(Denuncia denuncia) {

	}

	public void modificar(Denuncia denuncia) {
		
	}

	public String listar() {
		Consultas.actualizarDatos(denuncias);
		String mensaje = "";
		for (Denuncia denuncia : denuncias) {
			mensaje += denuncia.toString() + '\n';
		}
		return mensaje;

	}
}
