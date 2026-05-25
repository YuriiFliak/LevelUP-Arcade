/**
 * Implementación de la interfaz CategoriaDAO.
 * Gestiona las operaciones CRUD de categorías en memoria.
 * Autor: Yurii Fliak
 * Version: 1.0
 */
package usuarios.dao;

import java.util.ArrayList;
import java.util.List;

import usuarios.model.Categoria;

public class CategoriaDAOImpl implements CategoriaDAO {

    private List<Categoria> categorias = new ArrayList<>();

    @Override
    public void insertar(Categoria categoria) {

        try {

            categorias.add(categoria);

            System.out.println("Categoría añadida");

        } catch (Exception e) {

            System.out.println(
                    "Error al insertar categoría"
            );

            e.printStackTrace();
        }
    }

    @Override
    public List<Categoria> listar() {

        return categorias;
    }

    @Override
    public Categoria buscarPorId(int id) {

        try {

            for (Categoria c : categorias) {

                if (c.getId() == id) {

                    return c;
                }
            }

        } catch (Exception e) {

            System.out.println(
                    "Error al buscar categoría"
            );

            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void actualizar(Categoria categoria) {

        try {

            Categoria existente =
                    buscarPorId(categoria.getId());

            if (existente != null) {

                existente.setNombre(
                        categoria.getNombre()
                );

                System.out.println(
                        "Categoría actualizada"
                );

            } else {

                System.out.println(
                        "Categoría no encontrada"
                );
            }

        } catch (Exception e) {

            System.out.println(
                    "Error al actualizar categoría"
            );

            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {

        try {

            Categoria categoria =
                    buscarPorId(id);

            if (categoria != null) {

                categorias.remove(categoria);

                System.out.println(
                        "Categoría eliminada"
                );

            } else {

                System.out.println(
                        "Categoría no encontrada"
                );
            }

        } catch (Exception e) {

            System.out.println(
                    "Error al eliminar categoría"
            );

            e.printStackTrace();
        }
    }
}