package com.pruebas.tdd.roman;

import java.util.Scanner;

public class NumerosRomanos {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N;
        do {
            System.out.print("Introduce un número entre 1 y 3999: ");
            N = sc.nextInt();
        } while (N < 1 || N > 3999);
        RomanNumber romanNumber = new RomanNumber();
        System.out.println(N + " en numeros romanos -> " + romanNumber.convertirANumerosRomanos(N));
    }

}
