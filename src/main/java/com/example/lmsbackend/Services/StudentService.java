package com.example.lmsbackend.Services;

import com.example.lmsbackend.Enums.CardStatus;
import com.example.lmsbackend.Models.Card;
import com.example.lmsbackend.Models.Student;
import com.example.lmsbackend.Repositories.CardRepository;
import com.example.lmsbackend.Repositories.StudentRepository;
import com.example.lmsbackend.RequestDTOs.StudentRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CardService cardService;

    @Autowired
    CardRepository cardRepository;

    public void createStudent(StudentRequestDTO studentRequestDTO){
        //Converting DTO to Entity Object
        Student newStudent= new Student();
        newStudent.setName(studentRequestDTO.getName());
        newStudent.setEmail(studentRequestDTO.getEmail());
        newStudent.setAge(studentRequestDTO.getAge());
        newStudent.setCountry(studentRequestDTO.getCountry());

        Card newCard= new Card();
        newCard.setCardStatus(CardStatus.ACTIVE);
        newCard.setStudent(newStudent);    //for that new foreign key column

        newStudent.setCard(newCard);

        studentRepository.save(newStudent);
        //cardRepository.save(newCard) will automatically be taken care off
    }
}
