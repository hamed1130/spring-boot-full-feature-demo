package com.springbootexample.spring.data.jpa.demo.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// using this annotation, framework will not create/relate a separate table to this entity, we are embedding it to the student class (and table in the database)
@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
// this is used to map the class field names to the table columns
@AttributeOverrides({@AttributeOverride(name = "name", column = @Column(name = "guardian_name")),
                     @AttributeOverride(name = "email", column = @Column(name = "guardian_email_id")),
                     @AttributeOverride(name = "phone", column = @Column(name = "guardian_phone"))})
public class Guardian {

    private String name;
    private String email;
    private String phone;
}
