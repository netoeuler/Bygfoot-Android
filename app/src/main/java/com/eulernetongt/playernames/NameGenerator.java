package com.eulernetongt.playernames;

import java.util.Random;

public class NameGenerator {
	
	public static String generateName(Object[] names){
		Random rand = new Random();
		
		String[] first = (String[])names[0];
		String[] last = (String[])names[1];
		int f = rand.nextInt(first.length);
		int l = rand.nextInt(last.length);
		return first[f].concat(" ").concat(last[l]);
	}

}
