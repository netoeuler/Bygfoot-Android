package com.eulernetongt.countries;

import java.util.ArrayList;

public class Team {
	
	protected static ArrayList<String> getTeams(String[] teams){
		if (teams == null)
			teams = new String[]{""};
		
		ArrayList<String> arrl = new ArrayList<String>();
		for (int i=0 ; i<teams.length ; i++)
			arrl.add(teams[i]);		
		
		return arrl;
	}

}
