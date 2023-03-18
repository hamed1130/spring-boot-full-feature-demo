package com.springbootexample.repository;

import com.springbootexample.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    List<Department> findByDepartmentName(String departmentName);
    List<Department> findByDepartmentNameIgnoreCase(String departmentName);
    @Query(value = "select * from department where department_name = ?1", nativeQuery = true)
    List<Department> findByDepartmentNameUsingQuery(String departmentName);
}
