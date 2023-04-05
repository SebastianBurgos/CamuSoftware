package application.model;

import java.sql.Date;

public class Implementacion {
	private int id;
	private int id_soporte;
	private String especificacion;
	private Date fecha_implementacion;
	private int horas_invertidas;
	private String estado;

	public Implementacion(int id, int id_soporte, String especificacion, Date fecha_implementacion,
			int horas_invertidas, String estado) {
		super();
		this.id = id;
		this.id_soporte = id_soporte;
		this.especificacion = especificacion;
		this.fecha_implementacion = fecha_implementacion;
		this.horas_invertidas = horas_invertidas;
		this.estado = estado;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_soporte() {
		return id_soporte;
	}
	public void setId_soporte(int id_soporte) {
		this.id_soporte = id_soporte;
	}
	public String getEspecificacion() {
		return especificacion;
	}
	public void setEspecificacion(String especificacion) {
		this.especificacion = especificacion;
	}
	public Date getFecha_implementacion() {
		return fecha_implementacion;
	}
	public void setFecha_implementacion(Date fecha_implementacion) {
		this.fecha_implementacion = fecha_implementacion;
	}
	public int getHoras_invertidas() {
		return horas_invertidas;
	}
	public void setHoras_invertidas(int horas_invertidas) {
		this.horas_invertidas = horas_invertidas;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	@Override
	public String toString() {
		return "Implementacion [id=" + id + ", id_soporte=" + id_soporte + ", especificacion=" + especificacion
				+ ", fecha_implementacion=" + fecha_implementacion + ", horas_invertidas=" + horas_invertidas
				+ ", estado=" + estado + "]";
	}
}
