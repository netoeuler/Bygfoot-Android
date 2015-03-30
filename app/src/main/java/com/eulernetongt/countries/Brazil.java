package com.eulernetongt.countries;

import java.util.ArrayList;

public class Brazil extends Team{
	
	private static String[] teams = {"Atletico-MG", "Atletico-PR", "Bahia", "Botafogo",
		"Corinthians", "Coritiba", "Criciuma", "Cruzeiro", "Figueirense", "Flamengo",
		"Fluminense", "Goias", "Gremio", "Internacional", "Palmeiras", "Santos",
		"Sao Paulo", "Sport", "Vasco da Gama", "Vitoria"};
	
	private static String[] leagues = {"Brasileiro Serie A", "Brasileiro Serie B",
		"Brasileiro Serie C"};
	
	private static String[] cups = {"Copa do Brasil", "Brasileiro Serie D"};
	
	public static ArrayList<String> getTeams(){
		return Team.getTeams(teams);
	}

}
