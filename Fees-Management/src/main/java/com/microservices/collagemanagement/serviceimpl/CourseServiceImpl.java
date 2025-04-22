package com.microservices.collagemanagement.serviceimpl;

import com.microservices.collagemanagement.model.Courses;
import com.microservices.collagemanagement.repository.CourseRepository;
import com.microservices.collagemanagement.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepository courseRepository;
    @Override
    public Courses saveDetails(Courses courses) {
        return courseRepository.save(courses);
    }

    @Override
    public List<Courses> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public List<Courses> getAllCoursesByStudentId(Long studentId) {
        List<Courses> coursesList = courseRepository.findAll();
        for (Courses courses:coursesList) {
            coursesList  = coursesList.stream().filter(coursesLists -> courses.getStudentId().equals(studentId)).collect(Collectors.toList());
        }
        return coursesList;
    }
}
