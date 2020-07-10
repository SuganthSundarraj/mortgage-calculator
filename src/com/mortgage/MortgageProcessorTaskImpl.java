package com.mortgage;

import java.util.Map;

public class MortgageProcessorTaskImpl implements MortgageProcessorTask {

  MortgageCalculatorTask mortgageCalculatorTask;
  ApplicationObject application = new ApplicationInstance();

  // image it acts as the dependency injection based on the run time value
  @Override
  public String process(Map<String, String> request) {
    mortgageCalculatorTask = (MortgageCalculatorTask) application.getInstance(request.get("type"));
    try {
      return
          "Result  :" + request.get("type") + " : " + mortgageCalculatorTask
              .calculateMonthlyPayment(Double.parseDouble(request.get("principle")),
                  Double.parseDouble(request.get("yearlyRate")),
              Integer.parseInt(request.get("term")));

    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

}
