package com.example.schoolmanagementsystem.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "name should not be empty")
    @Column(columnDefinition = "VARCHAR(20) NOT NULL")
    private String name;

    @NotNull(message = "age should not be null")
    @Positive(message = "age must be positive")
    @Column(columnDefinition = "INT NOT NULL")
    private int age;

    @NotEmpty(message = "email should not be empty")
    @Email(message = "email should be contain an @ sign")
    @Column(columnDefinition = "VARCHAR(20) NOT NULL UNIQUE")
    private String email;

    @Column(columnDefinition = "DOUBLE NOT NULL")
    @NotNull(message = "salary should not be null")
    private double salary;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "teacher")
    @PrimaryKeyJoinColumn
    private Address address;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "teacher")
    private Set<Course> courses;
}
