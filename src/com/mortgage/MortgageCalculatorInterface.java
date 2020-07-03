package com.mortgage;

public interface MortgageCalculatorInterface {

  public double calculateMonthlyPayment(Double principal, Double yearlyRate, Integer term)
      throws Exception;
}
