package com.example.courseportalprj.Service;

import java.util.List;
import com.example.courseportalprj.Model.Course;

public interface CourseService {
    Course insert(Course course);
    Course search(Long id);
    Course update(Course course);
    List<Course> getAll();
    void delete(Long id);
}