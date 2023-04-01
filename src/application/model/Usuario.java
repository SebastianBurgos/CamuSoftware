package application.model;

public class Usuario {
	private int id;
	private String nombre, apellidos, cedula, telefono,
			email, direccion, ciudad_residencia, password;

	public Usuario() {
		super();
	}

	public Usuario(int id, String nombre, String apellidos, String cedula, String telefono, String email,
			String direccion, String ciudad_residencia, String password) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.cedula = cedula;
		this.telefono = telefono;
		this.email = email;
		this.direccion = direccion;
		this.ciudad_residencia = ciudad_residencia;
		this.password = password;
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

	public String getCiudad_residencia() {
		return ciudad_residencia;
	}

	public void setCiudad_residencia(String ciudad_residencia) {
		this.ciudad_residencia = ciudad_residencia;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", cedula=" + cedula
				+ ", telefono=" + telefono + ", email=" + email + ", direccion=" + direccion + ", ciudad_residencia="
				+ ciudad_residencia + ", password=" + password + "]";
	}
}
