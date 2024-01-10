package com.springjpa.spring.repository;

import com.springjpa.spring.entity.Course;
import com.springjpa.spring.entity.Student;
import com.springjpa.spring.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CourseRepositoryTest {
    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printAllCourses(){
        List<Course> courses =
                courseRepository.findAll();
        System.out.println(courses);
    }
    @Test
    public void saveCourseWithTeacher(){
        Teacher teacher = Teacher.builder()
                .firstName("Prof")
                .lastName("Jawad")
                .build();
        Course course = Course.builder()
                .title("DSA")
                .credit(3)
                .teacher(teacher)
                .build();
        courseRepository.save(course);
    }
    @Test
    public void saveCourseWithTeacherAndStudent(){
        Teacher teacher = Teacher.builder()
                .firstName("Kunal")
                .lastName("Kushwaha")
                .build();
        Student student = Student.builder()
                .firstName("Hasnain")
                .lastName("Zafar")
                .emailId("hk@gmail.com")
                .build();
        Course course = Course.builder()
                .title("Java")
                .credit(10)
                .teacher(teacher)
                .students(List.of(student))
                .build();
        courseRepository.save(course);
    }
    @Test
    public void findAllPagination(){
        Pageable firstPageWithThreeRecords =
                PageRequest.of(0,3);
        Pageable secondPageWithTwoRecords =
                PageRequest.of(1,2);
        List<Course> courses =
                courseRepository
                        .findAll(firstPageWithThreeRecords)
                        .getContent();
        System.out.println(courses);
        long totalElements =
                courseRepository.findAll(firstPageWithThreeRecords)
                        .getTotalElements();
        System.out.println(totalElements);

        long totalPages =
                courseRepository.findAll(firstPageWithThreeRecords)
                        .getTotalPages();
        System.out.println(totalPages);
    }
    @Test
    public void findAllSorting(){
        Pageable sortByTitle =
                PageRequest.of(
                        0,
                        2,
                        Sort.by("title")
                );
        Pageable sortByCreditDsc =
                PageRequest.of(
                        0,
                        2,
                        Sort.by("credit").descending()
                );
        Pageable sortByTitleAndCredit =
                PageRequest.of(
                        0,
                        2,
                        Sort.by("title")
                                .descending()
                                .and(Sort.by("credit"))
                );
        List<Course> courses =
                courseRepository.findAll(sortByTitle).getContent();
        System.out.println(courses);
    }
}