package com.example.schoolmanagementsystem.Service;

import com.example.schoolmanagementsystem.Api.ApiException;
import com.example.schoolmanagementsystem.Model.Student;
import com.example.schoolmanagementsystem.Repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public List<Student> getStudents()
    {
        return studentRepository.findAll();
    }
    public void addStudent(Student student)
    {
        studentRepository.save(student);
    }
    public void updateStudent(Integer id,Student student)
    {
        Student s = studentRepository.findStudentById(id);
        if(s == null)
        {
            throw new ApiException("It is null");
        }
        s.setName(student.getName());
        s.setMajor(student.getMajor());
        studentRepository.save(s);
    }
    public void deleteStudent(Integer id)
    {
        if(studentRepository.findStudentById(id) == null)
        {
            throw new ApiException("It is null");
        }
        studentRepository.deleteById(id);
    }
}
