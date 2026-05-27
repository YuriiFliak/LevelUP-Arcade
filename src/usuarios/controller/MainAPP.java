package usuarios.controller;

import usuarios.dao.*;
import usuarios.model.*;
import usuarios.view.InterfazConsola;
import usuarios.services.LlmService;


/**
 * La clase main es el controlador principal de la aplicacion.
 * Se encarga en crear el bucle principal para las operaciones del menú
 * Autor: Yurii Fliak
 * Version: 2.0
 */

public class MainAPP {

    public static void main(String[] args) {

        ProductoDAO productoDAO = new ProductoDAOImpl();
        ClienteDAO clienteDAO = new ClienteDAOImpl();
        CategoriaDAO categoriaDAO = new CategoriaDAOImpl();
        ProveedorDAO proveedorDAO = new ProveedorDAOImpl();
        UsuarioDAO userDao = new UsuarioDAOImpl();
       

        InterfazConsola vista = new InterfazConsola();
        Usuario usuario = login(userDao, vista);

        if (usuario == null) {
            return;
        }

        int op;

        do {

            op = vista.mostrarMenuPrincipal();

            switch (op) {

                case 1 -> gestionarProductos(productoDAO, vista);
                case 2 -> gestionarClientes(clienteDAO, vista);
                case 3 -> gestionarCategorias(categoriaDAO, vista);
                case 4 -> gestionarProveedores(proveedorDAO, vista);
                case 5 -> gestionarIA(vista);

                case 0 -> System.out.println("Saliendo del sistema...");

                default -> System.out.println("Opción incorrecta");
            }

        } while (op != 0);
    }

    // ========================= PRODUCTOS =========================

    public static void gestionarProductos(ProductoDAO dao, InterfazConsola v) {

        int op;

        do {

            op = v.mostrarSubmenu();

            switch (op) {

                case 1 -> dao.insertar(new Producto(
                        v.pedirNombre(),
                        v.pedirDescripcion(),
                        v.pedirPrecio(),
                        v.pedirStock(),
                        v.pedirIdCategoria(),
                        v.pedirIdProveedor()
                ));

                case 2 -> v.mostrarProductos(dao.listar());

                case 3 -> System.out.println(dao.buscarPorId(v.pedirId()));

                case 4 -> dao.actualizar(new Producto(
                        v.pedirId(),
                        v.pedirNombre(),
                        v.pedirDescripcion(),
                        v.pedirPrecio(),
                        v.pedirStock(),
                        v.pedirIdCategoria(),
                        v.pedirIdProveedor()
                ));

                case 5 -> dao.eliminar(v.pedirId());
            }

        } while (op != 0);
    }

    // ========================= CLIENTES =========================

    public static void gestionarClientes(ClienteDAO dao, InterfazConsola v) {

        int op;

        do {

            op = v.mostrarSubmenu();

            switch (op) {

                case 1 -> dao.insertar(new Cliente(
                	    v.pedirNombre(),
                	    v.pedirApellido(),
                	    v.pedirEmail(),
                	    v.pedirTelefono(),
                	    v.pedirDireccion()
                ));

                case 2 -> v.mostrarClientes(dao.listar());

                case 3 -> System.out.println(dao.buscarPorId(v.pedirId()));

                case 4 -> dao.actualizar(new Cliente(
                	    v.pedirNombre(),
                	    v.pedirApellido(),
                	    v.pedirEmail(),
                	    v.pedirTelefono(),
                	    v.pedirDireccion()
                ));

                case 5 -> dao.eliminar(v.pedirId());
            }

        } while (op != 0);
    }

    // ========================= CATEGORÍAS =========================

    public static void gestionarCategorias(CategoriaDAO dao, InterfazConsola v) {

        int op;

        do {

            op = v.mostrarSubmenu();

            switch (op) {

                case 1 -> dao.insertar(new Categoria(
                        v.pedirNombre(),
                        v.pedirDescripcion()
                ));

                case 2 -> v.mostrarCategorias(dao.listar());

                case 3 -> System.out.println(dao.buscarPorId(v.pedirId()));

                case 4 -> dao.actualizar(new Categoria(
                        v.pedirId(),
                        v.pedirNombre(),
                        v.pedirDescripcion()
                ));

                case 5 -> dao.eliminar(v.pedirId());
            }

        } while (op != 0);
    }

    // ========================= PROVEEDORES =========================

    public static void gestionarProveedores(ProveedorDAO dao, InterfazConsola v) {

        int op;

        do {

            op = v.mostrarSubmenu();

            switch (op) {

                case 1 -> dao.insertar(new Proveedor(
                	    v.pedirNombre(),
                	    v.pedirTelefono(),
                	    v.pedirEmailProveedor(),
                	    v.pedirDireccion()
                ));

                case 2 -> v.mostrarProveedores(dao.listar());

                case 3 -> System.out.println(dao.buscarPorId(v.pedirId()));

                case 4 -> dao.actualizar(new Proveedor(
                	    v.pedirNombre(),
                	    v.pedirTelefono(),
                	    v.pedirEmailProveedor(),
                	    v.pedirDireccion()
                ));

                case 5 -> dao.eliminar(v.pedirId());
            }

        } while (op != 0);
    }
    
    
 // ========================= INTELIGENCIA ARTIFICIAL =========================

    public static void gestionarIA(InterfazConsola v) {

        int op;

        do {

            System.out.println("===== INTELIGENCIA ARTIFICIAL =====");
            System.out.println("1. Generar descripción de producto");
            System.out.println("2. Sugerir categoría de producto");
            System.out.println("0. Volver");

            op = v.pedirId();

            switch (op) {

                case 1 -> {

                    String nombre = v.pedirNombre();

                    String respuesta = LlmService.preguntarIA(
                            "Genera una descripción comercial breve, atractiva y en ESPAÑOL del producto: "
                                    + nombre
                    );

                    System.out.println("\n--- DESCRIPCIÓN IA ---");
                    System.out.println(respuesta);
                }

                case 2 -> {

                    String nombre = v.pedirNombre();

                    String respuesta = LlmService.preguntarIA(
                            "Responde SOLO con una categoría en ESPAÑOL para este producto, sin explicación: "
                                    + nombre
                    );

                    System.out.println("\n--- CATEGORÍA IA ---");
                    System.out.println(respuesta);
                }

                case 0 -> {
                    System.out.println("Volviendo al menú principal...");
                }

                default -> {
                    System.out.println("Opción no válida");
                }
            }

        } while (op != 0);
    }
    
    // ============================= LOGIN ==============================
    public static Usuario login(UsuarioDAO dao, InterfazConsola v) {

        System.out.println("===== LOGIN =====");

        String user = v.pedirUsername();
        String pass = v.pedirPassword();

        Usuario u = dao.login(user, pass);

        if (u == null) {
            System.out.println("Login incorrecto");
            return null;
        }

        System.out.println("Bienvenido " + u.getUsername());
        return u;
    }
}
