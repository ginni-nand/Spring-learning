package com.example.demo.student;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StudentService {

    public List<Student> getStudents() {
        return List.of(
                new Student("ginni", "nand", 22, "nandginni@gmail.com", LocalDate.of(2000, 3, 12))
        );
    }
}
