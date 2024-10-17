package sololearn;

import java.util.Scanner;

public class propinas {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double factura = sc.nextDouble();

        double propina = factura * 0.15;

        System.out.println(propina);

    }
}
