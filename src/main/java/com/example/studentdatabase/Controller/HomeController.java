package com.example.studentdatabase.Controller;
import com.example.studentdatabase.Model.Student;
import com.example.studentdatabase.Repository.StudentRepository;
import com.example.studentdatabase.Service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import java.util.List;


@Controller
public class HomeController {


    private StudentService ss = new StudentService();


    @GetMapping("/create")
    public String index(){
        return "index";
    }

    @PostMapping("/create")
    public String create(WebRequest req){

        if (req.getParameter("name").length() < 1
         || req.getParameter("email").length() < 1
         || req.getParameter("gender").length() < 1) return "index";
        else {
            ss.create(req);
            return "success";
        }
    }
    @PostMapping("/delete")
    public String delete(WebRequest req){
            ss.delete(req);
            return "success";
    }
    @GetMapping("/getAll")
    public String getAll(){

        return ss.getAllStudents().toString();
    }
}
