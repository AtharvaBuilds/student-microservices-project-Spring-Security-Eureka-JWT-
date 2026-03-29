package com.student.controller;

import com.student.entity.Student;
import com.student.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@CrossOrigin("*")
public class StudentController {

    @Autowired
    private StudentRepo studentRepo;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentRepo.save(student);
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id) {
        studentRepo.deleteById(id);
        return "Deleted Successfully";
    }
}