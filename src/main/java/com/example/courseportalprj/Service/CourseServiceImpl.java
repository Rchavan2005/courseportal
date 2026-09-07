package com.example.courseportalprj.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.courseportalprj.Model.Course;
import com.example.courseportalprj.Repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Course insert(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course search(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    @Override
    public Course update(Course course) {
        Course c = courseRepository.findById(course.getId()).orElse(null);
        if (c != null) {
            c.setTitle(course.getTitle());
            c.setDescription(course.getDescription());
            c.setDuration(course.getDuration());
            c.setPrice(course.getPrice());
            c.setInstructor(course.getInstructor());
            return courseRepository.save(c);
        }
        return null;
    }

    @Override
    public List<Course> getAll() {
        return courseRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        courseRepository.deleteById(id);
    }
}