package com.microservices.collagemanagement.repository;

import com.microservices.collagemanagement.model.Courses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Courses,Integer> {
}
