package com.pradeep.studentresultportal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/get_info")
    public ResponseEntity getStudent(@RequestParam("id") int admNo){
        Student s = studentService.getStudent(admNo);
        if(s == null){
            return new ResponseEntity("Student Not Found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(s, HttpStatus.ACCEPTED);
    }
    @PostMapping("/add")
    public ResponseEntity addStudent(@RequestBody Student student){
        String st = studentService.addStudent(student);
        return new ResponseEntity(st, HttpStatus.CREATED);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity getStudentByPathVariable(@PathVariable("id") int admNo){
        Student st1 = studentService.getStudentByPathVariable(admNo);
        return new ResponseEntity(st1, HttpStatus.ACCEPTED);
    }
    @GetMapping("/get/{id}/{message}")
    public ResponseEntity getStudentWithMessageByPathVariable(@PathVariable("id") int admNo, @PathVariable("message") String message){
        String st2 = studentService.getStudentWithMessageByPathVariable(admNo, message);
        return new ResponseEntity(st2,HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/delete")
    public ResponseEntity deleteStudent(@RequestParam("id") int admNo){
        String st3 = studentService.deleteStudent(admNo);
        return new ResponseEntity(st3, HttpStatus.OK);
    }
    @PutMapping("/updateCourse")
    public ResponseEntity updateCourse(@RequestParam("id") int admNo, @RequestParam("course") String newCourse){
        Student s = studentService.updateCourse(admNo, newCourse);
        return new ResponseEntity(s, HttpStatus.OK);
    }
    @GetMapping("/getTotalStudents")
    public ResponseEntity getTotalStudents(){
        int n =  studentService.getTotalStudents();
        return new ResponseEntity(n, HttpStatus.ACCEPTED);
    }
}
