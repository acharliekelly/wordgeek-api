package com.cantimaginewhy.workgeekapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cantimaginewhy.workgeekapi.models.Game;

public interface GameRepository extends JpaRepository<Game, Long> {
  
}
