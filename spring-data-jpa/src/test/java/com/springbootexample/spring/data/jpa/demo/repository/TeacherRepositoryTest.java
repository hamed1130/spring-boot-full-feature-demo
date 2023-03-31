package com.springbootexample.spring.data.jpa.demo.repository;

import com.springbootexample.spring.data.jpa.demo.entity.Course;
import com.springbootexample.spring.data.jpa.demo.entity.Teacher;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;


    @Test
    public void saveTeacherTest() {
        Course course1 = Course.builder()
                .title("new course 1")
                .credit(1)
                .build();

        Course course2 = Course.builder()
                .title("new course 2")
                .credit(1)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("firstname")
                .lastName("lastname")
                // disabling this test due to removing one-to-many relation defined in teacher entity
                //.courses(List.of(course1, course2))
                .build();

        teacherRepository.save(teacher);
    }
}