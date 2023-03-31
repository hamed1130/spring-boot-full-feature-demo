package com.springbootexample.spring.data.jpa.demo.repository;

import com.springbootexample.spring.data.jpa.demo.entity.Course;
import com.springbootexample.spring.data.jpa.demo.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCoursesTest() {
        List<Course> courseList = courseRepository.findAll();
        System.out.println("Courses: " + courseList);
    }

    @Test
    public void saveCourseWithTeacher() {
        Teacher teacher = Teacher.builder()
                .firstName("test teacher firstname")
                .lastName("test teacher lastname")
                .build();

        Course course = Course.builder()
                .title("new course with teacher")
                .credit(2)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }

    @Test
    public void findAllPaginationTest() {
        Pageable firstPageWith3Records = PageRequest.of(0, 3);
        Pageable firstPageWith2Records = PageRequest.of(0, 2);

        List<Course> courses = courseRepository.findAll(firstPageWith3Records).getContent();
        long totalElements = courseRepository.findAll(firstPageWith3Records).getTotalElements();
        int totalpages = courseRepository.findAll(firstPageWith3Records).getTotalPages();

        System.out.println("Courses: " + courses);
        System.out.println("totalElements: " + totalElements);
        System.out.println("totalpages: " + totalpages);
    }

    @Test
    public void findAllSortingTest() {
        Pageable sortByTitle = PageRequest.of(0, 2, Sort.by("title"));
        Pageable sortByCreditDesc = PageRequest.of(0, 2, Sort.by("credit").descending());
        Pageable sortByTitleAndCreditDesc = PageRequest.of(0, 2, Sort.by("title").descending().and(Sort.by("credit")));

        List<Course> courses = courseRepository.findAll(sortByTitle).getContent();

        System.out.println("Sorted courses: " + courses);
    }

    @Test
    public void findByTitleContainingTest() {
        Pageable firstPageWith10Records = PageRequest.of(0, 10);

        List<Course> courses = courseRepository.findByTitleContaining("D", firstPageWith10Records).getContent();

        System.out.println("Courses containing 'D': " + courses);
    }
}
