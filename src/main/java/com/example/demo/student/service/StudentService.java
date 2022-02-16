package com.example.demo.student.service;

import com.example.demo.student.model.Student;
import com.example.demo.student.repository.StudentRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());

        if(studentOptional.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if(!exists) {
            throw new IllegalStateException("student with id " + studentId + " does not exists");
        }
        studentRepository.deleteById(studentId);
    }

    @Bean
    public List<Student> retrieveGetMyStudent2() {
        List<Student> myList = new ArrayList<Student>();
        myList.add(        new Student(
                "Sibel",
                "sibel@gmail.com",
                LocalDate.of(1996, Month.JULY, 12)
        ));
        myList.add(        new Student(
                "Serhan",
                "serhanct@gmail.com",
                LocalDate.of(1993, Month.JULY, 12)
        ));

        return myList;
    }

    @Bean(name = "retrieveGetMyStudent")
    public Student retrieveGetMyStudent() {
        return new Student(
                "Serhan",
                "serhanct@gmail.com",
                LocalDate.of(1993, Month.JULY, 12)
        );
    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email) {

        Student selectedStudent = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException("Student with id " + studentId + " does not exists"));

        if(name != null && !Objects.equals(name,"null") && name.length() > 0 && !Objects.equals(name, selectedStudent.getName())) {
            selectedStudent.setName(name);
        } else {
            throw new IllegalStateException("name is the same or null");
        }
        if(email != null && email.length() > 0 && !Objects.equals(email, selectedStudent.getEmail())) {
            Optional <Student> studentOptional = studentRepository.findStudentByEmail(email);
            if(studentOptional.isPresent()) {
                throw new IllegalStateException("email taken! you should reconsider to change to another email");
            }
            selectedStudent.setEmail(email);
        }
    }
}
