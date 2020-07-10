package com.mortgage;

import static org.junit.Assert.assertEquals;
import java.util.HashMap;
import java.util.Map;
import org.junit.BeforeClass;
import org.junit.Test;

public class ValidateInputTaskImplTest {

  static ValidateInputTaskImpl validateInputTaskImpl;

  @BeforeClass
  public static void intialiseObject() {
    validateInputTaskImpl = new ValidateInputTaskImpl();
  }

  @Test(expected = NullPointerException.class)
  public void inValidInput() {
    Map<String, String> request = new HashMap<>();
    request.put("type", null);
    request.put("principle", null);
    request.put("yearlyRate", null);
    request.put("term", null);
    assertEquals(true, validateInputTaskImpl.validate(request));
  }

  @Test(expected = NullPointerException.class)
  public void inValidInputWithPayloadNull() {
    Map<String, String> request = null;
    assertEquals(true, validateInputTaskImpl.validate(request));
  }

  @Test
  public void validInput() {
    Map<String, String> request = new HashMap<>();
    request.put("type", "fixed");
    request.put("principle", "100000.0");
    request.put("yearlyRate", "5.0");
    request.put("term", "5");
    assertEquals(true, validateInputTaskImpl.validate(request));
  }

}
