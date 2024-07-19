package dev.harsh.classroom.models;

import dev.harsh.classroom.enums.Gender;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
@EqualsAndHashCode(of = "email", callSuper = false)
public class Student extends BaseModel{
    private String name;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false,unique = true)
    private int rollNo;
    @Enumerated(EnumType.ORDINAL)
    private Gender gender;
}
