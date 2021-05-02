package com.codewithmosh;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scannerP = new Scanner(System.in);
        Scanner scannerR = new Scanner(System.in);
        Scanner scannerN = new Scanner(System.in);

        System.out.print("Principal: ");
        int p = scannerP.nextInt();
        System.out.print("Annual Interest Rate: ");
        double r = scannerR.nextDouble() / (12 * 100);
        System.out.print("Period (Years): ");
        int n = scannerN.nextInt() * 12;
        double result = p * r * Math.pow((1+r),n) / Math.pow((1+r), n) -1;
        String mortgage = NumberFormat.getCurrencyInstance().format(result);

        System.out.print("Mortgage: " + mortgage);
    }
}
