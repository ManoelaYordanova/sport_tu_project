package com.example.sport_tu.repositories;

import com.example.sport_tu.entities.teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TeacherRepository extends JpaRepository <teacher,Long> {

    @Query("SELECT t FROM teacher t WHERE lower(t.firstName) = :name")
    List<teacher> findTeachersByFirstName(String name);

    @Query("SELECT t FROM teacher t WHERE  lower(t.email) = :email")
    Optional<teacher> findByEmail(String email);

    teacher findTeacherById(Long id);
}
