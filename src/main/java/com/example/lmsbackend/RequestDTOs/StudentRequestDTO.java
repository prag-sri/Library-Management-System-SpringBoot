package com.example.lmsbackend.RequestDTOs;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequestDTO {
    @Column(nullable = false)
    private int age;
    @Column(nullable = false)
    private String name;
    @Column(columnDefinition = "varchar(255) default 'India'")
    private String country;
    @Column(name="school_email",unique = true,nullable = false)
    private String email;
}
