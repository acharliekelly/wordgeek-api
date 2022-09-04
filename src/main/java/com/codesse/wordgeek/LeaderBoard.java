package com.codesse.wordgeek;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LeaderBoard {

    public static final int MAX_SIZE = 10;
    private static LeaderBoard leaderBoard = new LeaderBoard();

    /**
     * Get the singleton instance
     * @return the Leaderboard instance
     */
    public static LeaderBoard getInstance() {
        return leaderBoard;
    }


    private List<LeaderBoardEntry> entries;

    private LeaderBoard() {
        entries = new ArrayList<>();
    }

    /**
     * Check if word on list, add entry
     * this method ignores whether max size is reached
     * @param playerName
     * @param word
     * @param score
     */
    public void addEntry(String playerName, String word, int score) {
        // check if word already on list
        if (!containsWord(word)) {
            // if not, add entry
            LeaderBoardEntry entry = new LeaderBoardEntry(playerName, word, score);
            entries.add(entry);
        }
    }

    /**
     * Reset list
     */
    public void clear() {
        entries.clear();
    }

    /**
     * Trim extra entries
     */
    public void trim() {
        if (entries.size() > MAX_SIZE) {
            entries = entries.subList(0, MAX_SIZE-1);
        }
    }

    /**
     * Get sorted top 10 list
     * @return top 10 entries
     */
    public List<LeaderBoardEntry> getList() {
        entries = entries.stream()
                .sorted()
                .collect(Collectors.toList());
        if (entries.size() > MAX_SIZE)
            return entries.subList(0, MAX_SIZE-1);
        else
            return entries;
    }

    private boolean containsWord(String word) {
         return entries
                .stream()
                .filter(entry -> entry.getWord().equals(word))
                 .findAny().isPresent();
    }


}
