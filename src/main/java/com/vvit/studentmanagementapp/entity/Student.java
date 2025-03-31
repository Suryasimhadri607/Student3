package com.vvit.studentmanagementapp.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "student")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "student_id", length = 20)
    private int studentid;

    @Column(name = "student_name", length = 100)
    private String studentname;

    @Column(name = "address", length = 150)
    private String address;

    @Column(name = "phone", length = 200)
    private String phone;

    @Column(name = "student_email", length = 100)
    private String email;

    @Column(name = "student_password", length = 100)
    private String password;
    
    
    public Student(String studentname, String address, String email, String password, String phone) {
        this.studentname = studentname;
        this.address = address;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }
}
