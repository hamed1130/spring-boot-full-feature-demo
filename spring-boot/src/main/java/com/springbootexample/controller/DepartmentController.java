package com.springbootexample.controller;

import com.springbootexample.entity.Department;
import com.springbootexample.exception.DepartmentNotFoundByIDException;
import com.springbootexample.exception.DepartmentNotFoundByNameException;
import com.springbootexample.service.DepartmentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {
    // di for service component
    @Autowired
    private DepartmentService departmentService;

    // logging functionality
    private final Logger logger = LoggerFactory.getLogger(DepartmentController.class);

    // add new department
    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department) {
        // without DI I have to:
        //IDepartmentService service = new DepartmentServiceImpl();
        logger.info("Incoming POST: " + department.toString());
        return departmentService.saveDepartment(department);
    }

    // get all departments
    @GetMapping("/departments")
    public List<Department> getDepartments() {
        logger.info("Incoming GET, all departments");
        return departmentService.getDepartments();
    }

    // get a department by id
    @GetMapping("/department/{id}")
    //@RequestMapping("{id}")
    public Department getDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundByIDException {
        logger.info("Incoming GET, get department by id: " + departmentId);
        return departmentService.getDepartmentById(departmentId);
    }

    // delete a department by id
    @DeleteMapping("/department/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundByIDException {
        logger.info("Incoming DELETE, delete department by id: " + departmentId);
        departmentService.deleteDepartmentById(departmentId);
        return "Department delete request executed!";
    }

    // update a department by id, and sending department to be updated
    @PutMapping("/department/{id}")
    public Department updateDepartmentById(@RequestBody Department department, @PathVariable("id") Long departmentId) throws DepartmentNotFoundByIDException {
        logger.info("Incoming PUT, updating department by id");
        return departmentService.updateDepartmentById(departmentId, department);
    }

    // get a department by name
    @GetMapping("/department/name/{name}")
    public List<Department> getDepartmentByName(@PathVariable("name") String departmentName) throws DepartmentNotFoundByNameException {
        logger.info("Incoming GET, get department by name: " + departmentName);
        return departmentService.getDepartmentByName(departmentName);
    }
}
