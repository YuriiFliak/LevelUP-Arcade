/**
 * Implementación de la interfaz ProductoDAO.
 * Gestiona las operaciones CRUD de productos en memoria.
 * Autor: Yurii Fliak
 * Version: 1.0
 */
package usuarios.dao;

import java.util.ArrayList;
import java.util.List;

import usuarios.model.Producto;

public class ProductoDAOImpl implements ProductoDAO {

    private List<Producto> productos = new ArrayList<>();

    @Override
    public void insertar(Producto producto) {

        try {

            productos.add(producto);

            System.out.println("Producto añadido");

        } catch (Exception e) {

            System.out.println(
                    "Error al insertar producto"
            );

            e.printStackTrace();
        }
    }

    @Override
    public List<Producto> listar() {

        return productos;
    }

    @Override
    public Producto buscarPorId(int id) {

        try {

            for (Producto p : productos) {

                if (p.getId() == id) {

                    return p;
                }
            }

        } catch (Exception e) {

            System.out.println(
                    "Error al buscar producto"
            );

            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void actualizar(Producto producto) {

        try {

            Producto existente =
                    buscarPorId(producto.getId());

            if (existente != null) {

                existente.setNombre(
                        producto.getNombre()
                );

                existente.setPrecio(
                        producto.getPrecio()
                );

                existente.setStock(
                        producto.getStock()
                );

                System.out.println(
                        "Producto actualizado"
                );

            } else {

                System.out.println(
                        "Producto no encontrado"
                );
            }

        } catch (Exception e) {

            System.out.println(
                    "Error al actualizar producto"
            );

            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {

        try {

            Producto producto =
                    buscarPorId(id);

            if (producto != null) {

                productos.remove(producto);

                System.out.println(
                        "Producto eliminado"
                );

            } else {

                System.out.println(
                        "Producto no encontrado"
                );
            }

        } catch (Exception e) {

            System.out.println(
                    "Error al eliminar producto"
            );

            e.printStackTrace();
        }
    }
}