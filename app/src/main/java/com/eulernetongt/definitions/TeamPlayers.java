package com.eulernetongt.definitions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import android.graphics.Color;

import com.eulernetongt.entities.Player;
import com.eulernetongt.playernames.NameGenerator;
import com.eulernetongt.playernames.NamesBrazil;

public class TeamPlayers {
	
	private static HashMap<String, ArrayList<Player>> table;
	
	public static void generateTeamPlayersByCountry(String country){
		ArrayList<String> teams = Teams.getTeams(country);
		
		for (String team : teams)
			generateTeamPlayersByTeam(team);
	}
	
	public static void generateTeamPlayersByTeam(String teamName){
		if (table == null)
			table = new HashMap<String, ArrayList<Player>>();
		
		if (!table.containsKey(teamName)){
			Random rand = new Random();
			ArrayList<Player> playerList = new ArrayList<Player>();
			
			for (int i=0 ; i<18; i++){
				Player.Position position = null;
				if (i == 0 || i == 12)
			    	position = Player.Position.GOALKEEPER;
			    else if ((i >= 1 && i <= 4) || (i >= 13 && i <= 14))
			    	position = Player.Position.DEFENDER;
			    else if ((i >= 5 && i <= 8) || (i >= 15 && i <= 16))
			    	position = Player.Position.MIDFIELD;
			    else if ((i >= 9 && i <= 11) || (i == 17))
			    	position = Player.Position.FOWARD;
				
				Player player = new Player(NameGenerator.generateName(NamesBrazil.names), position);
				
				player.setFitness(100);
				player.setCurrentStatus(Player.Status.OK);
				player.setAge(rand.nextInt(10) + 23);
				player.setSkill(rand.nextInt(20) + 20);
				
				playerList.add(player);
			}
			
			table.put(teamName, playerList);
		}
		
	}
	
	public static HashMap<String, ArrayList<Player>> getTable() {
		return table;
	}

}
