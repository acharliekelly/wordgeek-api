package com.cantimaginewhy.workgeekapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class ScoreNotFoundAvice {
  
  @ResponseBody
  @ExceptionHandler(ScoreNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public String scoreNotFoundHandler(ScoreNotFoundException ex) {
    return ex.getMessage();
  }
}
