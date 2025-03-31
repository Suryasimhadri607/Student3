package com.vvit.studentmanagementapp.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class TeacherDTO {
	

    private int teacherid;
    private String teachername;
    private String address;
    private String email;
    private String phone;
    private String password;
}
