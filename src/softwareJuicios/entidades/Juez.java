package softwareJuicios.entidades;

public class Juez {
	public String dniJuez, nombre, apellidos;

	public Juez(String dniJuez, String nombre, String apellidos) {
		this.dniJuez = dniJuez;
		this.nombre = nombre;
		this.apellidos = apellidos;
	}

	public String getDniJuez() {
		return dniJuez;
	}

	public void setDniJuez(String dniJuez) {
		this.dniJuez = dniJuez;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	@Override
	public String toString() {
		return dniJuez + ": " + apellidos + ", " + nombre;
	}
}
