/**
 * Interfaz DAO para la gestión de categorías.
 * Define las operaciones CRUD de la entidad Categoria.
 * Autor: Yurii Fliak
 * Version: 1.0
 */

package usuarios.dao;

import java.util.List;
import usuarios.model.Categoria;

public interface CategoriaDAO {

    void insertar(Categoria categoria);

    List<Categoria> listar();

    Categoria buscarPorId(int id);

    void actualizar(Categoria categoria);

    void eliminar(int id);
}