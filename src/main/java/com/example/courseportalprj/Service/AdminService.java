package com.example.courseportalprj.Service;

import java.util.List;
import java.util.Map;

import com.example.courseportalprj.Model.Course;
import com.example.courseportalprj.Model.Enrollment;
import com.example.courseportalprj.Model.Student;

public interface AdminService {

    Map<String, Object> getDashboardStats();

    List<Student> getAllStudents();

    List<Student> getAllInstructors();

    List<Course> getAllCourses();

    List<Enrollment> getAllEnrollments();

    List<Enrollment> getProgressByCourse(Long courseId);

    List<Enrollment> getProgressByStudent(Long studentId);
}