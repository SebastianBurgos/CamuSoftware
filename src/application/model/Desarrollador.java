package application.model;

public class Desarrollador {
	private int id,id_estado;
	private String nombre, apellidos, cedula, telefono,
	email, direccion, password;
	
	public Desarrollador(){
		super();
	}
	
	public Desarrollador(int id,int id_estado, String nombre, String apellidos, String cedula, String telefono, String email,
			String direccion, String password) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.cedula = cedula;
		this.telefono = telefono;
		this.email = email;
		this.direccion = direccion;
		this.password = password;
		this.id_estado= id_estado;
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

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId_estado() {
		return id_estado;
	}

	public void setId_estado(int id_estado) {
		this.id_estado = id_estado;
	}

	@Override
	public String toString() {
		return "Desarrollador [id=" + id + ", id_estado=" + id_estado + ", nombre=" + nombre + ", apellidos="
				+ apellidos + ", cedula=" + cedula + ", telefono=" + telefono + ", email=" + email + ", direccion="
				+ direccion + ", password=" + password + "]";
	}


	

}
