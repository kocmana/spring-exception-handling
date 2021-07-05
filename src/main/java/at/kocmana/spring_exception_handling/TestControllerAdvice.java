package at.kocmana.spring_exception_handling;

import at.kocmana.spring_exception_handling.model.ErrorResponse;
import at.kocmana.spring_exception_handling.model.TestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpStatusCodeException;

@ControllerAdvice
public class TestControllerAdvice {

  @ExceptionHandler(TestException.class)
  public ResponseEntity<ErrorResponse> catchTestException(HttpStatusCodeException exception) {

    return createErrorResponseEntity(exception);
  }

  @ExceptionHandler(HttpStatusCodeException.class)
  public ResponseEntity<ErrorResponse> catchHttpStatusCodeException(HttpStatusCodeException exception) {

    return createErrorResponseEntity(exception);
  }


  private ResponseEntity<ErrorResponse> createErrorResponseEntity(HttpStatusCodeException exception) {
    String errorMessage = exception.getClass().getSimpleName();

    return ResponseEntity.badRequest()
        .body(ErrorResponse.withMessage(errorMessage));
  }

}
