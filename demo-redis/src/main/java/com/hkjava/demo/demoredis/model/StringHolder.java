package com.hkjava.demo.demoredis.model;

import java.io.Serializable;

public class StringHolder implements Serializable {
  private String string;

  public StringHolder(String string) {
    this.string = string;
  }

  public String getString() {
    return this.string;
  }

  public void setString(String string) {
    this.string = string;
  }

  public String toString() {
    return "string=" + this.string;
  }
}
