package com.hkjava.demo.demojunittest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hkjava.demo.demojunittest.Entity.StudentEntity;


public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

}
  

