package com.cantimaginewhy.workgeekapi.controllers;

import java.util.List;
import java.util.Optional;

import com.cantimaginewhy.workgeekapi.repositories.GameRepository;
import com.cantimaginewhy.workgeekapi.exceptions.GameNotFoundException;
import com.cantimaginewhy.workgeekapi.models.Game;

import org.springframework.web.bind.annotation.*;


@RestController
public class GameController {
  private final GameRepository repository;

  public GameController(GameRepository repository) {
    this.repository = repository;
  }

  // Aggregate root
  // tag::get-aggregate-root[]
  @GetMapping("/games")
  public List<Game> allGames() {
    return repository.findAll();
  }

  @PostMapping("/games")
  public Game newGame(@RequestBody Game game) {
    return repository.save(game);
  }

  // single item
  @GetMapping("/games/{id}")
  public Game getOneGame(@PathVariable Long id) {
    Optional<Game> oGame = repository.findById(id);
    if (oGame.isPresent())
      return oGame.get();
    else
      throw new GameNotFoundException(id);
  }

  @PutMapping("/games/{id}")
  public Game replaceGame(@RequestBody Game newGame, @PathVariable Long id) {
    return repository.findById(id)
      .map(game -> {
        game.setStartingWord(newGame.getStartingWord());
        game.setLeaderBoard(newGame.getLeaderBoard());
        return repository.save(game);
      })
      .orElseGet(() -> {
        newGame.setId(id);
        return repository.save(newGame);
      });
  }

  @DeleteMapping("/games/{id}")
  public void deleteGame(@PathVariable Long id) {
    repository.deleteById(id);
  }
}
