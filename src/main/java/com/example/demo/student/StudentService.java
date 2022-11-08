package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException("No student with id -" + studentId + " exists"));
        return student;
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository
                .findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("Email already registered");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        boolean studentExists = studentRepository.existsById(studentId);
        if (!studentExists) throw new IllegalStateException("Id does not exist");
        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId, String firstName, String lastName, String email) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException("No student with id -" + studentId + " exists"));
        if (firstName != null && !Objects.equals(student.getFirstName(), firstName)) {
            student.setFirstName(firstName);
        }
        if (lastName != null && !Objects.equals(student.getLastName(), lastName)) {
            student.setLastName(lastName);
        }
        if (email != null && !Objects.equals(student.getEmail(), email)) {
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
            if (studentOptional.isPresent()) {
                throw new IllegalStateException("Email already taken");
            }
            student.setEmail(email);
        }

    }
}
