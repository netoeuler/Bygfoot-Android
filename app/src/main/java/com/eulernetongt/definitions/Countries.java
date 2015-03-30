package com.eulernetongt.definitions;

import java.util.ArrayList;

public class Countries {
	
	public static ArrayList<String> getCountries(){
		/*String[] list = {"Argentina", "Australia", "Belgium", "Brazil", "Bulgaria",
				"Czech", "England", "France", "Germany", "Greece", "Ireland", "Italy",
				"Japan", "Mexico", "Netherlands", "Norway", "Peru", "Poland", "Romania",
				"Scotland", "Spain", "Sweden", "Turkey", "USA", "Wales"};*/
		
		//Just for demo version
		String[] list = {"Brazil"};
		
		ArrayList<String> arrl = new ArrayList<String>();
		for (int i=0 ; i<list.length ; i++)
			arrl.add(list[i]);
		
		return arrl;
	}

}
