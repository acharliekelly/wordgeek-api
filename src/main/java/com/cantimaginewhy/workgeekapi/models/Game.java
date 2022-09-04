package com.cantimaginewhy.workgeekapi.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;
import java.util.ArrayList;

@Entity
public class Game {
  private @Id @GeneratedValue Long id;
  private String startingWord;
  private List<WordScore> leaderBoard;
  
  public Game() {
    this.leaderBoard = new ArrayList<>();
  }

  public Game(Long id, String startingWord) {
    this.id = id;
    this.startingWord = startingWord;
    this.leaderBoard = new ArrayList<>();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getStartingWord() {
    return startingWord;
  }

  public void setStartingWord(String startingWord) {
    this.startingWord = startingWord;
  }

  public List<WordScore> getLeaderBoard() {
    return leaderBoard;
  }

  public void setLeaderBoard(List<WordScore> leaderBoard) {
    this.leaderBoard = leaderBoard;
  }

  
  
}
