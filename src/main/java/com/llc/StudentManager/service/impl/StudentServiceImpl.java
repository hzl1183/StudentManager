package com.llc.StudentManager.service.impl;

import com.llc.StudentManager.dto.StudentDto;
import com.llc.StudentManager.entity.Student;
import com.llc.StudentManager.exception.ResourceNotFoundException;
import com.llc.StudentManager.mapper.StudentMapper;
import com.llc.StudentManager.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

	private StudentRepository studentRepository;

	@Override
	public StudentDto createStudent(StudentDto studentDto) {

		Student student = StudentMapper.mapToStudent(studentDto);
		Student savedStudent = studentRepository.save(student);

		return StudentMapper.mapToStudentDto(savedStudent);
	}

	@Override
	public StudentDto getStudentById(Long id) {
		Student student = studentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));
		return StudentMapper.maptoStudentDto(student);
	}

	@Override
	public List<StudentDto> getAllStudents() {
		List<Student> students = studentRepository.findAll();
		return students.stream()
				.map(StudentMapper::maptoStudentDto)
				.collect(Collectors.toList());
	}

	@Override
	public StudentDto updateStudent(Long id, StudentDto studentDto) {
		Student existingStudent = studentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));

		existingStudent.setFirstName(studentDto.getFirstName());
		existingStudent.setLastName(studentDto.getLastName());
		existingStudent.setEmail(studentDto.getEmail());

		Student updatedStudent = studentRepository.save(existingStudent);
		return StudentMapper.maptoStudentDto(updatedStudent);
	}

	@Override
	public StudentDto deleteStudent(Long id) {
		Student existingStudent = studentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));

		studentRepository.delete(existingStudent);
		return StudentMapper.maptoStudentDto(existingStudent);
	}
}
