package practicas;

import java.util.ArrayList;
import java.util.Scanner;

// Clase Usuario
class Usuario {
    private String username;
    private String password;

    public Usuario(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public boolean verificarContraseña(String password) {
        return this.password.equals(password);
    }
}

// Clase Producto
class Producto {
    private String nombre;
    private int cantidad;
    private double precio;

    public Producto(String nombre, int cantidad, double precio) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto: " + nombre + " | Cantidad: " + cantidad + " | Precio: " + precio;
    }
}

// Clase Inventario
class Inventario {
    private ArrayList<Producto> productos;

    public Inventario() {
        productos = new ArrayList<>();
    }

    public void agregarProducto(String nombre, int cantidad, double precio) {
        productos.add(new Producto(nombre, cantidad, precio));
    }

    public void mostrarProductos() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos en el inventario.");
        } else {
            for (Producto p : productos) {
                System.out.println(p);
            }
        }
    }

    public Producto buscarProducto(String nombre) {
        for (Producto p : productos) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                return p;
            }
        }
        return null;
    }

    public void modificarProducto(String nombre, int nuevaCantidad, double nuevoPrecio) {
        Producto p = buscarProducto(nombre);
        if (p != null) {
            p.setCantidad(nuevaCantidad);
            p.setPrecio(nuevoPrecio);
            System.out.println("Producto modificado exitosamente.");
        } else {
            System.out.println("Producto no encontrado.");
        }
    }
}

// Clase principal SistemaInventario
public class SistemaInventario {
    private static Usuario usuario = new Usuario("admin", "1234"); // Usuario predeterminado
    private static Inventario inventario = new Inventario();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Proceso de Login
        if (login(scanner)) {
            int opcion;
            do {
                mostrarMenu();
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer
                switch (opcion) {
                    case 1:
                        agregarProducto(scanner);
                        break;
                    case 2:
                        modificarProducto(scanner);
                        break;
                    case 3:
                        inventario.mostrarProductos();
                        break;
                    case 4:
                        System.out.println("Saliendo del sistema...");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            } while (opcion != 4);
        } else {
            System.out.println("Login incorrecto.");
        }
    }

    private static boolean login(Scanner scanner) {
        System.out.println("=== Sistema de Login ===");
        System.out.print("Ingrese su nombre de usuario: ");
        String username = scanner.nextLine();
        System.out.print("Ingrese su contraseña: ");
        String password = scanner.nextLine();
        return usuario.getUsername().equals(username) && usuario.verificarContraseña(password);
    }

    private static void mostrarMenu() {
        System.out.println("\n=== Menú del Inventario ===");
        System.out.println("1. Agregar producto");
        System.out.println("2. Modificar producto");
        System.out.println("3. Mostrar productos");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void agregarProducto(Scanner scanner) {
        System.out.print("Ingrese el nombre del producto: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la cantidad del producto: ");
        int cantidad = scanner.nextInt();
        System.out.print("Ingrese el precio del producto: ");
        double precio = scanner.nextDouble();
        inventario.agregarProducto(nombre, cantidad, precio);
        System.out.println("Producto agregado exitosamente.");
    }

    private static void modificarProducto(Scanner scanner) {
        System.out.print("Ingrese el nombre del producto a modificar: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la nueva cantidad: ");
        int cantidad = scanner.nextInt();
        System.out.print("Ingrese el nuevo precio: ");
        double precio = scanner.nextDouble();
        inventario.modificarProducto(nombre, cantidad, precio);
    }
}






