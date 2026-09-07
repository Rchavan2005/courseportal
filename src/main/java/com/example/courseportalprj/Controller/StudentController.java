package com.example.courseportalprj.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.courseportalprj.Model.Student;
import com.example.courseportalprj.Service.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;
    
    @PostMapping("/login")
    public Student login(@RequestBody Student loginRequest) {
        return studentService.login(loginRequest.getEmail(), loginRequest.getPassword());
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentService.insert(student);
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAll();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.search(id);
    }

    @PutMapping
    public Student updateStudent(@RequestBody Student student) {
        return studentService.update(student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.delete(id);
    }
}