package com.vvit.studentmanagementapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vvit.studentmanagementapp.entity.Teacher;
import java.util.Optional; // Added: Import for Optional

public interface TeacherRepo extends JpaRepository<Teacher, Integer> {
    Optional<Teacher> findByEmail(String email); // Updated: Added method to find by email
}
