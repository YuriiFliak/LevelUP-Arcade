package usuarios.model;

/**
 * POJO que representa un Producto del sistema.
 * Autor: Yurii Fliak
 * Version: 2.0
 */

public class Producto {

    private int id;
    private String nombre;
    private String descripcion;
    private double precio;
    private int stock;
    private int idCategoria;
    private int idProveedor;

    public Producto() {}

    public Producto(String nombre, String descripcion, double precio,
                    int stock, int idCategoria, int idProveedor) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.idCategoria = idCategoria;
        this.idProveedor = idProveedor;
    }

    public Producto(int id, String nombre, String descripcion, double precio,
                    int stock, int idCategoria, int idProveedor) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.idCategoria = idCategoria;
        this.idProveedor = idProveedor;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public double getPrecio() { return precio; }
   

    public int getStock() { return stock; }
    

    public int getIdCategoria() { return idCategoria; }
    public void setIdCategoria(int idCategoria) { this.idCategoria = idCategoria; }

    public int getIdProveedor() { return idProveedor; }
    public void setIdProveedor(int idProveedor) { this.idProveedor = idProveedor; }

    public String toString() {
        return "Producto [id=" + id + ", nombre=" + nombre +
                ", descripcion=" + descripcion + ", precio=" + precio +
                ", stock=" + stock + ", idCategoria=" + idCategoria +
                ", idProveedor=" + idProveedor + "]";
    }
    
    public void setPrecio(double precio) {

        if (precio < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }

        this.precio = precio;
    }
    
    public void setStock(int stock) {

        if (stock < 0) {
            throw new IllegalArgumentException("El stock no puede ser negativo");
        }

        this.stock = stock;
    }
}