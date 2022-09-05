package com.cantimaginewhy.workgeekapi.logic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Random;

public class CharacterHash {

  public final static int DEFAULT_LENGTH = 16;

  private final static String ALPHA = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

  private int listSize;
  private Map<Character, Integer> charMap;

  public CharacterHash() {
    listSize = DEFAULT_LENGTH;
    initHash();
  }

  public CharacterHash(int size) {
    listSize = size;
    initHash();
  }

  public CharacterHash(Map<Character, Integer> charMap) {
    this.charMap = charMap;
    listSize = CharacterHash.asString(charMap).length();
  }

  public CharacterHash(String seed) {
    listSize = seed.length();
    charMap = CharacterHash.asCharMap(seed);
  }

  private void initHash() {
    charMap = new HashMap<>();
    
    for (int i=0; i<listSize; i++) {
      Character ch = randChar();
      if (charMap.containsKey(ch)) {
        charMap.put(ch, charMap.get(ch) + 1);
      } else {
        charMap.put(ch, 1);
      }
    }
  }

  private Character randChar() {
    Random rnd = new Random();
    char ch = ALPHA.charAt(rnd.nextInt(ALPHA.length()));
    return Character.valueOf(ch);
  }


  public boolean isAnagram(String word) {
    Map<Character, Integer> wordMap = CharacterHash.asCharMap(word);
    for (Character ch : wordMap.keySet()) {
      if (charMap.get(ch) == null || charMap.get(ch) < wordMap.get(ch))
        return false;
    }
    return true;
  }

  public Map<Character, Integer> getCharacterMap() {
    return charMap;
  }


  public String getString() {
    return CharacterHash.asString(charMap);
  }

  public List<String> getList() {
    return Arrays.asList(CharacterHash.asString(charMap).split(""));
  }
 


  /* STATIC */


  public static Map<Character, Integer> asCharMap(String str) {
    Map<Character, Integer> charMap = new HashMap<>();
    for (int i=0; i<str.length(); i++) {
      char ch = str.charAt(i);
      if (charMap.get(ch) != null) {
        charMap.put(ch, charMap.get(ch) + 1);
      } else {
        charMap.put(ch, 1);
      }
    }
    return charMap;
  }

  public static String asString(Map<Character, Integer> charMap) {
    String str = "";
    for (Character ch : charMap.keySet()) {
      for (int i=0; i<charMap.get(ch); i++) {
        str += ch;
      }
    }
    return str;
  }

  public static boolean isPermutation(Map<Character, Integer> charMap, String testWord) {
    CharacterHash cHash = new CharacterHash(charMap);
    return cHash.isAnagram(testWord);
  }
  
  public static boolean isPermutation(String seedString, String testWord) {
    CharacterHash cHash = new CharacterHash(seedString);
    return cHash.isAnagram(testWord);
  }

  public static String newSeed() {
    return newSeed(DEFAULT_LENGTH);
  }

  public static String newSeed(int size) {
    CharacterHash cHash = new CharacterHash(size);
    return cHash.getString();
  }
}
