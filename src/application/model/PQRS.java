package application.model;

import java.sql.Date;

public class PQRS {
	private int id;
	private int id_usuario;
	private int id_plataforma;
	private int id_modulo;
	private int id_tipo;
	private String detalles;
	private String asunto;
	private Date fecha_solicitud;
	private String estado;

	public PQRS(int id, int id_usuario, int id_plataforma, int id_modulo, int id_tipo, String detalles, String asunto,
			Date fecha_solicitud, String estado) {
		super();
		this.id = id;
		this.id_usuario = id_usuario;
		this.id_plataforma = id_plataforma;
		this.id_modulo = id_modulo;
		this.id_tipo = id_tipo;
		this.detalles = detalles;
		this.asunto = asunto;
		this.fecha_solicitud = fecha_solicitud;
		this.estado = estado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public int getId_plataforma() {
		return id_plataforma;
	}

	public void setId_plataforma(int id_plataforma) {
		this.id_plataforma = id_plataforma;
	}

	public int getId_modulo() {
		return id_modulo;
	}

	public void setId_modulo(int id_modulo) {
		this.id_modulo = id_modulo;
	}

	public int getId_tipo() {
		return id_tipo;
	}

	public void setId_tipo(int id_tipo) {
		this.id_tipo = id_tipo;
	}

	public String getDetalles() {
		return detalles;
	}

	public void setDetalles(String detalles) {
		this.detalles = detalles;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public Date getFecha_solicitud() {
		return fecha_solicitud;
	}

	public void setFecha_solicitud(Date fecha_solicitud) {
		this.fecha_solicitud = fecha_solicitud;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "PQRS [id=" + id + ", id_usuario=" + id_usuario + ", id_plataforma=" + id_plataforma + ", id_modulo="
				+ id_modulo + ", id_tipo=" + id_tipo + ", detalles=" + detalles + ", asunto=" + asunto
				+ ", fecha_solicitud=" + fecha_solicitud + ", estado=" + estado + "]";
	}

}
