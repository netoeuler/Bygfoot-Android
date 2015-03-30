package com.eulernetongt.entities;

public class TeamTable implements Comparable{
	
	private String teamName;
	private int PL,W,DW,L,GF,GA,GD,PTS;
	
	public TeamTable(String teamName){
		this.teamName = teamName;
	}

	@Override
	public int compareTo(Object arg0) {
		int comparepts = ((TeamTable) arg0).getPTS();		
		return this.PTS - comparepts;
	}
	
	public int getPTS() {
		return PTS;
	}
	
	public int getPL() {
		return PL;
	}
	
	public int getW() {
		return W;
	}
	
	public int getDW() {
		return DW;
	}
	
	public int getL() {
		return L;
	}
	
	public int getGF() {
		return GF;
	}
	
	public int getGA() {
		return GA;
	}
	
	public int getGD() {
		return GD;
	}
	
	public String getTeamName() {
		return teamName;
	}
}
