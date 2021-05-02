package com.codewithmosh;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        Scanner scanner = new Scanner(System.in);

        int principal;
        float annualInterest;
        float monthlyInterest;
        byte years;
        int numberOfPayments;

        while (true) {
            System.out.print("Principal ($1K - $1M): ");
            principal = scanner.nextInt();
            if (principal < 1_000 || principal > 1_000_000) {
                System.out.println("Enter a number between 1,000 and 1,000,000.");
                continue;
            }
            if (principal >= 1_000 && principal <= 1_000_000) {
                break;
            }
            System.out.println(principal);
        }
        while (true) {
            System.out.print("Annual Interest Rate: ");
            annualInterest = scanner.nextFloat();
            if (annualInterest <= 0 || annualInterest > 30) {
                System.out.println("Enter a value greater than 0 and less than or equal to 30");
                continue;
            }
            if (annualInterest > 0 && annualInterest <= 30) {
                monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
                break;
            }
        }
        while (true) {
            System.out.print("Period (Years): ");
            years = scanner.nextByte();
            if (years <= 0 || years > 30) {
                System.out.println("Enter a value between 1 and 30");
                continue;
            }
            if (years > 0 && years <= 30) {
                numberOfPayments = years * MONTHS_IN_YEAR;
                break;
            }
        }

        double mortgage = principal * monthlyInterest * Math.pow((1 + monthlyInterest), numberOfPayments)
                / (Math.pow((1 + monthlyInterest), numberOfPayments) -1);
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);

        System.out.print("Mortgage: " + mortgageFormatted);

    }
}
