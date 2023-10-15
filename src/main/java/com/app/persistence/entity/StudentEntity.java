package com.app.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tb_student")
@Data
public class StudentEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;
}