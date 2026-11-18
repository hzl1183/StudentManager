package com.llc.StudentManager.service.impl;

import com.llc.StudentManager.dto.StudentDto;

import java.util.List;

public interface StudentService {
    StudentDto createStudent(StudentDto studentDto);
    StudentDto getStudentById(Long id);
    List<StudentDto> getAllStudents();
    StudentDto updateStudent(Long id, StudentDto studentDto);
    StudentDto deleteStudent(Long id);
}
