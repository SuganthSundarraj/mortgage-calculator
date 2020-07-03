package com.mortgage;

import static org.junit.Assert.assertEquals;
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
    assertEquals(true, validateInputTaskImpl.validate(null, 5.0, 2));
  }

  @Test
  public void validInput() {
    assertEquals(true, validateInputTaskImpl.validate(10000.0, 5.0, 2));
  }

}
