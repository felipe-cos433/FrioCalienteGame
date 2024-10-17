package practicas;

import java.util.Scanner;

public class ConvertidorTemp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("¡Bienvenido al Convertidor de Temperatura!");
        System.out.println("Elige una opción:");
        System.out.println("1. Celsius a Fahrenheit");
        System.out.println("2. Fahrenheit a Celsius");

        int opcion = scanner.nextInt();

        if (opcion == 1) {
            System.out.print("Ingresa la temperatura en Celsius: ");
            double celsius = scanner.nextDouble();
            double fahrenheit = (celsius * 9/5) + 32;
            System.out.println(celsius + " °C son " + fahrenheit + " °F");
        } else if (opcion == 2) {
            System.out.print("Ingresa la temperatura en Fahrenheit: ");
            double fahrenheit = scanner.nextDouble();
            double celsius = (fahrenheit - 32) * 5/9;
            System.out.println(fahrenheit + " °F son " + celsius + " °C");
        } else {
            System.out.println("Opción no válida.");
        }

        scanner.close();
    }
}
