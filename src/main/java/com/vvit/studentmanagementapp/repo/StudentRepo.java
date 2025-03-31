package com.vvit.studentmanagementapp.repo;

import com.vvit.studentmanagementapp.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface StudentRepo extends JpaRepository<Student, Integer> {
    Optional<Student> findByEmail(String email); // Updated: Ensure consistency in method naming
}
