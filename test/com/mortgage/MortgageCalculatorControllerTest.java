package com.mortgage;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class MortgageCalculatorControllerTest {

  private MortgageCalculatorController mortgageCalculator;

  private MortgageCalculatorTask mortgageCalculatorTask;

  @Before
  public void intialiseObject() {
    mortgageCalculator = new MortgageCalculatorController();
    mortgageCalculatorTask = new MortgageCalculatorTask() {

      @Override
      public double calculateMonthlyPayment(double principal, double yearlyRate, int term)
          throws Exception {
        return 0;
      }
    };
  }

  @Test
  public void calculate5YearPayment() throws Exception {

    double result = mortgageCalculatorTask.calculateMonthlyPayment(100000.0, 8.0, 5);
    assertEquals(0, result, 0.1);
  }

   @Test(expected = NullPointerException.class)
   public void calculateWithAllInvalidInput() throws Exception {
     double result = mortgageCalculator.calculateMonthlyPayment(null, null, null);
     assertEquals(0, result, 0.1);
   }


}
