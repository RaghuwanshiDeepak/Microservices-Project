package com.microservices.Students_Management.repository;

import com.microservices.Students_Management.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
}
