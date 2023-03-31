package com.springbootexample.spring.data.jpa.demo.repository;

import com.springbootexample.spring.data.jpa.demo.entity.Guardian;
import com.springbootexample.spring.data.jpa.demo.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
// This annotation helps with testing the repository layer, and once the operation is done it clean up the data, so the database won't be impacted. If you want the changes be saved to the db, remove the annotation.
//@DataJpaTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudentTest() {
        // we can create a new instance using new keyword, but it's not a good idea in terms of DI
        //Student student = new Student();  student.setEmailId("student1@gmail.com"); student.setFirstName("student1"); ...
        Student student = Student.builder()
                .emailId("student1@gmail.com")
                .firstName("student11231")
                .lastName("student1_1")
                //.guardianEmailId("guardian1@gmail.com")
                //.guardianName("guardian1")
                //.guardianPhone("123456789")
                .build();
        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardianTest() {
        Guardian guardian = Guardian.builder()
                .name("new_guardian")
                .email("new_guardian_email@gmail.com")
                .phone("514")
                .build();

        Student student = Student.builder()
                .emailId("student1131@gmail.com")
                .firstName("student11")
                .lastName("student1_1")
                .guardian(guardian)
                .build();
        studentRepository.save(student);
    }

    @Test
    public void printAllStudentsTest() {
        List<Student> studentList = studentRepository.findAll();
        System.out.println(studentList);
    }

    @Test
    public void findByFirstNameTest() {
        List<Student> studentList = studentRepository.findByFirstName("student11");
        System.out.println(studentList);
    }

    @Test
    public void findByNameContainingTest() {
        List<Student> studentList = studentRepository.findByFirstNameContaining("student");
        System.out.println(studentList);
    }

    @Test
    public void findByGuardianNameTest() {
        List<Student> studentList = studentRepository.findByGuardianName("guardian1");
        System.out.println(studentList);
    }

    @Test
    public void findByFirstNameAndLastNameTest() {
        List<Student> studentList = studentRepository.findByFirstNameAndLastName("student1", "student1_1");
        System.out.println(studentList);
    }

    @Test
    public void findByLastNameNotNullTest() {
        List<Student> studentList = studentRepository.findByLastNameNotNull();
        System.out.println(studentList);
    }

    @Test
    public void getStudentByEmailAddressJPQLTest() {
        Student studentList = studentRepository.getStudentByEmailAddressJPQL("student1@gmail.com");
        System.out.println(studentList);
    }

    @Test
    public void getStudentNameByEmailAddressJPQLTest() {
        String studentList = studentRepository.getStudentNameByEmailAddressJPQL("student1@gmail.com");
        System.out.println("Firstname = " + studentList);
    }

    @Test
    public void getStudentByEmailAddressNativeQueryTest() {
        Student studentList = studentRepository.getStudentByEmailAddressNativeQuery("student1@gmail.com");
        System.out.println(studentList);
    }

    @Test
    public void getStudentByEmailAddressNativeQueryNamedParamTest() {
        Student studentList = studentRepository.getStudentByEmailAddressNativeQueryNamedParam("student1@gmail.com");
        System.out.println(studentList);
    }

    @Test
    public void updateStudentNameByEmailIdTest() {
        studentRepository.updateStudentNameByEmailId("student_new", "student1@gmail.com");
    }
}