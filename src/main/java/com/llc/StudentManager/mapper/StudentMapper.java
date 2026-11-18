package com.llc.StudentManager.mapper;

import com.llc.StudentManager.dto.StudentDto;
import com.llc.StudentManager.entity.Student;

public class StudentMapper {

    public static StudentDto maptoStudentDto(Student student) {
        return new StudentDto(
                student.getId(),
                student.getFirstName(),
                student.getLastName(),
                student.getEmail());
    }

    public static Student mapToStudent(StudentDto studentDto) {
        return new Student(
                studentDto.getId(),
                studentDto.getFirstName(),
                studentDto.getLastName(),
                studentDto.getEmail());
    }

    public static StudentDto mapToStudentDto(Student savedStudent) {
        return new StudentDto(
                savedStudent.getId(),
                savedStudent.getFirstName(),
                savedStudent.getLastName(),
                savedStudent.getEmail());
    }
}
