package com.cantimaginewhy.workgeekapi.logic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Vector;

/**
 * Copyright (C) 2022 Codesse. All rights reserved.
 * ••••••••••••••••••••••••••••••••••••••••••••••••
 */
public class DictionaryImpl implements Dictionary {

	private static DictionaryImpl INSTANCE = new DictionaryImpl();

	public static Dictionary getInstance() {
		return INSTANCE;
	}
	Vector<String> v = new Vector<>();

	private DictionaryImpl() {
		try {
			InputStreamReader reader = new InputStreamReader(this.getClass().getResourceAsStream("/wordlist.txt"), "utf-8");
			BufferedReader in = new BufferedReader(reader);
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				v.add(inputLine);
			}
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean contains(String word) {
		return v.contains(word);
	}

	@Override
	public int size() {
		return v.size();
	}
}
