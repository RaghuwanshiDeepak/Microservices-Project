package com.microservices.Students_Management.services;

import com.microservices.Students_Management.domain.Student;
import com.microservices.Students_Management.response.Course;
import com.microservices.Students_Management.response.StudentResponse;
import org.springframework.stereotype.Service;

import java.util.List;


public interface StudentService {

    public Student saveStudent(Student student);

    List<Student> getAllStudent();

    List<Course> getAllCourses();

    List<StudentResponse> getAllStudentsList();

}
