package com.springbootexample.spring.data.jpa.demo.repository;

import com.springbootexample.spring.data.jpa.demo.entity.CourseMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseMaterialRepository extends JpaRepository<CourseMaterial, Long> {
}
