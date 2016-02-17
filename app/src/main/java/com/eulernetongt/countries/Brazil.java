package com.eulernetongt.countries;

import java.util.ArrayList;

public class Brazil extends Team{
	
	private static String[] teamsA = {"Atletico-MG", "Atletico-PR", "Bahia", "Botafogo",
		"Corinthians", "Coritiba", "Criciuma", "Cruzeiro", "Figueirense", "Flamengo",
		"Fluminense", "Goias", "Gremio", "Internacional", "Palmeiras", "Santos",
		"Sao Paulo", "Sport", "Vasco da Gama", "Vitoria"};

    private static String[] teamsB = {"America-MG", "America-RN", "ASA", "Avai", "Bragantino",
            "Brasil de Pelotas", "Ceara", "Chapecoense", "CRB", "Criciuma", "Fortaleza",
            "Guarani", "Joinvile", "Juventude", "Macae", "Nautíco", "Parana", "Paysandu",
            "Portuguesa", "Vila Nova"};

    private static String[] teams = null;
	
	private static String[] leagues = {"Serie A", "Serie B", "Serie C"};
	
	private static String[] cups = {"Copa do Brasil", "Serie D"};
	
	public static ArrayList<String> getTeams(){
        //TODO: Call generateAllTeams() in another way, this is unrecommended
        if (teams == null)
            generateAllTeams();
		return Team.getTeams(teams);
	}

    public static ArrayList<String> getTeamsByCompetition(String competition){
        String[] teamsReference;
        if (competition.equals("Serie A"))
            teamsReference = teamsA;
        else if (competition.equals("Serie B"))
            teamsReference = teamsB;
        else
        teamsReference = null;

        return Team.getTeams(teamsReference);
    }

    private static void generateAllTeams(){
        int i, j, curI;
        int total = teamsA.length + teamsB.length;

        teams = new String[total];

        j=0;
        for (i=0 ; i<teamsA.length ; i++)
            teams[i] = teamsA[j++];

        curI = i;
        j=0;

        for ( ; i<curI + teamsB.length ; i++)
            teams[i] = teamsB[j++];
    }


}
