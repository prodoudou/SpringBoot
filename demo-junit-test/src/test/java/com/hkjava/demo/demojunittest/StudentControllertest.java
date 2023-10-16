package com.hkjava.demo.demojunittest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.hkjava.demo.demojunittest.controller.StudentController;
import com.hkjava.demo.demojunittest.model.Student;
import com.hkjava.demo.demojunittest.service.StudentService;




// @ExtendWith(MockitoExtension.class)
@SpringBootTest
public class StudentControllertest {

  @Spy // 要真bean。mock走部分功能
  StudentService studentService;
  // @mock只能一對一，@Spy拎晒全部真野，mock走部分野。所以先 .when
  @InjectMocks
  StudentController studentController;

  // @mockMVC for restfulApi
  // Controller入口 @MockBean
  // MVC 試Json
  @Test
  void testGetDB() {
    // when
    Mockito.when(studentService.getDB()).thenReturn("Mary Lau");
    // test
    String result = studentService.getStudentName("Dummy");
    // assert
    assertEquals("Mary Lau", result);
  }

  // myself version
  @Test
  void testgetStudentName2() {
    // when
    // // Arrange (Mock the behavior of the service method)
    String expectedName = new Student("Mary", 30).getName();
    Mockito.when(this.studentService.getDB()).thenReturn(expectedName);
    // test
    // Act and Assert
    // Test with a valid name
    String validName = new Student("John", 40).getName();

    // Mock the behavior of the service method to return a valid result
    Mockito.when(studentService.getDB()).thenReturn("John Chan");

    String result = studentController.getStudentName(validName);
    assertEquals("John Chan", result);
    // assert
    // Test with a null name, expecting an IllegalArgumentException
    assertThrows(IllegalArgumentException.class,
        () -> studentController.getStudentName(null));



  }
}