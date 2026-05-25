/**
 * Implementación de la interfaz ClienteDAO.
 * Gestiona las operaciones CRUD de clientes en memoria.
 * Autor: Yurii Fliak
 * Version: 1.0
 */
package usuarios.dao;

import java.util.ArrayList;
import java.util.List;

import usuarios.model.Cliente;

public class ClienteDAOImpl implements ClienteDAO {

    private List<Cliente> clientes = new ArrayList<>();

    @Override
    public void insertar(Cliente cliente) {

        try {

            clientes.add(cliente);

            System.out.println("Cliente añadido");

        } catch (Exception e) {

            System.out.println(
                    "Error al insertar cliente"
            );

            e.printStackTrace();
        }
    }

    @Override
    public List<Cliente> listar() {

        return clientes;
    }

    @Override
    public Cliente buscarPorId(int id) {

        try {

            for (Cliente c : clientes) {

                if (c.getId() == id) {

                    return c;
                }
            }

        } catch (Exception e) {

            System.out.println(
                    "Error al buscar cliente"
            );

            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void actualizar(Cliente cliente) {

        try {

            Cliente existente =
                    buscarPorId(cliente.getId());

            if (existente != null) {

                existente.setNombre(
                        cliente.getNombre()
                );

                existente.setEmail(
                        cliente.getEmail()
                );

                System.out.println(
                        "Cliente actualizado"
                );

            } else {

                System.out.println(
                        "Cliente no encontrado"
                );
            }

        } catch (Exception e) {

            System.out.println(
                    "Error al actualizar cliente"
            );

            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {

        try {

            Cliente cliente =
                    buscarPorId(id);

            if (cliente != null) {

                clientes.remove(cliente);

                System.out.println(
                        "Cliente eliminado"
                );

            } else {

                System.out.println(
                        "Cliente no encontrado"
                );
            }

        } catch (Exception e) {

            System.out.println(
                    "Error al eliminar cliente"
            );

            e.printStackTrace();
        }
    }
}