package com.example.courseportalprj.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.courseportalprj.Model.Student;
import com.example.courseportalprj.Repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student insert(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student search(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public Student findByEmail(String email) {
        return studentRepository.findByEmail(email).orElse(null);
    }

    @Override
    public Student update(Student student) {
        Student s = studentRepository.findById(student.getId()).orElse(null);
        if (s != null) {
            s.setName(student.getName());
            s.setEmail(student.getEmail());
            s.setPassword(student.getPassword());
            s.setRole(student.getRole());
            return studentRepository.save(s);
        }
        return null;
    }

    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Student login(String email, String password) {
        Student student = studentRepository.findByEmail(email).orElse(null);
        if (student != null && student.getPassword().equals(password)) {
            return student;
        }
        return null;
    }
	
}