package com.example.demo.user.repository;

import com.example.demo.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

//    SELECT * FROM student WHERE EMAIL = ?
//    @Query("SELECT s FROM Student s WHERE s.email = ?1")
    Optional<User> findUserByEmail(String email);
//    Optional<Student> findStudentById(Long id);
}
