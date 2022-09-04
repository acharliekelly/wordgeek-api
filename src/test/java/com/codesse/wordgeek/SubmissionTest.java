package com.codesse.wordgeek;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Copyright (C) 2022 Codesse. All rights reserved.
 * ••••••••••••••••••••••••••••••••••••••••••••••••
 */
public class SubmissionTest {

	static ValidWords validWords;
	WordGeek service;

	@BeforeClass
	public static void oneTimeSetUp() {
		validWords = ValidWordsImpl.getInstance();
	}

	@Before
	public void setUp() throws Exception {
		service = new WordGeekImpl("areallylongword", validWords);
		LeaderBoard.getInstance().clear();
	}

	@Test
	public void testSubmission() throws Exception {
		assertEquals(3, service.submitWord("player1", "all"));
		assertEquals(4, service.submitWord("player2", "word"));
		assertEquals(0, service.submitWord("player3", "tale"));
		assertEquals(0, service.submitWord("player4", "glly"));
		assertEquals(6, service.submitWord("player5", "woolly"));
		assertEquals(0, service.submitWord("player6", "adder"));
	}

	@Test
	public void testLeaderboard() {
		service.submitWord("player1", "all");
		service.submitWord("player2", "word");
		service.submitWord("player3", "tale"); // skipped, invalid
		service.submitWord("player4", "glly"); // skipped, invalid
		service.submitWord("player5", "woolly");
		service.submitWord("player6", "adder"); // skipped, invalid
		service.submitWord("player1", "really");
		service.submitWord("player2", "long");
		service.submitWord("player3", "woolly"); // skipped, already in list
		service.submitWord("player4", "dally");
		service.submitWord("player5", "wall");
		service.submitWord("player6", "real");
		assertEquals(8, LeaderBoard.getInstance().getList().size());
		service.submitWord("player1", "ally");
		service.submitWord("player2", "gall");
		service.submitWord("player3", "gels");
		assertEquals(10, LeaderBoard.getInstance().getList().size());
	}



}
