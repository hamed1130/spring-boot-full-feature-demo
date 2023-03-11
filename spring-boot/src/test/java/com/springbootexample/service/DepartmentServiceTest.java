package com.springbootexample.service;

import com.springbootexample.entity.Department;
import com.springbootexample.exception.DepartmentNotFoundByIDException;
import com.springbootexample.exception.DepartmentNotFoundByNameException;
import com.springbootexample.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DepartmentServiceTest {

    /*@Autowired
    Department department;*/
    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() throws DepartmentNotFoundByIDException {
        Department department = Department.builder()
                                .departmentName("IT")
                                .departmentAddress("MTL")
                                .departmentCode("Code-01")
                                .departmentId(1L)
                                .build();

        // creating the object using DI, by adding @Component in Department class and @Autowire it here
        /*department.setDepartmentName("IT");
        department.setDepartmentAddress("MTL");
        department.setDepartmentCode("Code-01");
        department.setDepartmentId(1L);*/

        // or creating the object manually, with setter methods, which is not a good idea, adding just to demo it
        /*Department department = new Department();
        department.setDepartmentName("IT");
        department.setDepartmentAddress("MTL");
        department.setDepartmentCode("Code-01");
        department.setDepartmentId(1L);*/

        Mockito.when(departmentRepository.findByDepartmentNameUsingQuery("IT"))
                .thenReturn(Collections.singletonList(department));
        Mockito.when(departmentRepository.findById(1L))
                .thenReturn(Optional.of(department));
    }

    // testing getDepartmentByName() in service layer
    @Test
    @DisplayName("Testing getDepartmentByName() in service layer.")
    public void whenValidDepartmentName_thenDepartmenrtShouldFound() throws DepartmentNotFoundByNameException {
        String departmentName = "IT";
        List<Department> found = departmentService.getDepartmentByName(departmentName);

        assertEquals(departmentName, found.get(0).getDepartmentName());
    }

    @Test
    @DisplayName("Testing getDepartmentById() in service layer.")
    public void whenValidDepartmentID_thenDepartmenrtShouldFound() throws DepartmentNotFoundByIDException {
        long departmentID = 1L;
        Department found = departmentService.getDepartmentById(departmentID);

        assertEquals(departmentID, found.getDepartmentId());
    }
}