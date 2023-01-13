package com.example.lmsbackend.Controllers;

import com.example.lmsbackend.RequestDTOs.StudentRequestDTO;
import com.example.lmsbackend.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/create")
    public ResponseEntity<String> createStudent(@RequestBody()StudentRequestDTO studentRequestDTO){
        studentService.createStudent(studentRequestDTO);
        return new ResponseEntity<>("New student and his card created!", HttpStatus.CREATED);
    }
}
