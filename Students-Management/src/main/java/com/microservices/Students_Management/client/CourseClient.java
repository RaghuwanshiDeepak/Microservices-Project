package com.microservices.Students_Management.client;

import com.microservices.Students_Management.response.Course;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//@FeignClient(url = "http://localhost:9090",value = "FEES-MANAGEMENT")
@FeignClient(name = "FEES-MANAGEMENT",value = "FEES-MANAGEMENT")
public interface CourseClient {

    @GetMapping("/getAllCourses")
    public List<Course> getAllCourse();

    @GetMapping("/getAllCourseWithStudentId/{studentId}")
    List<Course> getAllCoursesByStudentId(@PathVariable("studentId") Long studentId);
}
