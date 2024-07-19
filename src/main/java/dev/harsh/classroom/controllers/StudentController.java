package dev.harsh.classroom.controllers;

import dev.harsh.classroom.dtos.StudentRequestDto;
import dev.harsh.classroom.models.Student;
import dev.harsh.classroom.services.IStudentService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/student/")
@RequiredArgsConstructor
public class StudentController {
    private final IStudentService studentService;

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody StudentRequestDto studentRequestDto) {
        Student student = studentService.createStudent(studentRequestDto.toStudent());
        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }

    @GetMapping("{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable UUID id) {
        Student student = studentService.getStudentById(id);
        if(student == null) {
            throw new RuntimeException("Student with id " + id + " not found");
        }
        return ResponseEntity.ok(student);
    }

    @GetMapping("{email}")
    public ResponseEntity<Student> getStudentByEmail(@PathVariable String email) {
        Student student = studentService.getStudentByEmail(email);
        if(student == null) {
            throw new RuntimeException("Student with email " + email + " not found");
        }
        return ResponseEntity.ok(student);
    }

}
