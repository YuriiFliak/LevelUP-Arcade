/**
 * La clase main es el controlador principal de la aplicacion.
 * Se encarga en crear el bucle principal para las operaciones del menú
 * Autor: Yurii Fliak
 * Version: 1
 */

package usuarios.controller;

import usuarios.dao.CategoriaDAO;
import usuarios.dao.CategoriaDAOImpl;
import usuarios.dao.ClienteDAO;
import usuarios.dao.ClienteDAOImpl;
import usuarios.dao.ProductoDAO;
import usuarios.dao.ProductoDAOImpl;
import usuarios.dao.ProveedorDAO;
import usuarios.dao.ProveedorDAOImpl;

import usuarios.model.Categoria;
import usuarios.model.Cliente;
import usuarios.model.Producto;
import usuarios.model.Proveedor;

import usuarios.view.InterfazConsola;

public class MainAPP {

    public static void main(String[] args) {

        // DAO

        ProductoDAO productoDAO = new ProductoDAOImpl();

        ClienteDAO clienteDAO = new ClienteDAOImpl();

        CategoriaDAO categoriaDAO = new CategoriaDAOImpl();

        ProveedorDAO proveedorDAO = new ProveedorDAOImpl();

        // Vista

        InterfazConsola vista = new InterfazConsola();

        int opcionPrincipal;

        do {

            opcionPrincipal = vista.mostrarMenuPrincipal();

            switch (opcionPrincipal) {

                // Productos

                case 1:

                    gestionarProductos(productoDAO, vista);

                    break;

                // Clientes

                case 2:

                    gestionarClientes(clienteDAO, vista);

                    break;

                // Categorias

                case 3:

                    gestionarCategorias(categoriaDAO, vista);

                    break;

                // Proveedores

                case 4:

                    gestionarProveedores(proveedorDAO, vista);

                    break;

                case 0:

                    System.out.println("Saliendo del sistema...");

                    break;

                default:

                    System.out.println("Opción incorrecta");
            }

        } while (opcionPrincipal != 0);
    }

    /**
     * Gestiona todas las operaciones CRUD de productos.
     *
     * @param dao DAO de productos
     * @param vista vista de consola
     */

    public static void gestionarProductos(
            ProductoDAO dao,
            InterfazConsola vista) {

        int opcion;

        do {

            opcion = vista.mostrarSubmenu();

            switch (opcion) {

                case 1:

                    dao.insertar(crearProducto(vista));

                    break;

                case 2:

                    vista.mostrarProductos(dao.listar());

                    break;

                case 3:

                    Producto encontrado =
                            dao.buscarPorId(vista.pedirId());

                    System.out.println(encontrado);

                    break;

                case 4:

                    dao.actualizar(crearProducto(vista));

                    break;

                case 5:

                    dao.eliminar(vista.pedirId());

                    break;
            }

        } while (opcion != 0);
    }

    /**
     * Gestiona todas las operaciones CRUD de clientes.
     *
     * @param dao DAO de clientes
     * @param vista vista de consola
     */

    public static void gestionarClientes(
            ClienteDAO dao,
            InterfazConsola vista) {

        int opcion;

        do {

            opcion = vista.mostrarSubmenu();

            switch (opcion) {

                case 1:

                    dao.insertar(crearCliente(vista));

                    break;

                case 2:

                    vista.mostrarClientes(dao.listar());

                    break;

                case 3:

                    Cliente encontrado =
                            dao.buscarPorId(vista.pedirId());

                    System.out.println(encontrado);

                    break;

                case 4:

                    dao.actualizar(crearCliente(vista));

                    break;

                case 5:

                    dao.eliminar(vista.pedirId());

                    break;
            }

        } while (opcion != 0);
    }

    /**
     * Gestiona todas las operaciones CRUD de categorías.
     *
     * @param dao DAO de categorías
     * @param vista vista de consola
     */

    public static void gestionarCategorias(
            CategoriaDAO dao,
            InterfazConsola vista) {

        int opcion;

        do {

            opcion = vista.mostrarSubmenu();

            switch (opcion) {

                case 1:

                    dao.insertar(crearCategoria(vista));

                    break;

                case 2:

                    vista.mostrarCategorias(dao.listar());

                    break;

                case 3:

                    Categoria encontrada =
                            dao.buscarPorId(vista.pedirId());

                    System.out.println(encontrada);

                    break;

                case 4:

                    dao.actualizar(crearCategoria(vista));

                    break;

                case 5:

                    dao.eliminar(vista.pedirId());

                    break;
            }

        } while (opcion != 0);
    }

    /**
     * Gestiona todas las operaciones CRUD de proveedores.
     *
     * @param dao DAO de proveedores
     * @param vista vista de consola
     */

    public static void gestionarProveedores(
            ProveedorDAO dao,
            InterfazConsola vista) {

        int opcion;

        do {

            opcion = vista.mostrarSubmenu();

            switch (opcion) {

                case 1:

                    dao.insertar(crearProveedor(vista));

                    break;

                case 2:

                    vista.mostrarProveedores(dao.listar());

                    break;

                case 3:

                    Proveedor encontrado =
                            dao.buscarPorId(vista.pedirId());

                    System.out.println(encontrado);

                    break;

                case 4:

                    dao.actualizar(crearProveedor(vista));

                    break;

                case 5:

                    dao.eliminar(vista.pedirId());

                    break;
            }

        } while (opcion != 0);
    }

    /**
     * Crea un objeto Producto solicitando los datos por consola.
     *
     * @param vista vista de consola
     * @return objeto Producto
     */

    public static Producto crearProducto(
            InterfazConsola vista) {

        return new Producto(

                vista.pedirId(),
                vista.pedirNombre(),
                vista.pedirPrecio(),
                vista.pedirStock()
        );
    }

    /**
     * Crea un objeto Cliente solicitando los datos por consola.
     *
     * @param vista vista de consola
     * @return objeto Cliente
     */

    public static Cliente crearCliente(
            InterfazConsola vista) {

        return new Cliente(

                vista.pedirId(),
                vista.pedirNombre(),
                vista.pedirEmail()
        );
    }

    /**
     * Crea un objeto Categoria solicitando los datos por consola.
     *
     * @param vista vista de consola
     * @return objeto Categoria
     */

    public static Categoria crearCategoria(
            InterfazConsola vista) {

        return new Categoria(

                vista.pedirId(),
                vista.pedirNombre()
        );
    }

    /**
     * Crea un objeto Proveedor solicitando los datos por consola.
     *
     * @param vista vista de consola
     * @return objeto Proveedor
     */

    public static Proveedor crearProveedor(
            InterfazConsola vista) {

        return new Proveedor(

                vista.pedirId(),
                vista.pedirNombre(),
                vista.pedirTelefono()
        );
    }
}