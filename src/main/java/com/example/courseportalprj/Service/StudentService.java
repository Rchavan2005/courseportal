package com.example.courseportalprj.Service;

import java.util.List;
import com.example.courseportalprj.Model.Student;

public interface StudentService {
    Student insert(Student student);
    Student search(Long id);
    Student findByEmail(String email);
    Student update(Student student);
    List<Student> getAll();
    void delete(Long id);
	Student login(String email, String password);
}