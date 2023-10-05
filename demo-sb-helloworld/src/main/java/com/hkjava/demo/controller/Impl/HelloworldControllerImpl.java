package com.hkjava.demo.controller.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hkjava.demo.Service.Impl.HelloworldServiceImpl;
import com.hkjava.demo.controller.HelloworldController;

//@restcontroller = @controller + @responsebody
//controller 係接request

@Controller
@ResponseBody
@RequestMapping (value = "/api/v1")
 // = path = (value= " ")// 大慨係主頁之後既路徑＝requestmapping // 再按入去就係 getmapping
//crud api= select, update, delete //c stand for create, r stand for read, u stand for update, d stand for delete
// api = 比用家做D咩操作
//getmapping = read
//postmapping = 登記 = create
//put mapping = 更新 ＝ update
//delete mapping = delete
public class HelloworldControllerImpl implements HelloworldController {

@Autowired// check if any object implementing helloworldService
  HelloworldServiceImpl helloworldServiceImpl;
  //HelloworldServiceImpl helloworldServiceImpl = new HelloworldControllerImpl();



  public String hello(){
    return helloworldServiceImpl.generate(102);
  }
}
