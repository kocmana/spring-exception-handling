package at.kocmana.spring_exception_handling.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(staticName = "withMessage")
@Getter
public final class ErrorResponse {
  private final String message;
}
