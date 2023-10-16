package com.hkjava.demo.demojunittest.model;

import com.hkjava.demo.demojunittest.Entity.StudentEntity;

public class StudentMapper {
  
  public static Student map(StudentEntity studentEntity) {
    return Student.builder()//
        .name(studentEntity.getName())//
        .age(studentEntity.getAge())//
        .build();

  }
}