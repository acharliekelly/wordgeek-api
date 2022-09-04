package com.codesse.wordgeek;


import java.util.*;

public class TestUtils {
    
    public static List<String> testWords() {
        return new ArrayList<>(Arrays.asList(new String[]{
                "all", "word", "woolly", "adder", "really",
                "long", "dally", "wall", "real", "aardvark",
                "aardwolves", "aasvogels", "abase", "abash",
                "abuse", "abate", "abattoir", "bash", "base",
                "bias", "biased"
        }));
    }

    public static List<String> testPlayers() {
        return new ArrayList<>(Arrays.asList(new String[]{
                "player1", "player2", "player3", "player4", "player5", "player6"
        }));
    }
    
    public static LeaderBoard loadLeaderboard() {
        List<String> words = testWords();
        List<String> players = testPlayers();
        LeaderBoard board = LeaderBoard.getInstance();
        board.clear();
        int w = 0;
        int p = 0;
        while (w < LeaderBoard.MAX_SIZE) {
            if (p == players.size())
                p = 0;
            String word = words.get(w);
            board.addEntry(players.get(p), word, word.length());
            w++;
            p++;
        }
        return board;
    }
}
