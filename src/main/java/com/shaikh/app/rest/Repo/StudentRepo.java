package com.shaikh.app.rest.Repo;


import com.shaikh.app.rest.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Integer> {

}
