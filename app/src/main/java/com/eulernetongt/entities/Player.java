package com.eulernetongt.entities;

public class Player {
	
	public static enum Status {OK, INJURY, SUSPENDED, LACK_MATCH_PRACTICE, CONTRACT_EXPIRE, INTERNATIONAL};
	public static enum Position {GOALKEEPER, DEFENDER, MIDFIELD, FOWARD};
	
	private String name;
	private Position position;
	private long fitness;
	private int currentYellowCards;
	private Status currentStatus;
	private int age;
	private int skill;
	
	public Player(String name, Position position) {
		this.name = name;
		this.position = position;
	}
	
	public String getName() {
		return name;
	}
	
	public Position getPosition() {
		return position;
	}
	
	public void setFitness(long fitness) {
		this.fitness = fitness;
	}
	
	public long getFitness() {
		return fitness;
	}
	
	public void setCurrentStatus(Status currentStatus) {
		this.currentStatus = currentStatus;
	}
	
	public Status getCurrentStatus() {
		return currentStatus;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setSkill(int skill) {
		this.skill = skill;
	}
	
	public int getSkill() {
		return skill;
	}

}
