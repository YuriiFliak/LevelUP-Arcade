/**
 *Clase que gestiona la interacción con el usuario por consola (menús, entradas y salidas)
 *Autor: Yurii Fliak
 *Version: 1.0
 */


package usuarios.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import usuarios.model.Cliente;
import usuarios.model.Producto;
import usuarios.model.Categoria;
import usuarios.model.Proveedor;

public class InterfazConsola {

    Scanner sc = new Scanner(System.in);

    // Menú principal

    public int mostrarMenuPrincipal() {

        int opcion = -1;

        while (opcion < 0 || opcion > 4) {

            try {

                System.out.println("===== LEVELUP ARCADE =====");

                System.out.println("1. Gestionar productos");
                System.out.println("2. Gestionar clientes");
                System.out.println("3. Gestionar categorías");
                System.out.println("4. Gestionar proveedores");
                System.out.println("0. Salir");

                System.out.print("Opción: ");

                opcion = sc.nextInt();

            } catch (InputMismatchException e) {

                System.out.println(
                        "Error: introduce un número válido"
                );

                sc.nextLine();
            }
        }

        return opcion;
    }

    // Submenú

    public int mostrarSubmenu() {

        int opcion = -1;

        while (opcion < 0 || opcion > 5) {

            try {

                System.out.println("---SUBMENÚ---");

                System.out.println("1. Insertar");
                System.out.println("2. Listar");
                System.out.println("3. Buscar por ID");
                System.out.println("4. Actualizar");
                System.out.println("5. Eliminar");
                System.out.println("0. Volver");

                System.out.print("Opción: ");

                opcion = sc.nextInt();

            } catch (InputMismatchException e) {

                System.out.println(
                        "Error: introduce un número válido"
                );

                sc.nextLine();
            }
        }

        return opcion;
    }

    // Pedir datos

    public int pedirId() {

        int id = -1;

        while (id < 0) {

            try {

                System.out.print("ID: ");

                id = sc.nextInt();

                if (id < 0) {

                    System.out.println(
                            "El ID no puede ser negativo"
                    );
                }

            } catch (InputMismatchException e) {

                System.out.println(
                        "Error: introduce un número válido"
                );

                sc.nextLine();
            }
        }

        return id;
    }

    public String pedirNombre() {

        sc.nextLine();

        String nombre = "";

        while (nombre.isBlank()) {

            System.out.print("Nombre: ");

            nombre = sc.nextLine();

            if (nombre.isBlank()) {

                System.out.println(
                        "El nombre no puede estar vacío"
                );
            }
        }

        return nombre;
    }

    public double pedirPrecio() {

        double precio = -1;

        while (precio < 0) {

            try {

                System.out.print("Precio: ");

                precio = sc.nextDouble();

                if (precio < 0) {

                    System.out.println(
                            "El precio no puede ser negativo"
                    );
                }

            } catch (InputMismatchException e) {

                System.out.println(
                        "Error: introduce un número válido"
                );

                sc.nextLine();
            }
        }

        return precio;
    }

    public int pedirStock() {

        int stock = -1;

        while (stock < 0) {

            try {

                System.out.print("Stock: ");

                stock = sc.nextInt();

                if (stock < 0) {

                    System.out.println(
                            "El stock no puede ser negativo"
                    );
                }

            } catch (InputMismatchException e) {

                System.out.println(
                        "Error: introduce un número válido"
                );

                sc.nextLine();
            }
        }

        return stock;
    }

    public String pedirEmail() {

        sc.nextLine();

        String email = "";

        while (!email.contains("@")) {

            System.out.print("Email: ");

            email = sc.nextLine();

            if (!email.contains("@")) {

                System.out.println(
                        "Email inválido"
                );
            }
        }

        return email;
    }

    public String pedirTelefono() {

        sc.nextLine();

        String telefono = "";

        while (telefono.isBlank()) {

            System.out.print("Teléfono: ");

            telefono = sc.nextLine();

            if (telefono.isBlank()) {

                System.out.println(
                        "El teléfono no puede estar vacío"
                );
            }
        }

        return telefono;
    }

    // Mostrar listas

    public void mostrarProductos(List<Producto> productos) {

        System.out.println("--- LISTA PRODUCTOS ---");

        for (Producto p : productos) {

            System.out.println(p);
        }
    }

    public void mostrarClientes(List<Cliente> clientes) {

        System.out.println("--- LISTA CLIENTES ---");

        for (Cliente c : clientes) {

            System.out.println(c);
        }
    }

    public void mostrarCategorias(List<Categoria> categorias) {

        System.out.println("--- LISTA CATEGORÍAS ---");

        for (Categoria c : categorias) {

            System.out.println(c);
        }
    }

    public void mostrarProveedores(List<Proveedor> proveedores) {

        System.out.println("\n--- LISTA PROVEEDORES ---");

        for (Proveedor p : proveedores) {

            System.out.println(p);
        }
    }

    // Mensajes

    public void mostrarMensaje(String mensaje) {

        System.out.println(mensaje);
    }
}