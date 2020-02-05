package softwareJuicios.entidades;

import java.util.Date;

public class Denuncia {
	public String dniAcusado, dniVictima, descripcion;
	public int idDenuncia;
	public Date fechaFormalizacion;

	public Denuncia(String dniAcusado, String dniVictima, String descripcion, int idDenuncia, Date fechaFormalizacion) {
		this.dniAcusado = dniAcusado;
		this.dniVictima = dniVictima;
		this.descripcion = descripcion;
		this.idDenuncia = idDenuncia;
		this.fechaFormalizacion = fechaFormalizacion;
	}

	public String getDniAcusado() {
		return dniAcusado;
	}

	public void setDniAcusado(String dniAcusado) {
		this.dniAcusado = dniAcusado;
	}

	public String getDniVictima() {
		return dniVictima;
	}

	public void setDniVictima(String dniVictima) {
		this.dniVictima = dniVictima;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getIdDenuncia() {
		return idDenuncia;
	}

	public void setIdDenuncia(int idDenuncia) {
		this.idDenuncia = idDenuncia;
	}

	public Date getFechaFormalizacion() {
		return fechaFormalizacion;
	}

	public void setFechaFormalizacion(Date fechaFormalizacion) {
		this.fechaFormalizacion = fechaFormalizacion;
	}

	@Override
	public String toString() {
		return "Denuncia [dniAcusado=" + dniAcusado + ", dniVictima=" + dniVictima + ", descripcion=" + descripcion
				+ ", idDenuncia=" + idDenuncia + ", fechaFormalizacion=" + fechaFormalizacion + "]";
	}

}
