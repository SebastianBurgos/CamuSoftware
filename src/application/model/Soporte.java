package application.model;

import java.sql.Date;

public class Soporte {
	private int id;
	private int id_pqrs;
	private String estado;
	private String tipo;
	private Date fecha_creacion;
	private Date fecha_ultima_actualizacion;
	private String tiempo_respuesta;
	private String observaciones;
	private String respuesta;

	public Soporte(int id, int id_pqrs, String estado, String tipo, Date fecha_creacion,
			Date fecha_ultima_actualizacion, String tiempo_respuesta, String observaciones, String respuesta) {
		super();
		this.id = id;
		this.id_pqrs = id_pqrs;
		this.estado = estado;
		this.tipo = tipo;
		this.fecha_creacion = fecha_creacion;
		this.fecha_ultima_actualizacion = fecha_ultima_actualizacion;
		this.tiempo_respuesta = tiempo_respuesta;
		this.observaciones = observaciones;
		this.respuesta = respuesta;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_pqrs() {
		return id_pqrs;
	}

	public void setId_pqrs(int id_pqrs) {
		this.id_pqrs = id_pqrs;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Date getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public Date getFecha_ultima_actualizacion() {
		return fecha_ultima_actualizacion;
	}

	public void setFecha_ultima_actualizacion(Date fecha_ultima_actualizacion) {
		this.fecha_ultima_actualizacion = fecha_ultima_actualizacion;
	}

	public String getTiempo_respuesta() {
		return tiempo_respuesta;
	}

	public void setTiempo_respuesta(String tiempo_respuesta) {
		this.tiempo_respuesta = tiempo_respuesta;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	@Override
	public String toString() {
		return "Soporte [id=" + id + ", id_pqrs=" + id_pqrs + ", estado=" + estado + ", tipo=" + tipo
				+ ", fecha_creacion=" + fecha_creacion + ", fecha_ultima_actualizacion=" + fecha_ultima_actualizacion
				+ ", tiempo_respuesta=" + tiempo_respuesta + ", observaciones=" + observaciones + ", respuesta="
				+ respuesta + "]";
	}
}
