package com.shaikh.app.rest.Controller;
import com.shaikh.app.rest.Models.Student;
import com.shaikh.app.rest.Repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiController {

    @Autowired
    private StudentRepo studentRepo;
    @GetMapping(value = "/")
    public String getPage(){
        return "Welcome";
    }

    @GetMapping(value = "/student")
    public List<Student> getStudent()
    {
        return studentRepo.findAll();
    }
    @PostMapping(value = "/save")
    public String saveStudent(@RequestBody Student student){
        studentRepo.save(student);
        String s = "Saved..";
        return s;
    }

    @PutMapping(value = "update/{id}")
    public String updateStudent(@PathVariable  int id, @RequestBody Student student)
    {
        Student updatedStudent= studentRepo.findById(id).get();
        updatedStudent.setFirstname(student.getFirstname());
        updatedStudent.setLastname(student.getLastname());
        updatedStudent.setMarks(student.getMarks());
        studentRepo.save(updatedStudent);
        return "Updated..";
    }

    @DeleteMapping(value = "delete/{id}")
    public String deleteStudent(@PathVariable int id){
        Student deleteStudent= studentRepo.findById(id).get();
        studentRepo.delete(deleteStudent);
        return "Delete student with id:"+id;
    }

}
