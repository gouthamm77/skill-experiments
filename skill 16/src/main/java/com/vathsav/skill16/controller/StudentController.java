package com.vathsav.skill16.controller;

import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.vathsav.skill16.model.Student;

@RestController
@RequestMapping("/students")
public class StudentController {

private List<Student> list = new ArrayList<>();

@GetMapping
public List<Student> getAll() {
return list;
}

@GetMapping("/{id}")
public Student getById(@PathVariable int id) {
return list.stream().filter(s->s.getId()==id).findFirst().orElse(null);
}

@PostMapping
public Student add(@RequestBody Student s) {
list.add(s);
return s;
}

@PutMapping("/{id}")
public Student update(@PathVariable int id, @RequestBody Student s) {
for(Student st:list){
if(st.getId()==id){
st.setName(s.getName());
st.setEmail(s.getEmail());
st.setCourse(s.getCourse());
return st;
}}
return null;
}

@DeleteMapping("/{id}")
public String delete(@PathVariable int id) {
list.removeIf(s->s.getId()==id);
return "Deleted";
}
}
