package com.h2;

import java.text.DecimalFormat;
import java.util.Locale;

public class MortgageCalculator {
    private final long loanAmount;
    private final int termInYears;
    private final float annualRate;
    private double monthlyPayment;

    public MortgageCalculator(long loanAmount, int termInYears, float annualRate) {
        this.loanAmount = loanAmount;
        this.termInYears = termInYears;
        this.annualRate = annualRate;
    }

    public static void main(String[] args) {
        long loanAmount = Utilities.getLongValue(args[0]);
        int termInYears = Utilities.getIntValue(args[1]);
        float annualRate = Utilities.getFloatValue(args[2]);

        MortgageCalculator calculator = new MortgageCalculator(loanAmount, termInYears, annualRate);
        calculator.calculateMonthlyPayment();

        System.out.println(calculator);
    }

    private int getNumberOfPayments() {
        return termInYears * 12;
    }

    private float getMonthlyInterestRate() {
        float interestRate = annualRate / 100;
        return interestRate / 12;
    }

    public void calculateMonthlyPayment() {
        long P = loanAmount;
        float r = getMonthlyInterestRate();
        int n = getNumberOfPayments();
        double M = P * (((r * Math.pow((1 + r), n))) / ((Math.pow((1 + r), n)) - 1));
        this.monthlyPayment = M;
    }

    @Override
    public String toString() {
        DecimalFormat df = (DecimalFormat) DecimalFormat.getInstance(Locale.US);
        df.applyPattern("####0.00");
        return "monthlyPayment: " + df.format(monthlyPayment);
    }
}
