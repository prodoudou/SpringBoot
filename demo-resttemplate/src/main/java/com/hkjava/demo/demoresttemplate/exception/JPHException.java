package com.hkjava.demo.demoresttemplate.exception;

import com.hkjava.demo.demoresttemplate.infra.BusinessException;
import com.hkjava.demo.demoresttemplate.infra.Code;

public class JPHException extends BusinessException {

  public JPHException(Code code) {
    super(code);
  }

}
