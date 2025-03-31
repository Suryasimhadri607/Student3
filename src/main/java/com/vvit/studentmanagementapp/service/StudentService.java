package com.vvit.studentmanagementapp.service;

import com.vvit.studentmanagementapp.dto.StudentDTO;
import com.vvit.studentmanagementapp.dto.StudentSaveDTO;
import com.vvit.studentmanagementapp.dto.StudentUpdateDTO;

import java.util.List;

public interface StudentService {
    String addStudent(StudentSaveDTO studentSaveDTO);

    String StudentUpdate(StudentUpdateDTO studentUpdateDTO);

    List<StudentDTO> getAllStudents();

    boolean deleteStudent(int id);
}
