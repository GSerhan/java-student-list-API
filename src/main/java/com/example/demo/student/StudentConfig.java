//package com.example.demo.student;
//
//import com.example.demo.student.model.Student;
//import com.example.demo.student.repository.StudentRepository;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.time.LocalDate;
//import java.time.Month;
//import java.util.List;
//
//@Configuration
//public class StudentConfig {
//
//    @Bean
//    CommandLineRunner commandLineRunner(StudentRepository repository) {
//        return args -> {
//            Student serhan = new Student(
//                    "Serhan",
//                    "serhanct@gmail.com",
//                    LocalDate.of(1993, Month.JULY, 12)
//            );
//
//            Student sibel = new Student(
//                    "Sibel",
//                    "sibel@gmail.com",
//                    LocalDate.of(1997, Month.JUNE, 18)
//            );
//
//            repository.saveAll(List.of(serhan, sibel));
//        };
//    }
//}
