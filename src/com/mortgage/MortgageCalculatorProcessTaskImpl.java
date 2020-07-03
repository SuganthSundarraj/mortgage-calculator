package com.mortgage;

import java.util.Map;

public class MortgageCalculatorProcessTaskImpl implements MortgageCalculatorProcessTask {

  MortgageCalculatorTask mortgageCalculatorTask;
  ApplicationObject application = new ApplicationInstance();

  // image it acts as the dependency injection based on the run time value
  @Override
  public void process(Map<String, String> request) {
    mortgageCalculatorTask = (MortgageCalculatorTask) application.getInstance(request.get("type"));

    try {
      System.out.println(
          "Result  :" + request.get("type") + " : " + mortgageCalculatorTask
              .calculateMonthlyPayment(Double.parseDouble(request.get("principle")),
                  Double.parseDouble(request.get("yearlyRate")),
                  Integer.parseInt(request.get("term"))));

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
