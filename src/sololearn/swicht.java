package sololearn;

import java.util.Scanner;

class Demo {
    public static void main(String[ ] args) {
        Scanner scanner = new Scanner(System.in);

       String color =  scanner.nextLine();


        switch(color) {
            case "red":
                System.out.println(" 1 ");
                break;
            case "green":
                System.out.println(" 2 ");
                break;
            case "black":
                System.out.println(" 3 ");
                break;
        }
    }
}