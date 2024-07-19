package dev.harsh.classroom.services;

import dev.harsh.classroom.models.Student;

import java.util.List;
import java.util.UUID;

public interface IStudentService {
    Student createStudent(Student student);

    List<Student> getAllStudents();

    Student getStudentById(UUID id);

    Student getStudentByEmail(String email);

    Student getStudentByEmailInternal(String email);
}
