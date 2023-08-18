package com.pradeep.studentresultportal;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class StudentController {

    Map<Integer,Student> studentsDb = new HashMap<>();
    @GetMapping("/get_info")
    public Student getStudent(@RequestParam("id") int admNo){
        return studentsDb.get(admNo);
    }
    @PostMapping("/add")
    public String addStudent(@RequestBody Student student){
        studentsDb.put(student.getAdmNo(),student);
        return "Student Added Successfully";
    }
    @GetMapping("/get/{id}")
    public Student getStudentByPathVariable(@PathVariable("id") int admNo){
        return studentsDb.get(admNo);
    }
    @DeleteMapping("/delete")
    public String deleteStudent(@RequestParam("id") int admNo){
        studentsDb.remove(admNo);
        return "Student Deleted Successfully";
    }
}
