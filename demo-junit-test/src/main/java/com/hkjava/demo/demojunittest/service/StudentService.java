package com.hkjava.demo.demojunittest.service;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hkjava.demo.demojunittest.Entity.StudentEntity;
import com.hkjava.demo.demojunittest.model.Student;
import com.hkjava.demo.demojunittest.model.StudentMapper;
import com.hkjava.demo.demojunittest.repository.StudentRepository;


@Service
public class StudentService {

  @Autowired
  StudentRepository studentRepository;

  public List<Student> findAll() {
    // approach 1
    // List<Student> output = new ArrayList<>();
    // for (StudentEntity se : studentRepository.findAll()) {
    // output.add(StudentMapper.map(se));
    // }
    // return output;
    // approach 2
    return studentRepository.findAll().stream()//
        .map(e -> StudentMapper.map(e))//
        .collect(Collectors.toList());
  }

  public String getStudentName() {
    return new Student("Mary", 30).getName();
  }

  // junit test test唔到，就應該group埋D野
  // app2

  public String getStudentName(String name) {
    // if IAE
    if (name == null)
      throw new IllegalArgumentException();
    return this.getDB();// mock Mary
  }

  public String getDB() { // get from DB
    return new Student("John", 30).concat("Chan");
  }

}