package com.example.schoolmanagementsystem.Service;

import com.example.schoolmanagementsystem.Api.ApiException;
import com.example.schoolmanagementsystem.DTO.AddressDTO;
import com.example.schoolmanagementsystem.Model.Address;
import com.example.schoolmanagementsystem.Model.Teacher;
import com.example.schoolmanagementsystem.Repository.AddressRepository;
import com.example.schoolmanagementsystem.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
    private final TeacherRepository teacherRepository;

    public void addAddressToTeacher(AddressDTO addressDTO)
    {
        Teacher t = teacherRepository.findTeacherById(addressDTO.getTeacher_id());
        if(t == null)
        {
            throw new ApiException("It is null");
        }
        Address a = new Address(null, addressDTO.getArea(), addressDTO.getStreet(), addressDTO.getBuildingNumber(), t);
        addressRepository.save(a);
    }
    public void updateAddress(AddressDTO addressDTO)
    {
        Address a = addressRepository.findAddressById(addressDTO.getTeacher_id());
        if(a == null)
        {
            throw new ApiException("It is null");
        }
        a.setArea(addressDTO.getArea());
        a.setStreet(addressDTO.getStreet());
        a.setBuildingNumber(addressDTO.getBuildingNumber());
        addressRepository.save(a);
    }
    public void deleteAddress(Integer id)
    {
        if(addressRepository.findAddressById(id) == null)
        {
            throw new ApiException("It is null");
        }
        teacherRepository.deleteById(id);
    }
    public Teacher getDetailsTeacher(Integer teacherID)
    {
        if(teacherRepository.findTeacherById(teacherID) == null)
        {
            throw new ApiException("It is null");
        }
        return teacherRepository.findTeacherById(teacherID);
    }
}
