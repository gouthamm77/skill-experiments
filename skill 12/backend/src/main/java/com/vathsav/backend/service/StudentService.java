package com.vathsav.backend.service;

import java.util.*;
import org.springframework.stereotype.Service;
import com.vathsav.backend.model.Student;

@Service
public class StudentService {

private List<Student> students = new ArrayList<>();

public List<Student> getAll(){ return students; }

public Student add(Student s){ students.add(s); return s; }

public Student update(int id, Student newS){
for(Student s:students){
if(s.getId()==id){
s.setName(newS.getName());
s.setEmail(newS.getEmail());
s.setCourse(newS.getCourse());
return s;
}}
return null;
}

public boolean delete(int id){
return students.removeIf(s->s.getId()==id);
}
}