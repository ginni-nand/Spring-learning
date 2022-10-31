package com.example.demo.student;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class StudentService {

    public List<Student> getStudents() {
        return List.of(
                new Student(1L, "ginni", 22, LocalDate.of(2000, 3, 12), "nandginni@gmail.com")
        );
    }
}
