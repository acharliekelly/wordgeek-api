package com.cantimaginewhy.workgeekapi.controllers;


import com.cantimaginewhy.workgeekapi.models.WordEntry;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ActiveGameController {
  
  @GetMapping("/activeGame")
  @ResponseBody
  public WordEntry submitWord(@RequestParam(name="word", required=true) String word) {
    WordEntry wordEntry = new WordEntry("player1", word);
    return wordEntry;
  }

}
