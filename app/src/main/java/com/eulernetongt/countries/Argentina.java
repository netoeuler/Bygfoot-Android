package com.eulernetongt.countries;

import java.util.ArrayList;

public class Argentina extends Team{
	
	private static String[] teams = {"All Boys", "Argentinos Juniors", "Arsenal", "Atletico Rafaela",
			"Belgrano", "Boca Juniors", "Colon", "Estudiantes", "Gimnasia", "Godoy Cruz",
			"Lanus", "Newells Old Boys", "Olimpo", "Quilmes", "Racing", "River Plate",
			"Rosario Central", "San Lorenzo", "Tigre", "Velez Sarsfield"};
	
	public static ArrayList<String> getTeams(){
		return Team.getTeams(teams);
	}

}
