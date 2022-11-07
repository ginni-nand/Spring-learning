package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            Student nikhil = new Student("Nikhil", "Verma", 22, "nikhil@gmail.com", LocalDate.of(2000, Month.JANUARY, 31));
            Student rishabh = new Student("Rishabh", "Nand", 27, "rishabh@gmail.com", LocalDate.of(1995, Month.AUGUST, 03));
            studentRepository.saveAll(List.of(nikhil, rishabh));
        };
    }
}
