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

    return createErrorResponseEntity(TestException.class, exception.getClass());
  }

  @ExceptionHandler(HttpStatusCodeException.class)
  public ResponseEntity<ErrorResponse> catchHttpStatusCodeException(HttpStatusCodeException exception) {

    return createErrorResponseEntity(HttpStatusCodeException.class, exception.getClass());
  }

  private ResponseEntity<ErrorResponse> createErrorResponseEntity(Class<? extends Exception> exceptionHandlerType,
                                                                  Class<? extends Exception> injectedException) {

    var exceptionClassName = exceptionHandlerType.getSimpleName();
    var injectedExceptionClassName = injectedException.getSimpleName();

    var responseMessage = String.format("Exception handler method for %s was injected with exception of type %s",
        exceptionClassName, injectedExceptionClassName);

    return ResponseEntity.badRequest()
        .body(ErrorResponse.withMessage(responseMessage));
  }

}
