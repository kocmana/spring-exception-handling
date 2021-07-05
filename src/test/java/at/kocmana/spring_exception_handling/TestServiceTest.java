package at.kocmana.spring_exception_handling;

import static at.kocmana.spring_exception_handling.TestConstants.EXPECTED_EXCEPTION_MESSAGE;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

import at.kocmana.spring_exception_handling.model.TestException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {TestService.class})
class TestServiceTest {

  @Autowired
  private TestService testService;

  @Test
  void testServiceTest() {

    assertThatExceptionOfType(TestException.class).isThrownBy(testService::causeException)
        .withMessage(EXPECTED_EXCEPTION_MESSAGE);
  }

}
