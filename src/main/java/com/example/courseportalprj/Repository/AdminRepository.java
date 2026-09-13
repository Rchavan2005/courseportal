package com.example.courseportalprj.Repository;

import java.util.List;

import com.example.courseportalprj.Model.Course;
import com.example.courseportalprj.Model.Enrollment;
import com.example.courseportalprj.Model.Student;

public interface AdminRepository {

    long countStudents();

    long countInstructors();

    long countCourses();

    long countEnrollments();

    long countCompletedEnrollments();

    long countActiveEnrollments();

    double getAverageProgress();

    List<Student> getAllStudents();

    List<Student> getAllInstructors();

    List<Course> getAllCourses();

    List<Enrollment> getAllEnrollments();

    List<Enrollment> getProgressByCourse(Long courseId);

    List<Enrollment> getProgressByStudent(Long studentId);
}