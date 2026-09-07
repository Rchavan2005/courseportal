package com.example.courseportalprj.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.courseportalprj.Model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}