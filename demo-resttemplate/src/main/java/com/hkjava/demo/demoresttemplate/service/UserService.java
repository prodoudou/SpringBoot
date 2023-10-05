package com.hkjava.demo.demoresttemplate.service;

import java.util.List;
import com.hkjava.demo.demoresttemplate.infra.BusinessException;
import com.hkjava.demo.demoresttemplate.model.User;

public interface UserService {
  
  public List<User> findUsers() throws BusinessException;
  
}
