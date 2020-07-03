package com.mortgage;

public class MortgageCalculatorController implements MortgageCalculatorInterface {

  private MortgageCalculatorTask mortgageCalculatorTask;
  private ValidateInputTask validateInputTask;

  public MortgageCalculatorController(MortgageCalculatorTask mortgageCalculatorTask) {
    this.mortgageCalculatorTask = mortgageCalculatorTask;
  }

  public MortgageCalculatorController() {}

  public double calculateMonthlyPayment(Double principal, Double yearlyRate, Integer term)
      throws Exception {
    validateInputTask = new ValidateInputTaskImpl();
    validateInputTask.validate(principal, yearlyRate, term);
    return mortgageCalculatorTask.calculateMonthlyPayment(principal, yearlyRate, term);
  }

}
