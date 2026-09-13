package com.example.courseportalprj.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.courseportalprj.Model.Course;
import com.example.courseportalprj.Model.Enrollment;
import com.example.courseportalprj.Model.Student;
import com.example.courseportalprj.Repository.AdminRepositoryImpl;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepositoryImpl adminRepository;


    @Override
    public Map<String, Object> getDashboardStats() {

        Map<String, Object> stats = new LinkedHashMap<>();

        stats.put("totalStudents",
                adminRepository.countStudents());

        stats.put("totalInstructors",
                adminRepository.countInstructors());

        stats.put("totalCourses",
                adminRepository.countCourses());

        stats.put("totalEnrollments",
                adminRepository.countEnrollments());

        stats.put("completedEnrollments",
                adminRepository.countCompletedEnrollments());

        stats.put("activeEnrollments",
                adminRepository.countActiveEnrollments());

        stats.put("averageProgress",
                adminRepository.getAverageProgress());

        return stats;
    }


    @Override
    public List<Student> getAllStudents() {

        return adminRepository.getAllStudents();
    }


    @Override
    public List<Student> getAllInstructors() {

        return adminRepository.getAllInstructors();
    }


    @Override
    public List<Course> getAllCourses() {

        return adminRepository.getAllCourses();
    }


    @Override
    public List<Enrollment> getAllEnrollments() {

        return adminRepository.getAllEnrollments();
    }


    @Override
    public List<Enrollment> getProgressByCourse(Long courseId) {

        return adminRepository.getProgressByCourse(courseId);
    }


    @Override
    public List<Enrollment> getProgressByStudent(Long studentId) {

        return adminRepository.getProgressByStudent(studentId);
    }
}