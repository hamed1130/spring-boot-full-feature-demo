package com.springbootexample.spring.data.jpa.demo.repository;

import com.springbootexample.spring.data.jpa.demo.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    // different custom findBy* methods are defined:
    public List<Student> findByFirstName(String firstName);
    public List<Student> findByFirstNameAndLastName(String firstName, String lastName);
    public List<Student> findByFirstNameContaining(String name);
    public List<Student> findByLastNameNotNull();
    public List<Student> findByGuardianName(String guardianName);

    // JPQL query: query database for data using real SQL query (based on the class side entities and NOT database side objects):
    @Query("select s from Student s where s.emailId = ?1")
    Student getStudentByEmailAddressJPQL(String emailId);

    @Query("select s.firstName from Student s where s.emailId = ?1")
    String getStudentNameByEmailAddressJPQL(String emailId);

    // Native query: query database for data using real SQL query (based on the database side objects and NOT class side entities):
    @Query(value = "select * from student where email_address = ?1", nativeQuery = true)
    Student getStudentByEmailAddressNativeQuery(String emailId);

    // Native query and Named Parameter
    @Query(value = "select * from student where email_address = :emailId", nativeQuery = true)
    Student getStudentByEmailAddressNativeQueryNamedParam(@Param("emailId") String emailId);

    // updating database records
    @Modifying
    @Transactional
    @Query(value = "update student set first_name = ?1 where email_address = ?2", nativeQuery = true)
    int updateStudentNameByEmailId(String firstName, String emailId);
}
