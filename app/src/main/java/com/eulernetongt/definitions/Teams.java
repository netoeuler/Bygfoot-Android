package com.eulernetongt.definitions;

import java.util.ArrayList;

import com.eulernetongt.countries.Argentina;
import com.eulernetongt.countries.Brazil;

public class Teams {
	
	public static ArrayList<String> getTeams(String country){
		if (country.equals("Argentina"))
			return Argentina.getTeams();		
		else if (country.equals("Brazil"))
			return Brazil.getTeams();
		
		
		return new ArrayList<String>();
		
	}
	
	

}
