package application.model;

public class Plataforma {
	private int id;
	private String nombre;

	public Plataforma(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Plataforma [id=" + id + ", nombre=" + nombre + "]";
	}
}
