package com.springbootexample.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Data // for Lombok, that includes: @Getter @Setter @RequiredArgsConstructor @ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder // for Builder pattern
public class DepartmentUsingLombok {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long departmentId;
    @NotBlank(message = "Department name is missing, please add it.") // used for validation, means this field have always to be present in the incoming request
    // other validations avail:
    //@Length(max = 5, min = 1) @Email @Size(max = 5, min = 1) @Positive @Negative @PositiveOrZero @Future @Past @PastOrPresent
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;
}
