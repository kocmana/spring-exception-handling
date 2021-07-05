package at.kocmana.spring_exception_handling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

  private final TestService testService;

  @Autowired
  public TestController(TestService testService) {
    this.testService = testService;
  }

  @GetMapping("/test")
  public ResponseEntity<Void> causeException() {

    testService.causeException();

    return ResponseEntity.ok().build();
  }

}
