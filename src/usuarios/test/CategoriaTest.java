package usuarios.test;

import org.junit.jupiter.api.Test;
import usuarios.model.Categoria;
import usuarios.dao.CategoriaDAO;
import usuarios.dao.CategoriaDAOImpl;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests JUnit para Categoria
 */

public class CategoriaTest {

    // ================= MODELO =================

    @Test
    void testCrearCategoria() {

        Categoria c = new Categoria(1, "Acción", "Juegos de acción");

        assertEquals("Acción", c.getNombre());
        assertEquals("Juegos de acción", c.getDescripcion());
    }

    // ================= DAO =================

    @Test
    void testInsertarCategoria() {

        CategoriaDAO dao = new CategoriaDAOImpl();

        Categoria c = new Categoria(9999, "TestCat", "Categoria test");

        assertDoesNotThrow(() -> dao.insertar(c));
    }

    @Test
    void testBuscarCategoria() {

        CategoriaDAO dao = new CategoriaDAOImpl();

        Categoria resultado = dao.buscarPorId(1);

        assertNotNull(resultado);
    }

    @Test
    void testEliminarCategoria() {

        CategoriaDAO dao = new CategoriaDAOImpl();

        assertDoesNotThrow(() -> dao.eliminar(9999));
    }
}