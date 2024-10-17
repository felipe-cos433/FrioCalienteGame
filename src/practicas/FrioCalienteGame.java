package practicas;

    import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

    public class FrioCalienteGame {

        static HashMap<String, String> usuarios = new HashMap<>(); // Para almacenar usuario y contraseña

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            cargarUsuarios();  // Cargar los usuarios existentes
            String username;

            // Login del usuario o registro
            username = login(scanner);

            if (username == null) {
                System.out.println("Login fallido.");
                return;
            }

            // Iniciar el juego
            int score = jugar(scanner);

            // Guardar puntuación en el archivo
            guardarPuntuacion(username, score);
        }

        public static String login(Scanner scanner) {
            System.out.println("¿Tienes una cuenta? (s/n): ");
            String respuesta = scanner.nextLine();

            if (respuesta.equalsIgnoreCase("s")) {
                // Login existente
                return autenticarUsuario(scanner);
            } else {
                // Crear nueva cuenta
                return registrarUsuario(scanner);
            }
        }

        public static String autenticarUsuario(Scanner scanner) {
            System.out.print("Ingresa tu nombre de usuario: ");
            String username = scanner.nextLine();
            System.out.print("Ingresa tu contraseña: ");
            String password = scanner.nextLine();

            if (usuarios.containsKey(username) && usuarios.get(username).equals(password)) {
                System.out.println("Login exitoso.");
                return username;
            } else {
                System.out.println("Usuario o contraseña incorrectos.");
                return null;
            }
        }

        public static String registrarUsuario(Scanner scanner) {
            System.out.print("Ingresa un nombre de usuario nuevo: ");
            String username = scanner.nextLine();

            if (usuarios.containsKey(username)) {
                System.out.println("El usuario ya existe.");
                return null;
            }

            System.out.print("Ingresa una contraseña: ");
            String password = scanner.nextLine();

            usuarios.put(username, password);  // Guardar en memoria
            guardarUsuario(username, password);  // Guardar en archivo
            System.out.println("Registro exitoso.");
            return username;
        }

        public static void cargarUsuarios() {
            try {
                File file = new File("usuarios.txt");
                if (file.exists()) {
                    Scanner fileScanner = new Scanner(file);
                    while (fileScanner.hasNextLine()) {
                        String[] datos = fileScanner.nextLine().split(",");
                        usuarios.put(datos[0], datos[1]);  // [0]: username, [1]: password
                    }
                    fileScanner.close();
                }
            } catch (IOException e) {
                System.out.println("Error al cargar usuarios: " + e.getMessage());
            }
        }

        public static void guardarUsuario(String username, String password) {
            try {
                FileWriter writer = new FileWriter("usuarios.txt", true);  // true para añadir al archivo
                writer.write(username + "," + password + "\n");
                writer.close();
            } catch (IOException e) {
                System.out.println("Ocurrió un error al guardar el usuario.");
                e.printStackTrace();
            }
        }

        public static int jugar(Scanner scanner) {
            Random random = new Random();
            int numeroSecreto = random.nextInt(100) + 1;  // Número secreto entre 1 y 100
            int intentos = 0;
            int adivinanza = -1;

            System.out.println("¡Adivina el número entre 1 y 100!");

            while (adivinanza != numeroSecreto) {
                System.out.print("Ingresa tu adivinanza: ");
                adivinanza = scanner.nextInt();
                intentos++;

                int diferencia = Math.abs(numeroSecreto - adivinanza);

                if (adivinanza == numeroSecreto) {
                    System.out.println("¡Felicidades! Adivinaste el número en " + intentos + " intentos.");
                } else if (diferencia <= 5) {
                    System.out.println("¡Caliente!");
                } else if (diferencia <= 15) {
                    System.out.println("¡Tibio!");
                } else {
                    System.out.println("¡Frío!");
                }
            }

            return intentos;
        }

        public static void guardarPuntuacion(String username, int score) {
            try {
                FileWriter writer = new FileWriter("scores.txt", true); // true para añadir sin sobrescribir
                writer.write("Usuario: " + username + " - Puntuación: " + score + " intentos\n");
                writer.close();
                System.out.println("Puntuación guardada correctamente.");
            } catch (IOException e) {
                System.out.println("Ocurrió un error al guardar la puntuación.");
                e.printStackTrace();
            }
        }
    }


