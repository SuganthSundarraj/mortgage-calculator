package com.mortgage;

public class ValidateInputTaskImpl implements ValidateInputTask {

  @Override
  public boolean validate(Double principal, Double yearlyRate, Integer term) {
    if (principal == null || yearlyRate == null || term == null) {
      throw new NullPointerException();
    }
    return true;
  }

}
