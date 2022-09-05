package com.cantimaginewhy.workgeekapi.advice;

import com.cantimaginewhy.workgeekapi.exceptions.DictionaryException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class DictionaryAdvice {
  
  @ResponseBody
  @ExceptionHandler(DictionaryException.class)
  @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
  public String notInDictionaryHandler(DictionaryException ex) {
    return ex.getMessage();
  }
}
