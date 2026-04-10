package com.vathsav.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.vathsav.backend.model.Student;
import com.vathsav.backend.service.StudentService;

@RestController
@CrossOrigin
@RequestMapping("/students")
public class StudentController {

@Autowired
private StudentService service;

@GetMapping
public List<Student> getAll(){ return service.getAll(); }

@PostMapping
public Student add(@RequestBody Student s){ return service.add(s); }

@PutMapping("/{id}")
public Student update(@PathVariable int id,@RequestBody Student s){
return service.update(id,s);
}

@DeleteMapping("/{id}")
public String delete(@PathVariable int id){
service.delete(id);
return "Deleted";
}
}