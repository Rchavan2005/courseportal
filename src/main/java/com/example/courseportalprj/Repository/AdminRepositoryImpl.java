package com.example.courseportalprj.Repository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.courseportalprj.Model.Course;
import com.example.courseportalprj.Model.Enrollment;
import com.example.courseportalprj.Model.EnrollmentStatus;
import com.example.courseportalprj.Model.Role;
import com.example.courseportalprj.Model.Student;

@Repository
public class AdminRepositoryImpl implements AdminRepository {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private EnrollmentRepository enrollmentRepository;


    @Override
    public long countStudents() {

        return studentRepository.findAll()
                .stream()
                .filter(student -> student.getRole() == Role.STUDENT)
                .count();
    }


    @Override
    public long countInstructors() {

        return studentRepository.findAll()
                .stream()
                .filter(student -> student.getRole() == Role.INSTRUCTOR)
                .count();
    }


    @Override
    public long countCourses() {

        return courseRepository.count();
    }


    @Override
    public long countEnrollments() {

        return enrollmentRepository.count();
    }


    @Override
    public long countCompletedEnrollments() {

        return enrollmentRepository.findAll()
                .stream()
                .filter(enrollment ->
                        enrollment.getStatus() == EnrollmentStatus.COMPLETED)
                .count();
    }


    @Override
    public long countActiveEnrollments() {

        return enrollmentRepository.findAll()
                .stream()
                .filter(enrollment ->
                        enrollment.getStatus() == EnrollmentStatus.ENROLLED)
                .count();
    }


    @Override
    public double getAverageProgress() {

        return enrollmentRepository.findAll()
                .stream()
                .map(Enrollment::getProgress)
                .filter(Objects::nonNull)
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }


    @Override
    public List<Student> getAllStudents() {

        return studentRepository.findAll()
                .stream()
                .filter(student -> student.getRole() == Role.STUDENT)
                .collect(Collectors.toList());
    }


    @Override
    public List<Student> getAllInstructors() {

        return studentRepository.findAll()
                .stream()
                .filter(student -> student.getRole() == Role.INSTRUCTOR)
                .collect(Collectors.toList());
    }


    @Override
    public List<Course> getAllCourses() {

        return courseRepository.findAll();
    }


    @Override
    public List<Enrollment> getAllEnrollments() {

        return enrollmentRepository.findAll();
    }


    @Override
    public List<Enrollment> getProgressByCourse(Long courseId) {

        return enrollmentRepository.findByCourseId(courseId);
    }


    @Override
    public List<Enrollment> getProgressByStudent(Long studentId) {

        Student student = new Student();
        student.setId(studentId);

        return enrollmentRepository.findByStudent(student);
    }
}