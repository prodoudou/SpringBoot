package com.hkjava.demo.demoresttemplate.controller.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hkjava.demo.demoresttemplate.controller.UserOperation;
import com.hkjava.demo.demoresttemplate.infra.ApiResponse;
import com.hkjava.demo.demoresttemplate.infra.Code;
import com.hkjava.demo.demoresttemplate.mapper.UserMapper;
import com.hkjava.demo.demoresttemplate.model.User;
import com.hkjava.demo.demoresttemplate.model.UserDTO;
import com.hkjava.demo.demoresttemplate.service.UserService;

@RestController // Controller + ResponseBody
@RequestMapping("/api/v1")
public class UserController implements UserOperation {

  @Autowired
  private UserService userService;

  @Override
  public ResponseEntity<ApiResponse<List<UserDTO>>> findUsers() throws Exception {
    List<User> users = userService.findUsers();

    // Conversion (user -> userDTO)
    List<UserDTO> userDTOs = users.stream() //
        .map(user -> UserMapper.map(user)) //
        .collect(Collectors.toList());

    ApiResponse<List<UserDTO>> response = ApiResponse.<List<UserDTO>>builder() //
        .ok() //
        .data(userDTOs) //
        .build();
    return ResponseEntity.ok().body(response);
  }

}
