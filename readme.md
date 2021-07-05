# Unexpected Spring Boot Controller Advice Behavior

This project aims to showcase an unexpected behavior of Spring Boot when dealing with exceptions:
After the following code:
```
    try {
      throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
    } catch (HttpClientErrorException exception) {
      throw new TestException("Wrapped Exception", exception);
    }
```
both instances of `HttpClientErrorException` and `TestException` remain available in the application context.

Consequently, Spring `ControllerAdvice` classes can still have methods where the actually already caught `HttpClientErrorException` is injected:
```
  @ExceptionHandler(TestException.class)
  public ResponseEntity<ErrorResponse> catchTestException(HttpStatusCodeException exception) {
```
