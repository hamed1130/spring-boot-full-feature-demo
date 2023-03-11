package com.springbootexample.controller;

import com.springbootexample.entity.Department;
import com.springbootexample.exception.DepartmentNotFoundByIDException;
import com.springbootexample.repository.DepartmentRepository;
import com.springbootexample.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

// testing controller layer, this layer gets called when user hits the endpoints, so we will hit endspoints to see how they behave, for this we'll be using web mock MVC
@WebMvcTest(DepartmentController.class)
//@ContextConfiguration(classes = DepartmentService.class)
//@AutoConfigureMockMvc
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    private Department department;

    @BeforeEach
    void setUp() {
        department = Department.builder()
                .departmentName("Chemical eng.")
                .departmentAddress("MTL23")
                .departmentCode("Code-03")
                .departmentId(1L)
                .build();
        // manually creating the object
        //department = new Department(1L, "Chemical eng.", "MTL23", "Code-03");
    }

    @Test
    //@DisplayName("Testing saveDepartment() in control layer, which corresponds to POST requests")
    void saveDepartmentTest() throws Exception {
        Department inputDepartment = Department.builder()
                .departmentName("Chemical eng.")
                .departmentAddress("MTL23")
                .departmentCode("Code-03")
                //.departmentId(1L)
                .build();

        Mockito.when(departmentService.saveDepartment(inputDepartment))
                .thenReturn(department);

        mockMvc.perform(MockMvcRequestBuilders.post("/departments")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"departmentName\": \"Chemical eng.\",\n" +
                        "    \"departmentAddress\": \"MTL23\",\n" +
                        "    \"departmentCode\": \"Code-03\"\n" +
                        "}"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void getDepartmentByIdTest() throws Exception {
        Mockito.when(departmentService.getDepartmentById(1L)).thenReturn(department);
        //Mockito.doReturn(department).when(departmentService).getDepartmentById(1L);

        mockMvc.perform(MockMvcRequestBuilders.get("/department/{id}", 1L))
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.departmentName").value(department.getDepartmentName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.departmentAddress").value(department.getDepartmentAddress()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.departmentCode").value(department.getDepartmentCode()));
    }
}