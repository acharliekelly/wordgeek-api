package com.cantimaginewhy.workgeekapi.exceptions;

public class DictionaryException extends RuntimeException {
  public DictionaryException(String entryWord) {
    super("Entered word '" + entryWord + "'' not found in dictionary");
  }
}