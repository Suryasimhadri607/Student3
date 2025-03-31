package com.vvit.studentmanagementapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentSaveDTO {




    private String studentname;


    private String address;


    private String phone;


    private String email;

    private String password;


}
