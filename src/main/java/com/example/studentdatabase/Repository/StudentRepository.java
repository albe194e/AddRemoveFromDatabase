package com.example.studentdatabase.Repository;

import com.example.studentdatabase.Model.Student;
import com.example.studentdatabase.Service.StudentService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {

    private Connection con = DataConnectionManager.getCon();

    public List<Student> getAllStudents(){

        List<Student> students = new ArrayList<>();
        PreparedStatement stmt;
        try {
            stmt = con.prepareStatement("SELECT * FROM students");

            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()){
                students.add(new Student(
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getString("gender")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }




        return students;
    }

    public void create(Student student){

        try {
            PreparedStatement psts = con.prepareStatement("INSERT INTO students (name,email,gender)values (?,?,?)");
            psts.setString(1,student.getName());
            psts.setString(2,student.getEmail());
            psts.setString(3,student.getGender());

            psts.executeUpdate();

            } catch (SQLException e) {
            e.printStackTrace();
            }
        }
    public void delete(String email){
        try {
            PreparedStatement psts = con.prepareStatement("DELETE FROM students where email = ?");
            psts.setString(1,email);
            psts.execute();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
