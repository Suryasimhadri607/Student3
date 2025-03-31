package com.vvit.studentmanagementapp.controller;

import com.vvit.studentmanagementapp.dto.TeacherDTO;
import com.vvit.studentmanagementapp.dto.TeacherSaveDTO;
import com.vvit.studentmanagementapp.dto.TeacherUpdateDTO;
import com.vvit.studentmanagementapp.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @PostMapping("/teachersave")
    public String saveTeacher(@RequestBody TeacherSaveDTO teacherSaveDTO) {
        String teacherName = teacherService.addTeacher(teacherSaveDTO);
        return teacherName;
    }

    @GetMapping("/getAllTeachers")
    public List<TeacherDTO> getAllTeachers() {
        List<TeacherDTO> allTeachers = teacherService.getAllTeachers();
        return allTeachers;
    }

    @PutMapping("/teacherupdate")
    public String updateTeacher(@RequestBody TeacherUpdateDTO teacherUpdateDTO) {
        String teacherName = teacherService.updateTeacher(teacherUpdateDTO);
        return teacherName;
    }

    @DeleteMapping("/teacherdelete/{id}")
    public String deleteTeacher(@PathVariable(value = "id") int id) {
        boolean deleted = teacherService.deleteTeacher(id);
        return deleted ? "Teacher deleted successfully!" : "Teacher not found!";
    }
}
