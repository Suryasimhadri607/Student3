package com.vvit.studentmanagementapp.service;

import com.vvit.studentmanagementapp.entity.Student;
import com.vvit.studentmanagementapp.entity.Teacher;
import com.vvit.studentmanagementapp.repo.StudentRepo;
import com.vvit.studentmanagementapp.repo.TeacherRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final StudentRepo studentRepo;
    private final TeacherRepo teacherRepo;
    private final PasswordEncoder passwordEncoder; 

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Student> studentOpt = studentRepo.findByEmail(email);
        if (studentOpt.isPresent()) {
            Student student = studentOpt.get();
            return new User(student.getEmail(), student.getPassword(), Collections.emptyList());
        }

        Optional<Teacher> teacherOpt = teacherRepo.findByEmail(email);
        if (teacherOpt.isPresent()) {
            Teacher teacher = teacherOpt.get();
            return new User(teacher.getEmail(), teacher.getPassword(), Collections.emptyList());
        }

        throw new UsernameNotFoundException("User not found with email: " + email);
    }

    public Student registerStudent(Student student) {
        student.setPassword(passwordEncoder.encode(student.getPassword())); // Encrypt password before saving
        return studentRepo.save(student);
    }

    public Teacher registerTeacher(Teacher teacher) {
        teacher.setPassword(passwordEncoder.encode(teacher.getPassword())); // Encrypt password before saving
        return teacherRepo.save(teacher);
    }
}
