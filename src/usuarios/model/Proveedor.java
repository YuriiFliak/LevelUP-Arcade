/**
 * POJO que representa un Proveedor del sistema.
 * Autor: Yurii Fliak
 * Version: 1.0
 */

package usuarios.model;

public class Proveedor {

    private int id;
    private String nombre;
    private String telefono;

    public Proveedor() {}

    public Proveedor(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public Proveedor(int id, String nombre, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Proveedor [id=" + id + ", nombre=" + nombre + ", telefono=" + telefono + "]";
	}

    
}