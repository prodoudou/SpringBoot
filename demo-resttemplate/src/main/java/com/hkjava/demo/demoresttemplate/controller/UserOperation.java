package com.hkjava.demo.demoresttemplate.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import com.hkjava.demo.demoresttemplate.infra.ApiResponse;
import com.hkjava.demo.demoresttemplate.model.UserDTO;

public interface UserOperation {

  @GetMapping(value = "/users")
  ResponseEntity<ApiResponse<List<UserDTO>>> findUsers() throws Exception;

}
