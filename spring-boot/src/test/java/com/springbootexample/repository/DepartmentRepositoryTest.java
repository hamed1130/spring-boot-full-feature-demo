package com.springbootexample.repository;

import com.springbootexample.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest // by adding this, whatever data we write to the database, will be deleted after test method execution is done. Alternatively, we can use an h2 im-memory database and not to use this annotation with a real database
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentName("Mechanical eng.")
                .departmentAddress("MTL11")
                .departmentCode("Code-02")
                //.departmentId(1L)
                .build();

        testEntityManager.persist(department);
    }

    @Test
    public void whenFindByDepartmentName_thenReturnDepartment() {
        Department department = departmentRepository.findById(1L).get();

        assertEquals(department.getDepartmentName(), "Mechanical eng.");
    }
}