package myproject;

import java.util.Scanner;

public class Version2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingresa el primer número: ");
        int a = scanner.nextInt();

        System.out.print("Ingresa el segundo número: ");
        int b = scanner.nextInt();

        int sum = a + b;
        System.out.println("La suma de " + a + " y " + b + " es: " + sum);

        scanner.close();
    }
}

