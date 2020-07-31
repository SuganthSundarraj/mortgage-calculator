package com.mortgage;

import java.util.Map;

public class MortgageProcessorTaskImpl implements MortgageProcessorTask {

  MortgageCalculatorTask mortgageCalculatorTask;
  ApplicationObject application = new ApplicationInstance();
  InterestRateService interestRateService = new InterestRateServiceImpl();

  // image it acts as the dependency injection based on the run time value
  @Override
  public String process(Map<String, String> request) {
    mortgageCalculatorTask = (MortgageCalculatorTask) application.getInstance(request.get("type"));
    try {
      Double currentInterestRate = interestRateService.getRates();
      return
          "Result  :" + request.get("type") + " : " + mortgageCalculatorTask
              .calculateMonthlyPayment(Double.parseDouble(request.get("principle")),
                  currentInterestRate,
              Integer.parseInt(request.get("term")));

    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

}
