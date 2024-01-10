package com.springjpa.spring.repository;

import com.springjpa.spring.entity.Guardian;
import com.springjpa.spring.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .emailId("hasnainpak@gmail.com")
                .firstName("Hasnain")
                .lastName("Zafar")
//                .guardianName("Zafar Ali")
//                .guardianEmail("Za@gmail.com")
//                .guardianMobile("03068099788")
                .build();
        studentRepository.save(student);
    }
    @Test
    public void printAllStudent(){
        List<Student> studentList =
                studentRepository.findAll();
        System.out.println(studentList);
    }
    @Test
    public void saveStudentWithGuardian(){
        Guardian guardian = Guardian.builder()
                .name("Khan")
                .email("khanS@Gmail.com")
                .mobile("03159637545")
                .build();
        Student student = Student.builder()
                .emailId("sk@gmail.com")
                .firstName("Samim")
                .lastName("Khan")
                .guardian(guardian)
                .build();
        studentRepository.save(student);

    }
    @Test
    public void printStudentByFirstName(){
        List<Student> studentList =
                studentRepository.findByFirstName("samim");
        System.out.println(studentList);
    }
    @Test
    public void printStudentByFirstNameContaining(){
        List<Student> studentList =
                studentRepository.findByFirstNameContaining("has");
        System.out.println(studentList);
    }
    @Test
    public void printStudentBasedOnGuardianName(){
        List<Student> studentList =
                studentRepository.findByGuardianName("Zafar");
        System.out.println(studentList);
    }
    @Test
    public void printStudentByEmailAddress(){
        Student student =
                studentRepository.getStudentByEmailAddress("hasnainpak@gmail.com");
        System.out.println(student);
    }
    @Test
    public void printStudentFirstNameByEmailAddress(){
        String student =
                studentRepository.getStudentFirstNameByEmailAddress("hasnainpak@gmail.com");
        System.out.println(student);
    }
    @Test
    public void printStudentByEmailAddressNative(){
        Student student =
                studentRepository.getStudentByEmailAddressNative("hasnainpak@gmail.com");
        System.out.println(student);

    }
    @Test
    public void printStudentByEmailAddressNamedParam(){
        Student student =
                studentRepository.getStudentByEmailAddressNativeNamedParams("sk@gmail.com");
        System.out.println(student);

    }
    @Test
    public void updateStudentFirstNameByEmailAddress(){
                studentRepository.updateStudentFirstNameByEmailId(
                        "Ayan",
                        "sk@gmail.com");
    }
}