package com.vvit.studentmanagementapp.service;

import com.vvit.studentmanagementapp.dto.TeacherDTO;
import com.vvit.studentmanagementapp.dto.TeacherSaveDTO;
import com.vvit.studentmanagementapp.dto.TeacherUpdateDTO;

import java.util.List;

public interface TeacherService {
    String addTeacher(TeacherSaveDTO teacherSaveDTO);
    List<TeacherDTO> getAllTeachers();
    String updateTeacher(TeacherUpdateDTO teacherUpdateDTO);
    boolean deleteTeacher(int id);
}
