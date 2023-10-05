package com.hkjava.demo.demoresttemplate;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import static org.mockito.ArgumentMatchers.isNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import com.hkjava.demo.demoresttemplate.model.User;
import com.hkjava.demo.demoresttemplate.service.UserService;

import static org.hamcrest.Matchers.*;

// This is another Testing Environment
// which may not require a full context
@WebMvcTest // @AutoConfigureMockMvc
public class UserControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private UserService userService;

  @Test
  void testGetUsers() throws Exception {
    User user1 = new User(1, "John", "johnlau", "johnlau@gmail.com", null, null,
        null, null);
    User user2 = new User(2, "Mary", "marylau", "marylau@gmail.com", null, null,
        null, null);
    Mockito.when(userService.findUsers()).thenReturn(List.of(user1, user2));

    // ResultActions mvcResult = mockMvc.perform(get("/api/v1/users"));

    mockMvc.perform(get("/api/v1/users")) //
        .andExpect(status().isOk()) // HTTP 200
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.code").value(20000))
        .andExpect(jsonPath("$.message").value("OK"))
        .andExpect(jsonPath("$.data[0].id").value(1))
        .andExpect(jsonPath("$.data[0].name").value("John"))
        .andExpect(jsonPath("$.data[1].id").value(2))
        .andExpect(jsonPath("$.data[1].name").value("Mary"))
        .andDo(MockMvcResultHandlers.print());
  }

  @Test
  void testEmptyUsers() throws Exception {
    Mockito.when(userService.findUsers()).thenReturn(null);

    // ResultActions mvcResult = mockMvc.perform(get("/api/v1/users"));

    mockMvc.perform(get("/api/v1/users")) //
        .andExpect(status().isBadRequest()) // HTTP 400
        .andExpect(content().contentType(MediaType.APPLICATION_JSON)) //
        .andExpect(jsonPath("$.code").value(40001)) //
        .andExpect(
            jsonPath("$.message").value("JsonPlaceHolder RestClientException")) //
        .andExpect(jsonPath("$.data").doesNotExist())
        .andDo(MockMvcResultHandlers.print());
  }


}
