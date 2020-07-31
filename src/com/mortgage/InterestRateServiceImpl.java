package com.mortgage;

public class InterestRateServiceImpl implements InterestRateService {

  private Double currentInterestRate = null;

  @Override
  public Double getRates() {
    currentInterestRate = 8.0;
    return currentInterestRate;
  }


}
