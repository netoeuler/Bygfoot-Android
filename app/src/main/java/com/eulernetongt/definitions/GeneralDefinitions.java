package com.eulernetongt.definitions;

public class GeneralDefinitions {
	
	private static String name;
	private static String team;
	private static String country;
	private static int money;
	
	public static void generate(String name, String team, String country){
		GeneralDefinitions.name = name;
		GeneralDefinitions.team = team;
		GeneralDefinitions.country = country;
		money = 5000000;
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

	public static int getMoney() {
		return money;
	}

	public static void addMoney(int value){
		money += value;
	}

	public static void subMoney(int value){
		money -= value;
	}
}
