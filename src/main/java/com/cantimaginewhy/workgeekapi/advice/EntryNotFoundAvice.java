package com.cantimaginewhy.workgeekapi.advice;

import com.cantimaginewhy.workgeekapi.exceptions.EntryNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class EntryNotFoundAvice {
  
  @ResponseBody
  @ExceptionHandler(EntryNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public String entryNotFoundHandler(EntryNotFoundException ex) {
    return ex.getMessage();
  }
}
