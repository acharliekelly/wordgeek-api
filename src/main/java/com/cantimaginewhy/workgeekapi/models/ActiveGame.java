package com.cantimaginewhy.workgeekapi.models;

import com.cantimaginewhy.workgeekapi.logic.CharacterHash;
import com.cantimaginewhy.workgeekapi.logic.WordValidator;
import com.cantimaginewhy.workgeekapi.logic.WordValidatorImpl;
import com.codesse.wordgeek.WordGeek;

public class ActiveGame extends Game implements WordGeek {
  private CharacterHash charHash;

  public ActiveGame() {
    super();
  }

  public void initializeSeed() {
    charHash = new CharacterHash();
  }

  public void initializeSeed(int seedLength) {
    charHash = new CharacterHash(seedLength);
  }

  public boolean validate(WordValidator validator, String word) {
    return (validator.isWord(word) && validator.isAnagram(charHash.getCharacterMap(), word));
  }

  public boolean validate(String word) {
    WordValidator validator = new WordValidatorImpl(charHash.getCharacterMap());
    return validate(validator, word);
  }

  @Override
  public int submitWord(String playerName, String word) {
    if (validate(word)) {
      WordEntry entry = new WordEntry(playerName, word);
      this.entryList.add(entry);
      return entry.getScore();
    }
    return 0;
  }

  @Override
  public String getPlayerNameAtPosition(int position) {
    return getEntry(position).getPlayerName();
  }

  @Override
  public String getWordEntryAtPosition(int position) {
    return getEntry(position).getWord();
  }

  @Override
  public Integer getScoreAtPosition(int position) {
    return getEntry(position).getScore();
  }
}
