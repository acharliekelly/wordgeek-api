package com.cantimaginewhy.workgeekapi.exceptions;

public class EntryNotFoundException extends RuntimeException{
  public EntryNotFoundException(Long id) {
    super("Could not find WordScore " + id);
  }
}
