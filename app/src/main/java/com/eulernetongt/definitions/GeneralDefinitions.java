package com.eulernetongt.definitions;

public class GeneralDefinitions {
	
	private static String name;
	private static String team;
	private static String country;
	
	public static void generate(String name, String team, String country){
		GeneralDefinitions.name = name;
		GeneralDefinitions.team = team;
		GeneralDefinitions.country = country;
	}
	
	public static String getName() {
		return name;
	}
	
	public static String getTeam() {
		return team;
	}
	
	public static String getCountry() {
		return country;
	}
	
	

}
