package es.deusto.sd.auctions.entity;

public class Personal {
	private Long id;
    private String email; 
    private String passwordHash; 
    private String nombre;
    private String apellido;
    private String rol;
    
	public Personal(Long id, String email, String passwordHash, String nombre, String apellido, String rol) {
		super();
		this.id = id;
		this.email = email;
		this.passwordHash = passwordHash;
		this.nombre = nombre;
		this.apellido = apellido;
		this.rol = rol;
	}
	
	public Personal() {
		super();
		this.id = null;
		this.email = null;
		this.passwordHash = null;
		this.nombre = null;
		this.apellido = null;
		this.rol = null;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	@Override
	public String toString() {
		return "Personal [id=" + id + ", email=" + email + ", passwordHash=" + passwordHash + ", nombre=" + nombre
				+ ", apellido=" + apellido + ", rol=" + rol + "]";
	}
	    
}