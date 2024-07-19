package dev.harsh.classroom.dtos;

import dev.harsh.classroom.enums.Gender;
import dev.harsh.classroom.models.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequestDto {
    private String name;
    private String email;
    private int rollNo;
    private Gender gender;
    public Student toStudent(){
        return Student.builder()
                .email(email)
                .name(name)
                .gender(gender)
                .rollNo(rollNo)
                .build();
    }
}
