package com.springbootexample.spring.data.jpa.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "course")
public class Course {

    @Id
    @SequenceGenerator(name = "course_sequence", sequenceName = "course_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_sequence")
    private Long courseId;

    private String title;

    private Integer credit;

    // here we don't need to do @JoinColumn() as already did in CourseMaterial entity, below line says that an one-to-one relation is already defined in CourseMaterial on the "course" attribute
    // this way we're actually defining a bi-directional relation between course and course_material tables, for uni-directional we can simply remove the below annotation and field
    @OneToOne(mappedBy = "course")
    private CourseMaterial courseMaterial;

    // between teacher and course entities, we can either define a one-to-many relation in the teacher entity, OR define a many-to-one relation in the course entity, either way
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_id", referencedColumnName = "teacherId")
    private Teacher teacher;

}
