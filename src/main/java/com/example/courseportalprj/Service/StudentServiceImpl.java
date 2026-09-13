package com.example.courseportalprj.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.courseportalprj.Model.Student;
import com.example.courseportalprj.Repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Register new student/instructor
    @Override
    public Student insert(Student student) {

        // Encrypt password before saving to database
        student.setPassword(passwordEncoder.encode(student.getPassword()));

        return studentRepository.save(student);
    }

    // Find student/instructor by ID
    @Override
    public Student search(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    // Find student/instructor by email
    @Override
    public Student findByEmail(String email) {
        return studentRepository.findByEmail(email).orElse(null);
    }

    // Update student/instructor
    @Override
    public Student update(Student student) {

        Student s = studentRepository.findById(student.getId()).orElse(null);

        if (s != null) {

            s.setName(student.getName());
            s.setEmail(student.getEmail());

            // Encrypt the new password before saving
            s.setPassword(passwordEncoder.encode(student.getPassword()));

            s.setRole(student.getRole());

            return studentRepository.save(s);
        }

        return null;
    }

    // Get all students/instructors
    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    // Delete student/instructor
    @Override
    public void delete(Long id) {
        studentRepository.deleteById(id);
    }

    // Login
    @Override
    public Student login(String email, String password) {

        Student student = studentRepository.findByEmail(email).orElse(null);

        if (student != null &&
            passwordEncoder.matches(password, student.getPassword())) {

            return student;
        }

        return null;
    }
}