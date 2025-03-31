package com.vvit.studentmanagementapp.service.IMPL;

import com.vvit.studentmanagementapp.dto.StudentDTO;
import com.vvit.studentmanagementapp.dto.StudentSaveDTO;
import com.vvit.studentmanagementapp.dto.StudentUpdateDTO;
import com.vvit.studentmanagementapp.entity.Student;
import com.vvit.studentmanagementapp.repo.StudentRepo;
import com.vvit.studentmanagementapp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceIMPL implements StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Override
    public String addStudent(StudentSaveDTO studentSaveDTO) {

        Student student = new Student(
                studentSaveDTO.getStudentname(),
                studentSaveDTO.getAddress(),
                studentSaveDTO.getEmail(),
                studentSaveDTO.getPassword(),
                studentSaveDTO.getPhone()
        );
        studentRepo.save(student);

        return student.getStudentname();
    }

    @Override
    public String StudentUpdate(StudentUpdateDTO studentUpdateDTO) {
    	
    	 // Find the student by ID
        Optional<Student> optionalStudent = studentRepo.findById(studentUpdateDTO.getStudentid());

        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();

            // ✅ Updating student details correctly
            student.setStudentname(studentUpdateDTO.getStudentname());
            student.setAddress(studentUpdateDTO.getAddress());
            student.setPhone(studentUpdateDTO.getPhone());
            student.setEmail(studentUpdateDTO.getEmail());
            student.setPassword(studentUpdateDTO.getPassword());

            // ✅ Saving updated student
            studentRepo.save(student);
            return student.getStudentname(); 
        }
		return "Student not found";
    }
    	

    @Override
    public List<StudentDTO> getAllStudents() {
        List<Student> students = studentRepo.findAll();  // ✅ Fetch all students from DB
        return students.stream().map(student -> new StudentDTO(
                student.getStudentid(),
                student.getStudentname(),
                student.getAddress(),
                student.getPhone(),
                student.getEmail(),
                student.getPassword()  // ✅ Include password field
        )).collect(Collectors.toList());  // ✅ Convert Student entity to StudentDTO
    }




    @Override
    public boolean deleteStudent(int id) {
        if (studentRepo.existsById(id)) {  // ✅ Check if student exists
            studentRepo.deleteById(id);  // ✅ Delete the student
            return true;
        }
        return false;  
    }
}
