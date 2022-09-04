package com.codesse.wordgeek;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class WordGeekTest {

    static final String STARTING_WORD = "areallylongword";
    static ValidWords validWords;
    WordGeek service;

    @BeforeClass
    public static void oneTimeSetUp() {
        validWords = ValidWordsImpl.getInstance();
    }

    @Before
    public void setUp() throws Exception {
        service = new WordGeekImpl(STARTING_WORD, validWords);
        moreWords();
    }

    private void moreWords() {
        service.submitWord("player1", "all");
        service.submitWord("player2", "word");
        service.submitWord("player5", "woolly"); // first
        service.submitWord("player6", "really");
        service.submitWord("player2", "long");
        service.submitWord("player4", "dally");
        service.submitWord("player5", "wall");
        service.submitWord("player6", "real");
        service.submitWord("player1", "ally");
        service.submitWord("player2", "gall");
        service.submitWord("player3", "gels");
        service.submitWord("player4", "aardvark");
    }

    @Test
    public void submitWord() {
        assertEquals(3, service.submitWord("player1", "all"));
    }

    @Test
    public void isPermutation_true() {
        WordGeekImpl impl = new WordGeekImpl(STARTING_WORD, validWords);
        assertTrue(impl.isPermutation("all"));
    }

    @Test
    public void isPermutation_false() {
        WordGeekImpl impl = new WordGeekImpl(STARTING_WORD, validWords);
        assertFalse(impl.isPermutation("energy"));
    }

    @Test
    public void getPlayerNameAtPosition() {
        // player5, 'woolly' should be first
        assertEquals("player5", service.getPlayerNameAtPosition(0));
    }

    @Test
    public void getWordEntryAtPosition() {
        // player5: 'player5' should be first
        assertEquals("woolly", service.getWordEntryAtPosition(0));
    }

    @Test
    public void getScoreAtPosition() {
        assertEquals(3, service.getScoreAtPosition(9).intValue());
    }
}