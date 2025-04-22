package com.microservices.collagemanagement.services;

import com.microservices.collagemanagement.model.Courses;

import java.util.List;

public interface CourseService {


    Courses saveDetails(Courses courses);

    List<Courses> getAllCourses();

    List<Courses> getAllCoursesByStudentId(Long studentId);
}
