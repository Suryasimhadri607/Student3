package com.vvit.studentmanagementapp.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {


    private int studentid;


    private String studentname;


    private String address;


    private String phone;


    private String email;

    private String password;
}
