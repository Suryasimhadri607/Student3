package com.vvit.studentmanagementapp.controller;

import com.vvit.studentmanagementapp.dto.StudentDTO;
import com.vvit.studentmanagementapp.dto.StudentSaveDTO;
import com.vvit.studentmanagementapp.dto.StudentUpdateDTO;
import com.vvit.studentmanagementapp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin
@RequestMapping("/api/v1/student")
public class StudentController {
	
    @Autowired
    private StudentService studentService;
   

    @PostMapping( "/save")
    public String saveStudent(@RequestBody StudentSaveDTO studentSaveDTO)
    {
    	
        String stname = studentService.addStudent(studentSaveDTO);
        return stname;
    }
    @GetMapping("/getAllStudents")
    public List<StudentDTO> getAllStudents()
    {
        List<StudentDTO> allStudents = studentService.getAllStudents();
        return allStudents;
    }
    @PutMapping("/update")
    public String updateStudent(@RequestBody StudentUpdateDTO studentUpdateDTO)
    {
        String stname = studentService.StudentUpdate(studentUpdateDTO);
        return stname;
    }
   @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable(value = "id")int id)
    {
        boolean deleteStudent = studentService.deleteStudent(id);
        return "deleted!!!!";
    }
}
