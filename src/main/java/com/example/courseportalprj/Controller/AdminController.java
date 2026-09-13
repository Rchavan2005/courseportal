package com.example.courseportalprj.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.courseportalprj.Model.Course;
import com.example.courseportalprj.Model.Enrollment;
import com.example.courseportalprj.Model.Student;
import com.example.courseportalprj.Service.AdminService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;


    // ==============================
    // ADMIN DASHBOARD
    // ==============================

    @GetMapping("/dashboard")
    public Map<String, Object> getDashboardStats() {

        return adminService.getDashboardStats();
    }


    // ==============================
    // ALL STUDENTS
    // ==============================

    @GetMapping("/students")
    public List<Student> getAllStudents() {

        return adminService.getAllStudents();
    }


    // ==============================
    // ALL INSTRUCTORS
    // ==============================

    @GetMapping("/instructors")
    public List<Student> getAllInstructors() {

        return adminService.getAllInstructors();
    }


    // ==============================
    // ALL COURSES
    // ==============================

    @GetMapping("/courses")
    public List<Course> getAllCourses() {

        return adminService.getAllCourses();
    }


    // ==============================
    // ALL ENROLLMENTS
    // ==============================

    @GetMapping("/enrollments")
    public List<Enrollment> getAllEnrollments() {

        return adminService.getAllEnrollments();
    }


    // ==============================
    // ALL PROGRESS
    // ==============================

    @GetMapping("/progress")
    public List<Enrollment> getAllProgress() {

        return adminService.getAllEnrollments();
    }


    // ==============================
    // PROGRESS BY COURSE
    // ==============================

    @GetMapping("/progress/course/{courseId}")
    public List<Enrollment> getProgressByCourse(
            @PathVariable Long courseId) {

        return adminService.getProgressByCourse(courseId);
    }


    // ==============================
    // PROGRESS BY STUDENT
    // ==============================

    @GetMapping("/progress/student/{studentId}")
    public List<Enrollment> getProgressByStudent(
            @PathVariable Long studentId) {

        return adminService.getProgressByStudent(studentId);
    }
}