package org.surja.school_management_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.surja.school_management_backend.entity.Student;


public interface StudentRepo extends JpaRepository<Student,Long> {
}
