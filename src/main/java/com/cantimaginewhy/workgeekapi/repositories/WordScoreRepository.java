package com.cantimaginewhy.workgeekapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cantimaginewhy.workgeekapi.models.WordScore;

public interface WordScoreRepository extends JpaRepository<WordScore, Long> {
  
}
