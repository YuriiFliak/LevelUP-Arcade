package usuarios.test;

import org.junit.jupiter.api.Test;
import usuarios.model.Producto;
import usuarios.dao.ProductoDAO;
import usuarios.dao.ProductoDAOImpl;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests JUnit para la entidad Producto
 * Autor: Yurii Fliak
 */

public class ProductoTest {

    // ================= MODELO =================

    @Test
    void testCrearProductoCorrecto() {

        Producto p = new Producto(1, "PS5", "Consola gaming", 500, 10, 1, 1);

        assertEquals(1, p.getId());
        assertEquals("PS5", p.getNombre());
        assertEquals("Consola gaming", p.getDescripcion());
        assertEquals(500, p.getPrecio());
        assertEquals(10, p.getStock());
        assertEquals(1, p.getIdCategoria());
        assertEquals(1, p.getIdProveedor());
    }

    // ================= VALIDACIONES =================

    @Test
    void testPrecioNegativo() {

        Producto p = new Producto();

        assertThrows(IllegalArgumentException.class, () -> {
            p.setPrecio(-5);
        });
    }

    @Test
    void testStockNegativo() {

        Producto p = new Producto();

        assertThrows(IllegalArgumentException.class, () -> {
            p.setStock(-3);
        });
    }

    // ================= DAO =================

    @Test
    void testInsertarProducto() {

        ProductoDAO dao = new ProductoDAOImpl();

        Producto p = new Producto(
                9999,
                "TEST JUNIT",
                "Producto de prueba",
                10,
                1,
                1,
                1
        );

        assertDoesNotThrow(() -> dao.insertar(p));
    }

    @Test
    void testBuscarProducto() {

        ProductoDAO dao = new ProductoDAOImpl();

        Producto resultado = dao.buscarPorId(1);

        assertNotNull(resultado);
    }

    @Test
    void testEliminarProducto() {

        ProductoDAO dao = new ProductoDAOImpl();

        assertDoesNotThrow(() -> dao.eliminar(9999));
    }
}