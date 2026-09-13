package com.example.courseportalprj.Service;

import java.util.List;

import com.example.courseportalprj.Model.Course;
import com.example.courseportalprj.Model.Student;

public interface CourseService {

    Course insert(Course course);

    Course search(Long id);

    Course update(Course course);

    List<Course> getAll();

    void delete(Long id);

    // Get courses created by an instructor
    List<Course> getByInstructor(Student instructor);
}