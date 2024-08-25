package com.example.schoolmanagementsystem.Service;

import com.example.schoolmanagementsystem.Api.ApiException;
import com.example.schoolmanagementsystem.Model.Teacher;
import com.example.schoolmanagementsystem.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public List<Teacher> getTeachers()
    {
        return teacherRepository.findAll();
    }
    public void addTeacher(Teacher teacher)
    {
        teacherRepository.save(teacher);
    }
    public void updateTeacher(Integer id,Teacher teacher)
    {
        Teacher t = teacherRepository.findTeacherById(id);
        if(t == null)
        {
            throw new ApiException("It is null");
        }
        t.setName(teacher.getName());
        t.setAge(teacher.getAge());
        t.setEmail(teacher.getEmail());
        t.setSalary(teacher.getSalary());
        teacherRepository.save(t);
    }
    public void deleteTeacher(Integer id)
    {
        if(teacherRepository.findTeacherById(id) == null)
        {
            throw new ApiException("It is null");
        }
        teacherRepository.deleteById(id);
    }
}
