package com.example.courseportalprj.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.courseportalprj.Model.Enrollment;
import com.example.courseportalprj.Model.Student;
import com.example.courseportalprj.Repository.EnrollmentRepository;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {

    @Autowired
    private EnrollmentRepository enrollmentRepository;


    
    @Override
    public Enrollment insert(Enrollment enrollment) {

        return enrollmentRepository.save(enrollment);
    }


   
    @Override
    public Enrollment search(Long id) {

        return enrollmentRepository.findById(id).orElse(null);
    }


    @Override
    public Enrollment update(Enrollment enrollment) {

        Enrollment existingEnrollment =
                enrollmentRepository.findById(enrollment.getId())
                .orElse(null);

        if (existingEnrollment != null) {

            
            existingEnrollment.setProgress(enrollment.getProgress());

            
            existingEnrollment.setStatus(enrollment.getStatus());

            return enrollmentRepository.save(existingEnrollment);
        }

        return null;
    }


    
    @Override
    public List<Enrollment> getByStudent(Student student) {

        return enrollmentRepository.findByStudent(student);
    }


    
    @Override
    public List<Enrollment> getAll() {

        return enrollmentRepository.findAll();
    }


    // Delete enrollment
    @Override
    public void delete(Long id) {

        enrollmentRepository.deleteById(id);
    }


    
    @Override
    public List<Enrollment> getByCourseId(Long courseId) {

        return enrollmentRepository.findByCourseId(courseId);
    }
}