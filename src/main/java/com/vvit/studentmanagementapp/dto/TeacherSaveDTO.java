package com.vvit.studentmanagementapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class TeacherSaveDTO {
	
    private String teachername;
    private String address;
    private String email;
    private String password;
    private String phone;

}
