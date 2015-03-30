package com.eulernetongt.definitions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.eulernetongt.entities.Match;
import com.eulernetongt.entities.TeamTable;

public class Table {
	
	private HashMap<Integer, List<Match>> matchesByWeek;
	private String competition;
	private ArrayList<TeamTable> classification;
	
	public Table(String competition) {
		this.competition = competition;
		matchesByWeek = new HashMap<Integer, List<Match>>();
		classification = new ArrayList<TeamTable>();
	}
	
	public HashMap<Integer, List<Match>> getMatchesByWeek() {
		return matchesByWeek;
	}
	
	public ArrayList<TeamTable> getClassification() {
		return classification;
	}
}
