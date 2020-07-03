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

  public static void main(String[] ags) throws Exception {

    MortgageCalculatorTask mortgageCalculatorTask =
        new FixedRateMortgageCalculatorTaskImpl();
    MortgageCalculatorInterface mortgageCalulator =
        new MortgageCalculatorController(mortgageCalculatorTask);

    System.out.println(
        "Fixed Rate result :" + mortgageCalulator.calculateMonthlyPayment(100000.0, 8.0, 5));

  }
}
