package usuarios.test;

import org.junit.jupiter.api.Test;
import usuarios.model.Proveedor;
import usuarios.dao.ProveedorDAO;
import usuarios.dao.ProveedorDAOImpl;

import static org.junit.jupiter.api.Assertions.*;

public class ProveedorTest {

    // ================= MODELO =================

    @Test
    void testCrearProveedor() {

        Proveedor p = new Proveedor();

        p.setId(1);
        p.setNombre("Sony");
        p.setEmail("contact@sony.com");
        p.setDireccion("Madrid");

        assertEquals(1, p.getId());
        assertEquals("Sony", p.getNombre());
        assertEquals("contact@sony.com", p.getEmail());
        assertEquals("Madrid", p.getDireccion());
    }

    // ================= DAO =================

    @Test
    void testInsertarProveedor() {

        ProveedorDAO dao = new ProveedorDAOImpl();

        Proveedor p = new Proveedor();
        p.setId(9999);
        p.setNombre("TestProv");
        p.setEmail("test@prov.com");
        p.setDireccion("Madrid");

        assertDoesNotThrow(() -> dao.insertar(p));
    }

    @Test
    void testBuscarProveedor() {

        ProveedorDAO dao = new ProveedorDAOImpl();

        Proveedor p = dao.buscarPorId(9999);

        // puede ser null si no existe en BD
        assertDoesNotThrow(() -> dao.buscarPorId(9999));
    }

    @Test
    void testEliminarProveedor() {

        ProveedorDAO dao = new ProveedorDAOImpl();

        assertDoesNotThrow(() -> dao.eliminar(9999));
    }
}