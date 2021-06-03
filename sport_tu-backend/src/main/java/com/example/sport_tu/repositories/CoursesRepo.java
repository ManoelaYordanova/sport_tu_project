package com.example.sport_tu.repositories;

import com.example.sport_tu.entities.Courses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursesRepo extends JpaRepository<Courses, Long> {
}
