package at.kocmana.spring_exception_handling;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TestConstants {

  public static final String EXPECTED_EXCEPTION_MESSAGE = "Wrapped Exception";

  public static final String EXPECTED_RESPONSE_MESSAGE =
      "Exception handler method for TestException was injected with exception of type HttpClientErrorException";

}
