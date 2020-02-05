package softwareJuicios.entidades;

import java.util.Date;

public class Juicio {
	public int idJuicio, idDenuncia;
	public Date fechaInicio, fechaFinalizacion;
	public String localidad;
	public boolean finalizado;
	public Juicio juicioAnterior;

	public Juicio(int idJuicio, int idDenuncia, Date fechaInicio, Date fechaFinalizacion, String localidad,
			boolean finalizado, Juicio juicioAnterior) {
		this.idJuicio = idJuicio;
		this.idDenuncia = idDenuncia;
		this.fechaInicio = fechaInicio;
		this.fechaFinalizacion = fechaFinalizacion;
		this.localidad = localidad;
		this.finalizado = finalizado;
		this.juicioAnterior = juicioAnterior;
	}

	public int getIdJuicio() {
		return idJuicio;
	}

	public void setIdJuicio(int idJuicio) {
		this.idJuicio = idJuicio;
	}

	public int getIdDenuncia() {
		return idDenuncia;
	}

	public void setIdDenuncia(int idDenuncia) {
		this.idDenuncia = idDenuncia;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFinalizacion() {
		return fechaFinalizacion;
	}

	public void setFechaFinalizacion(Date fechaFinalizacion) {
		this.fechaFinalizacion = fechaFinalizacion;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public boolean isFinalizado() {
		return finalizado;
	}

	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}

	public Juicio getJuicioAnterior() {
		return juicioAnterior;
	}

	public void setJuicioAnterior(Juicio juicioAnterior) {
		this.juicioAnterior = juicioAnterior;
	}

	@Override
	public String toString() {
		return "Juicio [idJuicio=" + idJuicio + ", idDenuncia=" + idDenuncia + ", fechaInicio=" + fechaInicio
				+ ", fechaFinalizacion=" + fechaFinalizacion + ", localidad=" + localidad + ", finalizado=" + finalizado
				+ ", juicioAnterior=" + juicioAnterior + "]";
	}

}
