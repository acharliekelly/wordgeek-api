package com.cantimaginewhy.workgeekapi.exceptions;

public class NonPermutationException extends RuntimeException {
  public NonPermutationException(String seedWord, String partialWord) {
    super("\"" + partialWord + "\" cannot be made from the letters in \"" + seedWord + "\"");
  }
}
