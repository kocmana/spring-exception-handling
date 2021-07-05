package at.kocmana.spring_exception_handling;

import static at.kocmana.spring_exception_handling.TestConstants.EXPECTED_RESPONSE_MESSAGE;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
class ExceptionHandlingIT {

  @Autowired
  private MockMvc mockMvc;

  @Test
  void correctExceptionIsThrown() throws Exception {

    mockMvc.perform(MockMvcRequestBuilders.get("/test")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isBadRequest())
        .andExpect(jsonPath("$.message").value(EXPECTED_RESPONSE_MESSAGE));
  }

}
