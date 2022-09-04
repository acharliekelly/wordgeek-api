package com.codesse.wordgeek;

import java.util.Date;

public class LeaderBoardEntry implements Comparable<LeaderBoardEntry> {
    private String playerName;
    private String word;
    private Integer score;
    private Date submittedTime;

    public LeaderBoardEntry(String playerName, String word, Integer score) {
        this.playerName = playerName;
        this.word = word;
        this.score = score;
        this.submittedTime = new Date();
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Date getSubmittedTime() {
        return submittedTime;
    }

    public void setSubmittedTime(Date submittedTime) {
        this.submittedTime = submittedTime;
    }

    /**
     * First entry should be highest score and earliest timestamp
     * @param otherEntry the object to be compared.
     * @return comparison value
     */
    public int compareTo(LeaderBoardEntry otherEntry) {
        if (score.equals(otherEntry.getScore()))
            return submittedTime.compareTo(otherEntry.getSubmittedTime());
        else
            return score.compareTo(otherEntry.getScore()) * -1;
    }


}
