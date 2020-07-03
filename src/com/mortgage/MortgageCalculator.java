package com.mortgage;

import java.util.HashMap;
import java.util.Map;

public class MortgageCalculator {

  static MortgageCalculatorProcessTask mortgageCalculatorProcessTask =
      new MortgageCalculatorProcessTaskImpl();

  public static void main(String[] ags) throws Exception {

    Map<String, String> request = new HashMap<>();
    request.put("type", "fixed");
    request.put("principle", "100000.0");
    request.put("yearlyRate", "5.0");
    request.put("term", "5");

    mortgageCalculatorProcessTask.process(request);

    Map<String, String> request2 = new HashMap<>();
    request2.put("type", "interest");
    request2.put("principle", "100000.0");
    request2.put("yearlyRate", "5.0");
    request2.put("term", "5");

    mortgageCalculatorProcessTask.process(request2);


  }
}
