package com.cantimaginewhy.workgeekapi.controllers;

import com.cantimaginewhy.workgeekapi.exceptions.DictionaryException;
import com.cantimaginewhy.workgeekapi.exceptions.MissingSeedException;
import com.cantimaginewhy.workgeekapi.exceptions.NonPermutationException;
import com.cantimaginewhy.workgeekapi.logic.WordValidator;


import org.springframework.web.bind.annotation.*;

public class WordController {
  
  private final WordValidator validator;

  public WordController(WordValidator validator) {
    this.validator = validator;
  }


  @GetMapping("/anagram/{word}")
  public String validatePartial(@PathVariable String word) {
    try {
      if (validator.isAnagram(word)) {
        return word;
      } else {
        throw new NonPermutationException(validator.getSeedString(), word);
      }
    } catch (MissingSeedException mse) {
      throw new IllegalArgumentException("Seed missing from character hash", mse);
    }
    
  }

  @GetMapping("/validate/{word}")
  public String validateWord(@PathVariable String word) {
    try {
      if (!validator.isAnagram(word)) {
        throw new NonPermutationException(validator.getSeedString(), word);
      }
      if (!validator.isWord(word)) {
        throw new DictionaryException(word);
      }
      return word;
    } catch (MissingSeedException mse) {
      throw new IllegalArgumentException("Seed missing from character hash", mse);
    }
   
  }
  
}
