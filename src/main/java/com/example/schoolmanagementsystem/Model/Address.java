package com.example.schoolmanagementsystem.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Address {

    @Id
    private Integer id;

    @Column(columnDefinition = "VARCHAR(20) NOT NULL")
    private String area;
    @Column(columnDefinition = "VARCHAR(20) NOT NULL")
    private String street;
    @Column(columnDefinition = "INT NOT NULL")
    private int buildingNumber;

    @OneToOne
    @MapsId
    @JsonIgnore
    private Teacher teacher;

}
