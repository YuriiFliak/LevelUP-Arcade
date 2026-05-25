/**
 * Interfaz DAO para la gestión de Proveedor.
 * Define las operaciones CRUD de la entidad Proveedor.
 * Autor: Yurii Fliak
 * Version: 1.0
 */

package usuarios.dao;

import java.util.List;
import usuarios.model.Proveedor;

public interface ProveedorDAO {

    void insertar(Proveedor proveedor);

    List<Proveedor> listar();

    Proveedor buscarPorId(int id);

    void actualizar(Proveedor proveedor);

    void eliminar(int id);
}