package com.example.courseportalprj.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.courseportalprj.Model.Course;
import com.example.courseportalprj.Model.Student;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    // Get all courses created by a particular instructor
    List<Course> findByInstructor(Student instructor);
}