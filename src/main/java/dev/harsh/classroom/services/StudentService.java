package dev.harsh.classroom.services;

import dev.harsh.classroom.models.Student;
import dev.harsh.classroom.repositories.StudentRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StudentService implements IStudentService {
    private final StudentRepository studentRepository;
    @Override
    public Student createStudent(Student student) {
        //Email id should be unique
        Student s = this.getStudentByEmail(student.getEmail());
        if(s == null){
            s = studentRepository.save(student);
        }
        return s;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(UUID id) {
        return studentRepository.findById(id)
                .orElse(null);
    }

    @Override
    public Student getStudentByEmail(String email) {
        return studentRepository.findByEmail(email)
                .orElse(null);
    }

    @Override
    public Student getStudentByEmailInternal(String email) {
        return studentRepository.findByEmail(email)
                .orElse(null);
    }

}
