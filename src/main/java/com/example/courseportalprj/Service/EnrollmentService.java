package com.example.courseportalprj.Service;

import java.util.List;

import com.example.courseportalprj.Model.Enrollment;
import com.example.courseportalprj.Model.Student;

public interface EnrollmentService {
 Enrollment insert(Enrollment enrollment);
 Enrollment search(Long id);
 Enrollment update(Enrollment enrollment);
 List<Enrollment> getByStudent(Student student);
 List<Enrollment> getAll();
 void delete(Long id);
 List<Enrollment> getByCourseId(Long courseId);
}