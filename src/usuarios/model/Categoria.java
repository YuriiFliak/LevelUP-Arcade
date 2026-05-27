package usuarios.model;

/**
 * POJO que representa una Categoria del sistema.
 * Autor: Yurii Fliak
 * Version: 2.0
 */

public class Categoria {

    private int id;
    private String nombre;
    private String descripcion;

    public Categoria() {}

    public Categoria(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Categoria(int id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String toString() {
        return "Categoria [id=" + id + ", nombre=" + nombre +
                ", descripcion=" + descripcion + "]";
    }
}