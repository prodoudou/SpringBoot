package com.hkjava.demo.demojunittest.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class StudentTest {

  @Test
  void testSetterGetter() {
    // when
    Student student = new Student("John", 30);
    // test getter
    String name = student.getName();
    // assert
    assertEquals("John", name);
    // test setter
    student.setName("Mary");
    // assert
    assertEquals("Mary",student.getName());
  }

  @Test
  void testConcat() {
    // when
    String lastName = "Wong";
    Student student = new Student("John", 30);
    // test
    String result = student.concat(lastName);
    // assert
    assertEquals("John Wong", result);
  }

  @Test
  void testCalculateScore() {
    // when
    int score = 20;
    Student student = new Student("John", 30);
    // test
    int result = student.calculateScore(score);
    assertEquals(20, result);

    student.setAge(17);
    result = student.calculateScore(score);
    assertEquals(25, result);

    student.setAge(18);
    result = student.calculateScore(score);
    assertEquals(20, result);

    student.setAge(65);
    result = student.calculateScore(score);
    assertEquals(30, result);

    student.setAge(64);
    result = student.calculateScore(score);
    assertEquals(20, result);
  }

}
