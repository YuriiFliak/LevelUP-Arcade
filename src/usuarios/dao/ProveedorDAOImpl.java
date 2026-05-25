/**
 * Implementación de la interfaz ProveedorDAO.
 * Gestiona las operaciones CRUD de proveedores en memoria.
 * Autor: Yurii Fliak
 * Version: 1.0
 */
package usuarios.dao;

import java.util.ArrayList;
import java.util.List;

import usuarios.model.Proveedor;

public class ProveedorDAOImpl implements ProveedorDAO {

    private List<Proveedor> proveedores = new ArrayList<>();

    @Override
    public void insertar(Proveedor proveedor) {

        try {

            proveedores.add(proveedor);

            System.out.println("Proveedor añadido");

        } catch (Exception e) {

            System.out.println(
                    "Error al insertar proveedor"
            );

            e.printStackTrace();
        }
    }

    @Override
    public List<Proveedor> listar() {

        return proveedores;
    }

    @Override
    public Proveedor buscarPorId(int id) {

        try {

            for (Proveedor p : proveedores) {

                if (p.getId() == id) {

                    return p;
                }
            }

        } catch (Exception e) {

            System.out.println(
                    "Error al buscar proveedor"
            );

            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void actualizar(Proveedor proveedor) {

        try {

            Proveedor existente =
                    buscarPorId(proveedor.getId());

            if (existente != null) {

                existente.setNombre(
                        proveedor.getNombre()
                );

                existente.setTelefono(
                        proveedor.getTelefono()
                );

                System.out.println(
                        "Proveedor actualizado"
                );

            } else {

                System.out.println(
                        "Proveedor no encontrado"
                );
            }

        } catch (Exception e) {

            System.out.println(
                    "Error al actualizar proveedor"
            );

            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {

        try {

            Proveedor proveedor =
                    buscarPorId(id);

            if (proveedor != null) {

                proveedores.remove(proveedor);

                System.out.println(
                        "Proveedor eliminado"
                );

            } else {

                System.out.println(
                        "Proveedor no encontrado"
                );
            }

        } catch (Exception e) {

            System.out.println(
                    "Error al eliminar proveedor"
            );

            e.printStackTrace();
        }
    }
}