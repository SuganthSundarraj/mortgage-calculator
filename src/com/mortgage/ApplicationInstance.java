package com.mortgage;

public class ApplicationInstance implements ApplicationObject {
  
  @Override
  public Object getInstance(String type) {
    switch (type) {
      case "fixed":
        return new FixedRateMortgageCalculatorTaskImpl();
      case "interest":
        return new InterestOnlyMortgageCalculatorTaskImpl();
      default:
        return null;
    }
  }

}
