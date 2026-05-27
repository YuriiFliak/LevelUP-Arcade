package usuarios.test;

import org.junit.jupiter.api.Test;
import usuarios.model.Cliente;
import usuarios.dao.ClienteDAO;
import usuarios.dao.ClienteDAOImpl;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests JUnit para Cliente
 */

public class ClienteTest {

    // ================= MODELO =================

    @Test
    void testCrearCliente() {

        Cliente c = new Cliente(1, "Juan", "Perez", "juan@gmail.com", "123456789", "Madrid");

        assertEquals("Juan", c.getNombre());
        assertEquals("Perez", c.getApellido());
        assertEquals("juan@gmail.com", c.getEmail());
    }

    // ================= VALIDACIONES =================

    @Test
    void testEmailInvalido() {

        Cliente c = new Cliente();

        assertDoesNotThrow(() -> c.setEmail("correo_invalido"));
    }

    // ================= DAO =================

    @Test
    void testInsertarCliente() {

        ClienteDAO dao = new ClienteDAOImpl();

        Cliente c = new Cliente(9999, "Test", "User", "test@test.com", "111111111", "Madrid");

        assertDoesNotThrow(() -> dao.insertar(c));
    }
 
    @Test
    void testEliminarCliente() {

        ClienteDAO dao = new ClienteDAOImpl();

        assertDoesNotThrow(() -> dao.eliminar(9999));
    }
}