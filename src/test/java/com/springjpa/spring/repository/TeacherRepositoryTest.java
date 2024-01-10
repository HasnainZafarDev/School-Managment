package com.springjpa.spring.repository;

import com.springjpa.spring.entity.Course;
import com.springjpa.spring.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacherWithCourse(){
        Course course1 = Course.builder()
                .title("Insect")
                .credit(3)
                .build();
        Course course2 = Course.builder()
                .title("Bird")
                .credit(5)
                .build();

        //it showing error at .courses bcz we have commented the one to many relation

        Teacher teacher =
                Teacher.builder()
                        .firstName("Sir")
                        .lastName("Zubair")
//                        .courses(List.of(course1,course2))
                        .build();
        teacherRepository.save(teacher);
    }
}