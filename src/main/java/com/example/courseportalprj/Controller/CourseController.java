package com.example.courseportalprj.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.courseportalprj.Model.Course;
import com.example.courseportalprj.Model.Student;
import com.example.courseportalprj.Service.CourseService;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;


    

    @PostMapping
    public Course addCourse(@RequestBody Course course) {

        return courseService.insert(course);
    }



    @GetMapping
    public List<Course> getAllCourses() {

        return courseService.getAll();
    }


    
    @GetMapping("/{id}")
    public Course getCourseById(
            @PathVariable Long id) {

        return courseService.search(id);
    }


    
    @PutMapping
    public Course updateCourse(
            @RequestBody Course course) {

        return courseService.update(course);
    }



    @DeleteMapping("/{id}")
    public void deleteCourse(
            @PathVariable Long id) {

        courseService.delete(id);
    }


   

    @GetMapping("/instructor/{instructorId}")
    public List<Course> getCoursesByInstructor(
            @PathVariable Long instructorId) {

        Student instructor = new Student();
        instructor.setId(instructorId);

        return courseService.getByInstructor(instructor);
    }
}