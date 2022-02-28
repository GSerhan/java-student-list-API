//package com.example.demo.user;
//
//import com.example.demo.user.model.User;
//import com.example.demo.user.repository.UserRepository;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.time.LocalDate;
//import java.time.Month;
//import java.util.List;
//
//@Configuration
//public class UserConfig {
//
//    @Bean
//    CommandLineRunner commandLineRunner(UserRepository repository) {
//        return args -> {
//            User serhan = new User(
//                    "Serhan",
//                    "serhanct@gmail.com",
//                    LocalDate.of(1993, Month.JULY, 12)
//            );
//
//            User sibel = new User(
//                    "Sibel",
//                    "sibel@gmail.com",
//                    LocalDate.of(1997, Month.JUNE, 18)
//            );
//
//            repository.saveAll(List.of(serhan, sibel));
//        };
//    }
//}
