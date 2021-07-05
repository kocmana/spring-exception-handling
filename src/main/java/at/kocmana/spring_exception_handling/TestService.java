package at.kocmana.spring_exception_handling;

import at.kocmana.spring_exception_handling.model.TestException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

@Service
@NoArgsConstructor(access = AccessLevel.PACKAGE)
class TestService {

  void causeException() {
    try {
      throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
    } catch (HttpClientErrorException exception) {
      throw new TestException("Wrapped Exception", exception);
    }
  }

}
