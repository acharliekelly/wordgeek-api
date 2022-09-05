package com.cantimaginewhy.workgeekapi.exceptions;

public class MissingSeedException extends Exception {
  public MissingSeedException() {
    super("Seed String not set");
  }
}
