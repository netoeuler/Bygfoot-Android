package com.eulernetongt.definitions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import com.eulernetongt.countries.Brazil;
import com.eulernetongt.entities.Match;
import com.eulernetongt.entities.TeamTable;

public class Calendar {
	
	private int season;
	private int week;
	
	public static ArrayList<Table> tableList;	
	public static ArrayList<TeamTable> tableClassification;
	
	public static void generateByCountry(String country){
		if (tableList == null)
			tableList = new ArrayList<Table>();
		
		Table table = new Table("Brasileiro Serie A");
		Random rand = new Random();
		
		//TODO: Generalize this
		ArrayList<String> teams = Brazil.getTeams();			
		
		//Create classification table
		for (String t : teams){
			table.getClassification().add(new TeamTable(t));
		}
		tableClassification = table.getClassification();
		
		//Create fixtures
		Collections.shuffle(teams, rand);		
		
		int numTeams = teams.size();
		int rounds = numTeams - 1;
		int week;
		
		for (week=0; week<rounds ; week++){
			ArrayList<Match> listMatch = new ArrayList<Match>();
			ArrayList<Match> listMatch2 = new ArrayList<Match>();
			for (int j=0 ; j<numTeams/2 ; j++){
				String home, away;
                if (j % 2 == 1 || week % 2 == 1 && j == 0){
                	home = teams.get(numTeams - j - 1);
                    away = teams.get(j);
                }
                else{
                	home = teams.get(j);
                	away = teams.get(numTeams - j - 1);
                }
				
				listMatch.add(new Match(home, away));
				listMatch2.add(new Match(away, home));
			}
			table.getMatchesByWeek().put(week+1, listMatch);
			table.getMatchesByWeek().put(rounds+week+1, listMatch2);
			
			teams.add(1, teams.remove(teams.size()-1));
		}
		
		tableList.add(table);
	}
	
}
