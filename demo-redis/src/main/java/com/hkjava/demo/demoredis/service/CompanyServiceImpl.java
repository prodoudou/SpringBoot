package com.hkjava.demo.demoredis.service;

import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;
import com.hkjava.demo.demoredis.infra.RedisHelper;
import com.hkjava.demo.demoredis.model.CompanyProfile;
import com.hkjava.demo.demoredis.model.StringHolder;

@Service
public class CompanyServiceImpl {

  @Autowired
  @Qualifier(value = "redisProfileHelper")
  private RedisHelper<CompanyProfile> redisStringHelper;

  public void set() {
    System.out.println("Start");
    redisStringHelper.set("key",
        new CompanyProfile("AAPL", LocalDate.of(1988, 12, 20)), 50000);
    System.out.println("End");
  }

  public void get() {
    System.out.println("Start");
    CompanyProfile companyProfile = (CompanyProfile) redisStringHelper.get("key");
    System.out.println("redis=" + companyProfile);
    System.out.println("End");
  }

}
