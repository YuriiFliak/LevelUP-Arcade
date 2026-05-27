package usuarios.model;

/**
 * POJO que representa un Proveedor del sistema.
 * Autor: Yurii Fliak
 * Version: 2.0
 */

public class Proveedor {

    private int id;
    private String nombre;
    private String email;
    private String telefono;
    private String direccion;

    public Proveedor() {}

    public Proveedor(String nombre, String telefono, String email, String direccion) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
    }

    public Proveedor(int id, String nombre, String telefono, String email, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

	@Override
	public String toString() {
		return "Proveedor [id=" + id + ", nombre=" + nombre + ", email=" + email + ", telefono=" + telefono
				+ ", direccion=" + direccion + "]";
	}

   
}