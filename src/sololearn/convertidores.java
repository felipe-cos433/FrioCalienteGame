package sololearn;

import java.util.Scanner;

public class convertidores {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingresa tu edad: ");
        int age = scanner.nextInt();

        if (age >= 0 && age <= 11) {
            System.out.println("Child");
        } else if (age >= 12 && age <= 17) {
            System.out.println("Teen");
        } else if (age >= 18 && age <= 64) {
            System.out.println("Adult");
        } else {
            System.out.println("Edad no válida o fuera de rango.");
        }

        scanner.close();









    }
}
