package com.microservices.Students_Management.controller;

import com.microservices.Students_Management.domain.Student;
import com.microservices.Students_Management.response.Course;
import com.microservices.Students_Management.response.StudentResponse;
import com.microservices.Students_Management.services.StudentService;
//import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class StudentController {

    Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    StudentService studentService;

    @PostMapping("/save-student")
    private ResponseEntity<Student> saveStudentData(@RequestBody Student student){
        ResponseEntity<Student> studentResponse = null;
        Student savedStudent = studentService.saveStudent(student);
        if (savedStudent != null){
            studentResponse = ResponseEntity.status(HttpStatus.CREATED).body(savedStudent);
        }else {
            studentResponse =ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return studentResponse;
    }

    @GetMapping("/getAllStudent")
    private ResponseEntity<List<Student>> getAllStudents(){
        ResponseEntity<List<Student>> studentResponse = null;
        List<Student> student = studentService.getAllStudent();
        List<Course> courses = studentService.getAllCourses();
        if (student.size()>0){
            studentResponse = ResponseEntity.status(HttpStatus.OK).body(student);
        }else {
            studentResponse = ResponseEntity.status(HttpStatus.NOT_FOUND).body(Arrays.asList());
        }
        return studentResponse;
    }

    @GetMapping("/getAllStudents")
//    @CircuitBreaker(name = "FEES-MANAGEMENT-SERVICE",fallbackMethod = "feesManagementServiceFallback")
    private ResponseEntity<List<StudentResponse>> getAllStudentDataInList(){
        ResponseEntity<List<StudentResponse>> studentResponse = null;
        List<StudentResponse> studentsList = studentService.getAllStudentsList();
        List<Course> courses = studentService.getAllCourses();
        if (studentsList.size()>0){
            studentResponse = ResponseEntity.status(HttpStatus.OK).body(studentsList);
        }else {
            studentResponse = ResponseEntity.status(HttpStatus.NOT_FOUND).body(Arrays.asList());
        }
        return studentResponse;
    }


    //creating fallback method for circuit breaker

    public ResponseEntity<List<StudentResponse>> feesManagementServiceFallback(Exception exception){
        logger.info("fallback method is executed because of service failure : ", exception.getMessage());
        List<Course> course = new ArrayList<>();
        ResponseEntity<List<StudentResponse>> studentResponse = null;
        StudentResponse dummyData = new StudentResponse(1L,"Dummy","Data",
                "null",0,"null", course);
        studentResponse = ResponseEntity.status(HttpStatus.OK).body(List.of(dummyData));
        return studentResponse;
    }
}
