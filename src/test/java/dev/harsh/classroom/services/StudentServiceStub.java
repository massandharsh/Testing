package dev.harsh.classroom.services;

import dev.harsh.classroom.models.Student;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Component
public class StudentServiceStub implements IStudentService {
    private final Set<Student> students = new HashSet<>();
    @Override
    public Student createStudent(Student student) {
        Student newStudent = new Student();
        newStudent.setEmail(student.getEmail());
        if(students.contains(newStudent)) {
            return students.stream().filter(s -> s.getEmail().equals(student.getEmail())).findFirst().orElse(null);
        }
        students.add(newStudent);
        return newStudent;
    }

    @Override
    public List<Student> getAllStudents() {
        return students.stream().toList();
    }

    @Override
    public Student getStudentById(UUID id) {
        return students.stream().filter(s -> s.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public Student getStudentByEmail(String email) {
        return students.stream().filter(s -> s.getEmail().equals(email)).findFirst().orElse(null);
    }

    @Override
    public Student getStudentByEmailInternal(String email) {
        return students.stream().filter(s -> s.getEmail().equals(email)).findFirst().orElse(null);
    }
}
