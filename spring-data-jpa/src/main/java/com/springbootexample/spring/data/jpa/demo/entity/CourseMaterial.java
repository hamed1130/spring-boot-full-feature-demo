package com.springbootexample.spring.data.jpa.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "course_material")
// this is to be used with LAZY fetching, comment it out when using EAGER fetching
@ToString(exclude = "course")
public class CourseMaterial {

    @Id
    @SequenceGenerator(name = "course_material_sequence", sequenceName = "course_material_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_material_sequence")
    private Long courseMaterialId;

    private String url;
    @OneToOne(
            // cascading is for saving a Course Material (which has an on-to-one relationship with course) for which there's no existing Course, it will automatically inserts the course in the course table as well.
            cascade = CascadeType.ALL,
            // fetching LAZY vs. EAGER:
            // LAZY fetches the child entities lazily (fetches child entities only, without parent)
            // EAGER fetches the child entities along with parent
            fetch = FetchType.LAZY,
            // whenever we try to save a course material, a course will be required (not optional)
            optional = false)
    @JoinColumn(name = "course_id", referencedColumnName = "courseId")
    private Course course;

}
