package com.example.schoolmanagementsystem.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "name should not be null")
    @Column(columnDefinition = "VARCHAR(20) NOT NULL")
    private String name;

    @NotEmpty(message = "major should not be null")
    @Column(columnDefinition = "VARCHAR(20) NOT NULL")
    private String major;

    @ManyToMany(cascade = CascadeType.ALL,mappedBy = "students")
    private Set<Course> courses;
}
