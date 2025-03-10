package com.h2;

import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class BestLoanRates {
    public static final Map<Integer, Float> bestRates = Map.of(1, 5.50f, 2, 3.45f, 3, 2.67f);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your name");
        String name = scanner.nextLine();

        System.out.printf(Locale.US, "Hello %s%n", name);

        System.out.println("Enter the loan term (in years)");
        int loanTermInYears = scanner.nextInt();

        float bestRate = getRates(loanTermInYears);

        if (Float.compare(bestRate, 0.0f) == 0) {
            System.out.printf(Locale.US, "No available rates for term: %d years", loanTermInYears);
        } else {
            System.out.printf(Locale.US, "Best Available Rate: %.2f%%", bestRate);
        }

        scanner.close();
    }

    public static float getRates(int loanTermInYears) {
        if (bestRates.containsKey(loanTermInYears)) {
            return bestRates.get(loanTermInYears);
        } else {
            return 0.0f;
        }
    }
}