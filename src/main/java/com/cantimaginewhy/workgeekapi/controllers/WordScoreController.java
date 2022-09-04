package com.cantimaginewhy.workgeekapi.controllers;

import java.util.List;
import java.util.Optional;

import com.cantimaginewhy.workgeekapi.repositories.WordScoreRepository;
import com.cantimaginewhy.workgeekapi.exceptions.ScoreNotFoundException;
import com.cantimaginewhy.workgeekapi.models.WordScore;

import org.springframework.web.bind.annotation.*;

@RestController
public class WordScoreController {
  private final WordScoreRepository repository;

  public WordScoreController(WordScoreRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/scores")
  public List<WordScore> allScores() {
    return repository.findAll();
  }

  @PostMapping("/scores")
  public WordScore addWordScore(@RequestBody WordScore newScore) {
    return repository.save(newScore);
  }

  // single item
  @GetMapping("/scores/{id}")
  public WordScore getOneScore(@PathVariable Long id) {
    Optional<WordScore> oScore = repository.findById(id);
    if (oScore.isPresent())
      return oScore.get();
    else
      throw new ScoreNotFoundException(id);
  }

  @DeleteMapping("/scores/{id}")
  public void deleteScore(@PathVariable Long id) {
    repository.deleteById(id);
  }
}
