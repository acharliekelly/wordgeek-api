package com.cantimaginewhy.workgeekapi.advice;

import com.cantimaginewhy.workgeekapi.exceptions.NonPermutationException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class NonPermutationAdvice {
  
  @ResponseBody
  @ExceptionHandler(NonPermutationException.class)
  @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
  public String nonPermutationHandler(NonPermutationException ex) {
    return ex.getMessage();
  }
}
