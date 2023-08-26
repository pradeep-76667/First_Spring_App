package com.pradeep.studentresultportal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public Student getStudent(int admNo){
        //no login was there for this api, if there is logic write here
        return studentRepository.getStudent(admNo);
    }

    public String addStudent(Student student) {
        return studentRepository.addStudent(student);
    }

    public Student getStudentByPathVariable(int admNo) {
        return studentRepository.getStudentByPathVariable(admNo);
    }

    public String getStudentWithMessageByPathVariable(int admNo, String message) {
        return studentRepository.getStudentWithMessageByPathVariable(admNo, message) + message;
    }

    public String deleteStudent(int admNo) {
        return studentRepository.deleteStudent(admNo);
    }

    public Student updateCourse(int admNo, String newCourse) {
        return studentRepository.updateCourse(admNo, newCourse);
    }

    public int getTotalStudents() {
        return studentRepository.getTotalStudents();
    }
}
