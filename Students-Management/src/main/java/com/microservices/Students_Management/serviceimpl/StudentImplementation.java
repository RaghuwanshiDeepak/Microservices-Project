package com.microservices.Students_Management.serviceimpl;

import com.microservices.Students_Management.client.CourseClient;
import com.microservices.Students_Management.domain.Student;
import com.microservices.Students_Management.repository.StudentRepository;
import com.microservices.Students_Management.response.Course;
import com.microservices.Students_Management.response.StudentResponse;
import com.microservices.Students_Management.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentImplementation implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CourseClient courseClient;

    @Override
    public Student saveStudent(Student student) {
        Student response = studentRepository.save(student);
        return response;
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public List<Course> getAllCourses() {
        List<Course> courses = courseClient.getAllCourse();
        return courses;
    }

    @Override
    public List<StudentResponse> getAllStudentsList() {
        List<Student> studentList = studentRepository.findAll();
        StudentResponse studentResponses = new StudentResponse();
        List<Course> courses = null;
        if (!studentList.isEmpty()) {
            for (Student student: studentList) {
                Long studentId = student.getStudentId();
                courses = courseClient.getAllCoursesByStudentId
                        (studentId);
                if (courses != null && courses.size()>0){
                    studentResponses.setCourse(courses);
                }
            }
        }else {
            courses = Collections.emptyList();
        }
        studentResponses.setStudentId(studentList.get(0).getStudentId());
        studentResponses.setFirstName(studentList.get(0).getFirstName());
        studentResponses.setLastName(studentList.get(0).getLastName());
        studentResponses.setRollNumber(studentList.get(0).getRollNumber());
        studentResponses.setAge(studentList.get(0).getAge());
        studentResponses.setStandard(studentList.get(0).getStandard());
//        studentResponses.setCourse(courses);
        return List.of(studentResponses);
    }
}
