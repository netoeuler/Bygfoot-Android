package com.eulernetongt.entities;

public class Match {
	
	private String home;
	private String away;

    public static char HOME_TEAM = 'H';
    public static char AWAY_TEAM = 'A';
	
	public Match(String home, String away) {
		this.home = home;
		this.away = away;
	}
	
	public String getHome() {
		return home;
	}
	
	public String getAway() {
		return away;
	}
	
	@Override
	public String toString() {
		return home+" x "+away;
	}

}
