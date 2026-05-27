package usuarios.model;

/**
 * POJO que representa un Cliente del sistema.
 * Autor: Yurii Fliak
 * Version: 2.0
 */

public class Cliente {

    private int id;
    private String nombre;
    private String apellidos;
    private String email;
    private String telefono;
    private String direccion;

    public Cliente() {}

    public Cliente(String nombre, String apellidos, String email, String telefono, String direccion) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public Cliente(int id, String nombre, String apellidos, String email, String telefono, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    
    public String getApellido() { return apellidos; }
    public void setApellido(String apellidos) { this.apellidos = apellidos; }

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", apellido=" + apellidos + ", email=" + email
				+ ", telefono=" + telefono + ", direccion=" + direccion + "]";
	}

    
    
   }