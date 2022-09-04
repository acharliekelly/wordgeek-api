package com.cantimaginewhy.workgeekapi.exceptions;

public class ScoreNotFoundException extends RuntimeException{
  public ScoreNotFoundException(Long id) {
    super("Could not find WordScore " + id);
  }
}
