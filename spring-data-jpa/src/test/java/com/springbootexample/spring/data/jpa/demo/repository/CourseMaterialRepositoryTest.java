package com.springbootexample.spring.data.jpa.demo.repository;

import com.springbootexample.spring.data.jpa.demo.entity.Course;
import com.springbootexample.spring.data.jpa.demo.entity.CourseMaterial;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToOne;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void saveCourseMaterialTest() {
        Course course = Course.builder()
                .title("Data structures and algorithms 2")
                .credit(3)
                .build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.course-demo.com")
                .course(course)
                .build();

        // if cascading does not exist in the repository layer (@OneToOne(cascade = CascadeType.ALL)), this line will fail
        courseMaterialRepository.save(courseMaterial);
    }

    @Test
    public void printAllCourseMaterialsTest() {
        List<CourseMaterial> courseMaterials = courseMaterialRepository.findAll();
        System.out.println("Course Materials: " + courseMaterials);
    }

}