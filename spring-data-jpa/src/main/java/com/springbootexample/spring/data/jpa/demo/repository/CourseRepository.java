package com.springbootexample.spring.data.jpa.demo.repository;

import com.springbootexample.spring.data.jpa.demo.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    // custom method: find title containing ...
    Page<Course> findByTitleContaining(String title, Pageable pageRequest);
}
