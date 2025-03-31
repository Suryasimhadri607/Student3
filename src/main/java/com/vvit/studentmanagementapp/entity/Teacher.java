package com.vvit.studentmanagementapp.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "teacher")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "teacher_id", length = 20)
    private int teacherid;

    @Column(name = "teacher_name", length = 100)
    private String teachername;

    @Column(name = "address", length = 150)
    private String address;

    @Column(name = "phone", length = 200)
    private String phone;

    @Column(name = "teacher_email", length = 100)
    private String email;

    @Column(name = "teacher_password", length = 100)
    private String password;

    // Custom constructor (without ID)
    public Teacher(String teachername, String address, String email, String password, String phone) {
        this.teachername = teachername;
        this.address = address;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }
}
