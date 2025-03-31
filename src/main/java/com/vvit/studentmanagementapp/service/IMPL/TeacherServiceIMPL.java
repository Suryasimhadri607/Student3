package com.vvit.studentmanagementapp.service.IMPL;

import com.vvit.studentmanagementapp.dto.TeacherDTO;
import com.vvit.studentmanagementapp.dto.TeacherSaveDTO;
import com.vvit.studentmanagementapp.dto.TeacherUpdateDTO;
import com.vvit.studentmanagementapp.entity.Teacher;
import com.vvit.studentmanagementapp.repo.TeacherRepo;
import com.vvit.studentmanagementapp.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TeacherServiceIMPL implements TeacherService {

    @Autowired
    private TeacherRepo teacherRepo;

    @Override
    public String addTeacher(TeacherSaveDTO teacherSaveDTO) {
        Teacher teacher = new Teacher(
                teacherSaveDTO.getTeachername(),
                teacherSaveDTO.getAddress(),
                teacherSaveDTO.getEmail(),
                teacherSaveDTO.getPassword(),
                teacherSaveDTO.getPhone()
        );
        teacherRepo.save(teacher);
        return teacher.getTeachername();
    }

    @Override
    public String updateTeacher(TeacherUpdateDTO teacherUpdateDTO) {
        Optional<Teacher> optionalTeacher = teacherRepo.findById(teacherUpdateDTO.getTeacherid());

        if (optionalTeacher.isPresent()) {
            Teacher teacher = optionalTeacher.get();

            teacher.setTeachername(teacherUpdateDTO.getTeachername());
            teacher.setAddress(teacherUpdateDTO.getAddress());
            teacher.setPhone(teacherUpdateDTO.getPhone());
            teacher.setEmail(teacherUpdateDTO.getEmail());
            teacher.setPassword(teacherUpdateDTO.getPassword());

            teacherRepo.save(teacher);
            return teacher.getTeachername();
        }
        return "Teacher not found";
    }

    @Override
    public List<TeacherDTO> getAllTeachers() {
        List<Teacher> teachers = teacherRepo.findAll();
        return teachers.stream().map(teacher -> new TeacherDTO(
                teacher.getTeacherid(),
                teacher.getTeachername(),
                teacher.getAddress(),
                teacher.getEmail(),
                teacher.getPhone(),
                teacher.getPassword()
        )).collect(Collectors.toList());
    }

    @Override
    public boolean deleteTeacher(int id) {
        if (teacherRepo.existsById(id)) {
            teacherRepo.deleteById(id);
            return true;
        }
        return false;
    }
}
