package com.cantimaginewhy.workgeekapi.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


import java.util.List;
import java.util.ArrayList;

@Entity
public class Game {
  private @Id @GeneratedValue Long id;
  protected List<WordEntry> entryList;
  protected String seed;

  
  public Game() {
    this.entryList = new ArrayList<>();
    this.seed = "";
  }

  public Game(Long id) {
    this.id = id;
    this.entryList = new ArrayList<>();
    seed = "";
  }

  public Game(Long id, String seed) {
    this.id = id;
    this.entryList = new ArrayList<>();
    this.seed = seed;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  protected WordEntry getEntry(int position) {
    return getLeaderBoard().get(position);
  }

  public List<WordEntry> getLeaderBoard() {
    return entryList.stream().sorted().toList();
  }

  public void setLeaderBoard(List<WordEntry> entryList) {
    this.entryList = entryList;
  }

  public String getSeed() {
    return seed;
  }

  public void setSeed(String seed) {
    this.seed = seed;
  }

  
}
