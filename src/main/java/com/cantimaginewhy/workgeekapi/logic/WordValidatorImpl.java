package com.cantimaginewhy.workgeekapi.logic;

import java.util.Map;

import com.cantimaginewhy.workgeekapi.exceptions.MissingSeedException;

public class WordValidatorImpl implements WordValidator {

  private Dictionary dictionary;
  private CharacterHash characterHash;


  public WordValidatorImpl(String seedString) {
    dictionary = DictionaryImpl.getInstance();
    characterHash = new CharacterHash(seedString);
  }

  public WordValidatorImpl(Map<Character, Integer> charMap) {
    dictionary = DictionaryImpl.getInstance();
    characterHash = new CharacterHash(charMap);
  }

  @Override
  public String getSeedString() {
    return characterHash.getString();
  }

  @Override
  public boolean isWord(String word) {
    return dictionary.contains(word);
  }

  @Override
  public boolean isAnagram(String testWord) throws MissingSeedException {
    if (characterHash == null)
      throw new MissingSeedException();
    else
      return characterHash.isAnagram(testWord);
  }

  @Override
  public boolean isAnagram(String seedString, String testWord) {
    return CharacterHash.isPermutation(seedString, testWord);
  }

  @Override
  public boolean isAnagram(Map<Character, Integer> charMap, String testWord) {
    return CharacterHash.isPermutation(charMap, testWord);
  }
  
}
