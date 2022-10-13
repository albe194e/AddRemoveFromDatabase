package com.example.studentdatabase.Service;

import com.example.studentdatabase.Model.Student;
import com.example.studentdatabase.Repository.StudentRepository;
import org.springframework.web.context.request.WebRequest;

import java.util.List;

public class StudentService {

    StudentRepository repo = new StudentRepository();

    public List<Student> getAllStudents(){
        return repo.getAllStudents();
    }
    public void delete(WebRequest req){
        String email = req.getParameter("email");

        repo.delete(email);
    }

    public void create(WebRequest req){

        Student student = new Student(
                req.getParameter("name"),
                req.getParameter("email"),
                req.getParameter("gender"));
        repo.create(student);
    }
}
