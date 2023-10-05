package com.hkjava.demo.demoresttemplate.service.impl;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.hkjava.demo.demoresttemplate.exception.JPHException;
import com.hkjava.demo.demoresttemplate.infra.BusinessException;
import com.hkjava.demo.demoresttemplate.infra.Code;
import com.hkjava.demo.demoresttemplate.infra.Protocol;
import com.hkjava.demo.demoresttemplate.model.User;
import com.hkjava.demo.demoresttemplate.service.UserService;

@Service
public class UserServiceImpl implements UserService { // Bean

  @Autowired
  private RestTemplate restTemplate; // from Context

  @Value(value = "${api.jsonplaceholder.domain}")
  private String jphDomain; // from yml

  @Value(value = "${api.jsonplaceholder.endpoints.user}")
  private String userEndpoint; // from yml

  @Override
  public List<User> findUsers() throws BusinessException {
    String url = UriComponentsBuilder.newInstance() //
        .scheme(Protocol.HTTPS.name()) //
        .host(jphDomain) //
        .path(userEndpoint) //
        .toUriString();

    System.out.println("url=" + url);
    // Invoke API + Jaskson Deserialization (JSON -> Object)
    //try {
      User[] users = restTemplate.getForObject(url, User[].class);
      // return Arrays.asList(users);
    // } catch (RestClientException e) {
      throw new JPHException(Code.JPH_NOTFOUND);
    // }
  }

}
