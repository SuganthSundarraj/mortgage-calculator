package com.mortgage;

import java.util.Map;

public interface MortgageProcessorTask {

  public String process(Map<String, String> request);

}
