package com.cantimaginewhy.workgeekapi.logic;

import java.util.Map;

import com.cantimaginewhy.workgeekapi.exceptions.MissingSeedException;

public interface WordValidator {
  public boolean isWord(String word);
  public boolean isAnagram(String testWord) throws MissingSeedException;
  public boolean isAnagram(String seedString, String testWord);
  public boolean isAnagram(Map<Character, Integer> charMap, String testWord);
  public String getSeedString();
}
