package usuarios.view;

import usuarios.model.*;
import java.util.*;

/**
 * Clase que gestiona la interacción con el usuario por consola (menús, entradas y salidas)
 * Autor: Yurii Fliak
 * Version: 2.1
 */

public class InterfazConsola {

    Scanner sc = new Scanner(System.in);

    // ================= MENÚ PRINCIPAL =================

    public int mostrarMenuPrincipal() {

        int opcion = -1;

        while (opcion < 0 || opcion > 5) {

            try {

                System.out.println("===== LEVELUP ARCADE =====");
                System.out.println("1. Gestionar productos");
                System.out.println("2. Gestionar clientes");
                System.out.println("3. Gestionar categorías");
                System.out.println("4. Gestionar proveedores");
                System.out.println("5. Inteligencia Artificial");
                System.out.println("0. Salir");

                System.out.print("Opción: ");
                opcion = sc.nextInt();

            } catch (InputMismatchException e) {

                System.out.println("Error: introduce un número válido");
                sc.nextLine();
            }
        }

        return opcion;
    }

    // ================= SUBMENÚ =================

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

                System.out.println("Error: introduce un número válido");
                sc.nextLine();
            }
        }

        return opcion;
    }

    // ================= VALIDACIÓN BASE =================

    private void clearBuffer() {
        sc.nextLine();
    }

    // ================= PEDIR DATOS (SEGUROS) =================

    public int pedirId() {

        int id;

        while (true) {

            try {
                System.out.print("ID: ");
                id = sc.nextInt();

                if (id < 0) {
                    System.out.println("El ID no puede ser negativo");
                    continue;
                }

                clearBuffer();
                return id;

            } catch (InputMismatchException e) {
                System.out.println("Error: introduce un número válido");
                clearBuffer();
            }
        }
    }

    public String pedirNombre() {

        String nombre;

        while (true) {

            System.out.print("Nombre: ");
            nombre = sc.nextLine();

            if (!nombre.isBlank()) return nombre;

            System.out.println("El nombre no puede estar vacío");
        }
    }

    public String pedirApellido() {

        String apellido;

        while (true) {

            System.out.print("Apellido: ");
            apellido = sc.nextLine();

            if (!apellido.isBlank()) return apellido;

            System.out.println("El apellido no puede estar vacío");
        }
    }

    public String pedirDescripcion() {

        String desc;

        while (true) {

            System.out.print("Descripción: ");
            desc = sc.nextLine();

            if (!desc.isBlank()) return desc;

            System.out.println("La descripción no puede estar vacía");
        }
    }

    public double pedirPrecio() {

        double precio;

        while (true) {

            try {
                System.out.print("Precio: ");
                precio = sc.nextDouble();

                if (precio < 0) {
                    System.out.println("El precio no puede ser negativo");
                    continue;
                }

                clearBuffer();
                return precio;

            } catch (InputMismatchException e) {
                System.out.println("Error: introduce un número válido");
                clearBuffer();
            }
        }
    }

    public int pedirStock() {

        int stock;

        while (true) {

            try {
                System.out.print("Stock: ");
                stock = sc.nextInt();

                if (stock < 0) {
                    System.out.println("El stock no puede ser negativo");
                    continue;
                }

                clearBuffer();
                return stock;

            } catch (InputMismatchException e) {
                System.out.println("Error: introduce un número válido");
                clearBuffer();
            }
        }
    }

    public String pedirEmail() {

        String email;

        while (true) {

            System.out.print("Email: ");
            email = sc.nextLine();

            if (email.contains("@") && !email.isBlank()) return email;

            System.out.println("Email inválido");
        }
    }

    public String pedirTelefono() {

        String tlf;

        while (true) {

            System.out.print("Teléfono: ");
            tlf = sc.nextLine();

            if (!tlf.isBlank()) return tlf;

            System.out.println("El teléfono no puede estar vacío");
        }
    }

    public String pedirDireccion() {

        String dir;

        while (true) {

            System.out.print("Dirección: ");
            dir = sc.nextLine();

            if (!dir.isBlank()) return dir;

            System.out.println("La dirección no puede estar vacía");
        }
    }

    public int pedirIdCategoria() {

        int id;

        while (true) {

            try {
                System.out.print("ID Categoría: ");
                id = sc.nextInt();

                if (id < 0) {
                    System.out.println("El ID no puede ser negativo");
                    continue;
                }

                clearBuffer();
                return id;

            } catch (InputMismatchException e) {
                System.out.println("Error: introduce un número válido");
                clearBuffer();
            }
        }
    }

    public int pedirIdProveedor() {

        int id;

        while (true) {

            try {
                System.out.print("ID Proveedor: ");
                id = sc.nextInt();

                if (id < 0) {
                    System.out.println("El ID no puede ser negativo");
                    continue;
                }

                clearBuffer();
                return id;

            } catch (InputMismatchException e) {
                System.out.println("Error: introduce un número válido");
                clearBuffer();
            }
        }
    }

    public String pedirEmailProveedor() {

        String email;

        while (true) {

            System.out.print("Email proveedor: ");
            email = sc.nextLine();

            if (email.contains("@") && !email.isBlank()) return email;

            System.out.println("Email inválido");
        }
    }

    // ================= LISTADOS =================

    public void mostrarProductos(List<Producto> lista) {
        System.out.println("--- LISTA PRODUCTOS ---");
        for (Producto p : lista) System.out.println(p);
    }

    public void mostrarClientes(List<Cliente> lista) {
        System.out.println("--- LISTA CLIENTES ---");
        for (Cliente c : lista) System.out.println(c);
    }

    public void mostrarCategorias(List<Categoria> lista) {
        System.out.println("--- LISTA CATEGORÍAS ---");
        for (Categoria c : lista) System.out.println(c);
    }

    public void mostrarProveedores(List<Proveedor> lista) {
        System.out.println("--- LISTA PROVEEDORES ---");
        for (Proveedor p : lista) System.out.println(p);
    }
    
	// ================== USUARIOS ========================
	public String pedirUsername() {
	    sc.nextLine();
	    System.out.print("Usuario: ");
	    return sc.nextLine();
	}
	
	public String pedirPassword() {
	    System.out.print("Password: ");
	    return sc.nextLine();
	}
}


