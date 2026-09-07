package com.example.courseportalprj.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.courseportalprj.Model.Enrollment;
import com.example.courseportalprj.Model.Student;
import java.util.List;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    List<Enrollment> findByStudent(Student student);

	List<Enrollment> findByCourseId(Long courseId);
}