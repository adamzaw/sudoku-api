package com.gmail.adam.zawadka.sudoku.API.repository;

import com.gmail.adam.zawadka.sudoku.API.model.Score;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepository extends JpaRepository<Score, Long> {
}
