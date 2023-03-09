package com.springbootexample.service;

import com.springbootexample.entity.Department;
import com.springbootexample.exception.DepartmentNotFoundByIDException;
import com.springbootexample.exception.DepartmentNotFoundByNameException;
import com.springbootexample.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.NoSuchElementException;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements IDepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(Long departmentId) throws DepartmentNotFoundByIDException {
        //Department result = departmentRepository.findById(departmentId).get();
        Optional<Department> result = departmentRepository.findById(departmentId);
        if (! result.isPresent()) {
            throw new DepartmentNotFoundByIDException(String.format("Department ID '%s' not found.", departmentId));
        }
        return result.get();
    }

    @Override
    public void deleteDepartmentById(Long departmentId) throws DepartmentNotFoundByIDException {
        // first check if the dep id exists, then delete
        Optional<Department> result = departmentRepository.findById(departmentId);
        if (! result.isPresent()) {
            throw new DepartmentNotFoundByIDException(String.format("Department ID '%s' not found.", departmentId));
        }
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartmentById(Long departmentId, Department department) throws DepartmentNotFoundByIDException {
        // first check if the dep id exists, then proceed with updating it
        Department departmentDB;
        try {
            departmentDB = departmentRepository.findById(departmentId).get();
        } catch (NoSuchElementException e) {
            throw new DepartmentNotFoundByIDException(String.format("Department ID '%s' not found.", departmentId));
        }

        if (Objects.nonNull(department.getDepartmentName()) && ! department.getDepartmentName().equals("")) {
            departmentDB.setDepartmentName(department.getDepartmentName());
        }
        if (Objects.nonNull(department.getDepartmentAddress()) && ! department.getDepartmentAddress().equals("")) {
            departmentDB.setDepartmentAddress(department.getDepartmentAddress());
        }
        if (Objects.nonNull(department.getDepartmentCode()) && ! department.getDepartmentCode().equals("")) {
            departmentDB.setDepartmentCode(department.getDepartmentCode());
        }

        return departmentRepository.saveAndFlush(departmentDB);
    }

    @Override
    public List<Department> getDepartmentByName(String departmentName) throws DepartmentNotFoundByNameException {
        // using method by naming convention:
        //return departmentRepository.findByDepartmentName(departmentName);
        // or by executing sql directly:
        List<Department> result = departmentRepository.findByDepartmentNameUsingQuery(departmentName);
        if (result.isEmpty()) {
            throw new DepartmentNotFoundByNameException(String.format("Department name '%s' not found.", departmentName));
        }
        return departmentRepository.findByDepartmentNameUsingQuery(departmentName);
    }
}
