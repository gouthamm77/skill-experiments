package com.klu.studentexceptiondemo.controller;

import com.klu.studentexceptiondemo.exception.*;
import com.klu.studentexceptiondemo.model.Student;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable int id){

        if(id <= 0){
            throw new InvalidInputException("Invalid student ID");
        }

        if(id != 1){
            throw new StudentNotFoundException("Student with ID "+id+" not found");
        }

        return new Student(1,"Rahul","CSE");
    }
}