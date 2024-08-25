package com.example.schoolmanagementsystem.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class AddressDTO {

    private Integer teacher_id;

    @NotEmpty(message = "area should not be empty")
    private String area;
    @NotEmpty(message = "street should not be empty")
    private String street;
    @NotNull(message = "buildingNumber should not be empty")
    private int buildingNumber;
}
