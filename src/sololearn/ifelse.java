package sololearn;

import java.util.Scanner;

public class ifelse {
    public static void main(String[] args) {

        Scanner scanner= new Scanner (System.in);
        System.out.println("Ingrese la temperatura en celsius");
        int temperatura = scanner.nextInt();

        if (temperatura >=100){
            System.out.println("bolling");
        }else{
            System.out.println("Not bolling");
        }

    }

}
