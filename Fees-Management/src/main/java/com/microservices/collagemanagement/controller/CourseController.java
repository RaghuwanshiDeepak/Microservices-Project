package com.microservices.collagemanagement.controller;

import com.microservices.collagemanagement.model.Courses;
import com.microservices.collagemanagement.services.CourseService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseService courseService;

    @PostMapping("saveCourseDetails")
    public ResponseEntity<Courses> saveCourseDetails(@RequestBody Courses courses){
        ResponseEntity<Courses> response = null;
        Courses savedData =courseService.saveDetails(courses);
        if (savedData != null){
            response = ResponseEntity.status(HttpStatus.CREATED).body(savedData);
        }else {
            response = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return response;
    }

    @GetMapping("/getAllCourses")
    private ResponseEntity<List<Courses>> getAllCourses(){
        ResponseEntity<List<Courses>> courseResponse = null;
        List<Courses> courses = courseService.getAllCourses();
        if (courses.size()>0){
            courseResponse = ResponseEntity.status(HttpStatus.OK).body(courses);
        }else {
            courseResponse = ResponseEntity.status(HttpStatus.NOT_FOUND).body(Arrays.asList());
        }
        return courseResponse;
    }

    @GetMapping("/getAllCourseWithStudentId/{studentId}")
    private List<Courses> getAllCoursesByStudentId(@PathVariable("studentId") Long studentId){
//        ResponseEntity<List<Courses>> courseResponse = null;
        return courseService.getAllCoursesByStudentId(studentId);
    }
}
