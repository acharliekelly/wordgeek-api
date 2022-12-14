package com.cantimaginewhy.workgeekapi.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


import java.util.Date;

@Entity
public class WordEntry implements Comparable<WordEntry> {
  private @Id @GeneratedValue Long id; 
  private Date timestamp;
  private String playerName;
  private String word;
  private int score;


  public WordEntry() {}

  public WordEntry(String playerName, String word) {
    this.playerName = playerName;
    this.word = word;
    this.timestamp = new Date();
    this.score = word.length();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Date getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Date timestamp) {
    this.timestamp = timestamp;
  }

  public String getPlayerName() {
    return playerName;
  }

  public void setPlayerName(String playerName) {
    this.playerName = playerName;
  }

  public String getWord() {
    return word;
  }

  public void setWord(String word) {
    this.word = word;
  }

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }

  public boolean isValid() {
    return (score > 0);
  }


  @Override
  public int compareTo(WordEntry otherEntry) {
    if (this.score == otherEntry.getScore()) {
      return this.timestamp.compareTo(otherEntry.getTimestamp());
    } else {
      return Integer.valueOf(this.score).compareTo(otherEntry.getScore());
    }
  }

}
