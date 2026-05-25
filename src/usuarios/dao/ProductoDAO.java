/**
 * Interfaz DAO para la gestión de Producto.
 * Define las operaciones CRUD de la entidad Producto.
 * Autor: Yurii Fliak
 * Version: 1.0
 */

package usuarios.dao;

import java.util.List;
import usuarios.model.Producto;

public interface ProductoDAO {

    void insertar(Producto producto);

    List<Producto> listar();

    Producto buscarPorId(int id);

    void actualizar(Producto producto);

    void eliminar(int id);
}