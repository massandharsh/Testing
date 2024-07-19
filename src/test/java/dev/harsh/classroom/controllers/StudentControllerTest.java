package dev.harsh.classroom.controllers;


import dev.harsh.classroom.services.IStudentService;
import dev.harsh.classroom.services.StudentService;
import dev.harsh.classroom.services.StudentServiceStub;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Primary;

import static org.mockito.Mockito.when;

@SpringBootTest
public class StudentControllerTest {
    @Autowired
    private StudentController studentController;

    @MockBean
    private StudentServiceStub studentService;

    @Test
    public void ForNoStudentExistWithEmailExceptionShouldBeThrown(){
        when(studentService.getStudentByEmail(ArgumentMatchers.anyString())).thenReturn(null);
        Assertions.assertThrows(RuntimeException.class,()->studentController.getStudentByEmail("test@gmail.com"));
    }

    @Test
    public void ForStudentSavingWithSameEmailSameStudentShouldBeReturned(){

    }
}
