package com.example.sport_tu.repositories;

import com.example.sport_tu.entities.Sport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SportsRepo extends JpaRepository<Sport, Long> {
}
