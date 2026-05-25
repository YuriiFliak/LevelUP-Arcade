/**
 * Interfaz DAO para la gestión de clientes.
 * Define las operaciones CRUD de la entidad Cliente.
 * Autor: Yurii Fliak
 * Version: 1.0
 */

package usuarios.dao;

import java.util.List;
import usuarios.model.Cliente;

public interface ClienteDAO {

    void insertar(Cliente cliente);

    List<Cliente> listar();

    Cliente buscarPorId(int id);

    void actualizar(Cliente cliente);

    void eliminar(int id);
}