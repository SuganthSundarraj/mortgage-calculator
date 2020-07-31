package com.mortgage;

import java.util.Map;

public class ValidateInputTaskImpl implements ValidateInputTask {


  @Override
  public boolean validate(Map<String, String> request) {
    
    if (request == null || request.get("type") == null || request.get("principle") == null
        || request.get("term") == null) {
       throw new NullPointerException();
     }
    
     Double principle = Double.parseDouble(request.get("principle"));
    Integer term = Integer.parseInt(request.get("term"));
    String type = request.get("type");
    
    if (principle == 0 || term == 0 || principle < 0 || term < 0) {
       throw new IllegalArgumentException();
     }

     if (!("fixed").equalsIgnoreCase(type) && !("interest").equalsIgnoreCase(type)) {
       throw new IllegalArgumentException();
     }

    return true;
  }

}
