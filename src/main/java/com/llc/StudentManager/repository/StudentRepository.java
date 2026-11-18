package com.llc.StudentManager.repository;

import com.llc.StudentManager.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
