package com.codesse.wordgeek;


import java.util.HashMap;

/**
 * This is the shell implementation of the WordGeek interface.
 * It is the class that you should focus on when developing your solution to the Challenge.
 */
public class WordGeekImpl implements WordGeek {

    private String startingWord;
    private ValidWords validWords;
    private LeaderBoard leaderBoard;


    public WordGeekImpl(String startingWord, ValidWords validWords) {
        this.startingWord = startingWord;
        this.validWords = validWords;
        this.leaderBoard = LeaderBoard.getInstance();
    }

    /**
     * Submit a word for a player.
     * <p/>
     * A submitted word is accepted if its letters are contained in the starting string that is provided to the game
     * constructor AND if the word is found in the valid words collection in the ValidWords implementation.
     * <p/>
     * If the word is accepted and its score is high enough, the player's submission should be added to the top-ten
     * leaderboard. If there are multiple submissions with the same score, all are accepted, but the first submission with
     * that score should rank higher.
     * <p/>
     * If there are multiple submissions with the same playerName, each should be treated as a separate entry to the game
     * and be recorded independently.
     * <p/>
     * NOTE: This method must be thread-safe; multiple players may be submitting words simultaneously.
     *
     * @param playerName name under which to record the word submission
     * @param word       the player's submitted word. All word submissions may be assumed to be lowercase and contain no
     *                   whitespace or special characters.
     * @return the score for the submitted word. 0 if the word is not accepted.
     */
    @Override
    public int submitWord(String playerName, String word) {
        // check if word is valid
        if (validWords.contains(word) && isPermutation(word)) {

            // get score
            int score = word.length();
            leaderBoard.addEntry(playerName, word, score);
            return score;
        }

        // if not accepted, return 0
        return 0;
    }


    // check if word can be made from startingWord
    public boolean isPermutation(String word) {
        if (word.length() > startingWord.length())
            return false;

        HashMap<Character, Integer> freqMap = charFrequencyMap(startingWord);
        for (int i=0; i<word.length(); i++) {
            char ch = word.charAt(i);
            // if frequency map contains character (starting word contains letter),
            //  decrement character from map copy
            if (freqMap.containsKey(ch) && freqMap.get(ch) > 0) {
                int freq = freqMap.get(ch);
                freqMap.put(ch, --freq);
            } else {
                // otherwise, word contains letters not found in starting word, or too many instances of letter
                return false;
            }

        }

        // if reach end of word and all letters are contained in starting word,
        // then word is permutation of starting word
        return true;

    }


    private HashMap<Character, Integer> charFrequencyMap(String word) {
        HashMap<Character, Integer> charMap = new HashMap<>();
        for (int i=0; i<word.length(); i++) {
            charMap.put(word.charAt(i), charMap.getOrDefault(word.charAt(i),
                    0) + 1);
        }
        return charMap;
    }


    private LeaderBoardEntry getEntryAtPosition(int position) {
        return leaderBoard.getList().get(position);
    }


    /**
     * Return the player name at the supplied position in the leaderboard. 0 being the highest (the best score) and 9 the
     * lowest. You may assume that this method will never be called with position > 9.
     *
     * @param position index in leaderboard
     * @return the player name at the given position in the leaderboard, or null if there is no entry at that position
     */
    @Override
    public String getPlayerNameAtPosition(int position) {
        LeaderBoardEntry entry = getEntryAtPosition(position);
        if (entry != null)
            return entry.getPlayerName();
        else
            return null;
    }

    /**
     * Return the word entry at the supplied position in the leaderboard. 0 being the highest (the best score) and 9 the
     * lowest. You may assume that this method will never be called with position > 9.
     *
     * @param position index on leaderboard
     * @return word entry at given position in the leaderboard, or null if there is no entry at that position
     */
    @Override
    public String getWordEntryAtPosition(int position) {
        LeaderBoardEntry entry = getEntryAtPosition(position);
        if (entry != null)
            return entry.getWord();
        else
            return null;
    }

    /**
     * Return score at given position in the leaderboard, 0 being the highest (best score) and 9 the lowest. You may assume
     * that this method will never be called with position > 9.
     *
     * @param position index in leaderboard
     * @return score at given position in the leaderboard, or null if there is no entry at that position
     */
    @Override
    public Integer getScoreAtPosition(int position) {
        LeaderBoardEntry entry = getEntryAtPosition(position);
        if (entry != null)
            return entry.getScore();
        else
            return null;
    }
}
