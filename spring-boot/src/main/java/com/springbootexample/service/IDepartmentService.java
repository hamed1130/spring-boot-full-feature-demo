package com.springbootexample.service;

import com.springbootexample.entity.Department;
import com.springbootexample.exception.DepartmentNotFoundByIDException;
import com.springbootexample.exception.DepartmentNotFoundByNameException;

import java.util.List;

public interface IDepartmentService {
    Department saveDepartment(Department department);

    List<Department> getDepartments();

    Department getDepartmentById(Long id) throws DepartmentNotFoundByIDException;

    void deleteDepartmentById(Long id) throws DepartmentNotFoundByIDException;

    Department updateDepartmentById(Long departmentId, Department department) throws DepartmentNotFoundByIDException;

    List<Department> getDepartmentByName(String departmentName) throws DepartmentNotFoundByNameException;
}
