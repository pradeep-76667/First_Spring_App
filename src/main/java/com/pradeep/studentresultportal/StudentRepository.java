package com.pradeep.studentresultportal;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository

public class StudentRepository {
    Map<Integer,Student> studentsDb = new HashMap<>();

    public Student getStudent(int admNo){
        return studentsDb.get(admNo);
    }

    public String addStudent(Student student) {
        if(studentsDb.containsKey(student.getAdmNo())){
            return "Student already exist";  // checking in repository database for student checking
        }
        studentsDb.put(student.getAdmNo(),student);
        return "Student Added Successfully";
    }

    public Student getStudentByPathVariable(int admNo) {
        return studentsDb.get(admNo);
    }

    public Student getStudentWithMessageByPathVariable(int admNo, String message) {
        return studentsDb.get(admNo);
    }

    public String deleteStudent(int admNo) {
        if(!studentsDb.containsKey(admNo)){
            throw new RuntimeException("Student doesn't exist, can't be deleted");
        }
        studentsDb.remove(admNo);
        return "Student Deleted Successfully";
    }

    public Student updateCourse(int admNo, String newCourse) {
        if(!studentsDb.containsKey(admNo)){
            throw new RuntimeException("Student doesn't exist");
        }
        Student student = studentsDb.get(admNo);
        student.setCourse(newCourse);
        return student;
    }
    public int getTotalStudents() {
        int total = 0;
        for(int admNo : studentsDb.keySet()){
            if(studentsDb.get(admNo).getAge()>25){
                total++;
            }
        }
        return total;
    }
}
