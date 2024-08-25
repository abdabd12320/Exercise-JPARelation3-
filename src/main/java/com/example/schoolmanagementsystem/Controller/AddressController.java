package com.example.schoolmanagementsystem.Controller;

import com.example.schoolmanagementsystem.Api.ApiResponse;
import com.example.schoolmanagementsystem.DTO.AddressDTO;
import com.example.schoolmanagementsystem.Service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/address")
public class AddressController {

    private final AddressService addressService;

    @PostMapping("/add")
    public ResponseEntity addAddress(@Valid@RequestBody AddressDTO addressDTO)
    {
        addressService.addAddressToTeacher(addressDTO);
        return ResponseEntity.status(200).body(new ApiResponse("address added"));
    }
    @PutMapping("/update")
    public ResponseEntity updateAddress(@Valid@RequestBody AddressDTO addressDTO)
    {
        addressService.updateAddress(addressDTO);
        return ResponseEntity.status(200).body(new ApiResponse("address updated"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteAddress(@PathVariable Integer id)
    {
        addressService.deleteAddress(id);
        return ResponseEntity.status(200).body(new ApiResponse("address deleted"));
    }
    @GetMapping("/get/{id}")
    public ResponseEntity getTeacher(@PathVariable Integer id)
    {
        return ResponseEntity.status(200).body(addressService.getDetailsTeacher(id));
    }
}
