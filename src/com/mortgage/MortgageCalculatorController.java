package com.mortgage;

import java.util.HashMap;
import java.util.Map;

public class MortgageCalculatorController {

  static MortgageProcessorTask mortgageCalculatorProcessTask =
      new MortgageProcessorTaskImpl();
  static ValidateInputTask validator = new ValidateInputTaskImpl();

  public static void main(String[] ags) throws Exception {

    Map<String, String> request = new HashMap<>();
    request.put("type", "fixed");
    request.put("principle", "100000.0");
    request.put("yearlyRate", "5.0");
    request.put("term", "5");

    validator.validate(request);
    System.out.println(mortgageCalculatorProcessTask.process(request));

    Map<String, String> request2 = new HashMap<>();
    request2.put("type", "interest");
    request2.put("principle", "100000.0");
    request2.put("yearlyRate", "5.0");
    request2.put("term", "5");

    validator.validate(request2);
    System.out.println(mortgageCalculatorProcessTask.process(request2));


  }
}
