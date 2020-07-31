package com.mortgage;

import static org.junit.Assert.assertEquals;
import java.util.HashMap;
import java.util.Map;
import org.junit.BeforeClass;
import org.junit.Test;

public class MortgageProcessorTaskImplTest {

  static MortgageProcessorTaskImpl mortgageProcessorTaskImpl;

  @BeforeClass
  public static void intialiseObject() {
    mortgageProcessorTaskImpl = new MortgageProcessorTaskImpl();
  }

  @Test
  public void validInput() {
    Map<String, String> request = new HashMap<>();
    request.put("type", "fixed");
    request.put("principle", "100000.0");
    request.put("term", "5");
    mortgageProcessorTaskImpl.process(request);
    assertEquals("Result  :fixed : 2027.64", mortgageProcessorTaskImpl.process(request));
  }

  @Test(expected = NullPointerException.class)
  public void inValidInputWithPayloadNull() {
    Map<String, String> request = null;
    assertEquals(true, mortgageProcessorTaskImpl.process(request));
  }

  @Test(expected = NullPointerException.class)
  public void inValidInput() {
    Map<String, String> request = new HashMap<>();
    request.put("type", null);
    request.put("principle", null);
    request.put("term", null);
    assertEquals(true, mortgageProcessorTaskImpl.process(request));
  }

}
