package com.sogeti.model;

public class TeamClassementAdd {
	/* Private Fields */
	private String team;
	private String championship;
	private int win;
	private int lose;
	private int draw;

	/* Constructors */
	/**
	 * Default constructor
	 */
	public TeamClassementAdd() {
		super();
	}

	/**
	 * Constructor initializing all the properties of the object TeamClassement
	 * 
	 * @param team
	 * @param championshipName
	 * @param win
	 * @param lose
	 * @param draw
	 */
	public TeamClassementAdd(String team, String championshipName, int win, int lose, int draw) {
		super();
		this.team = team;
		this.championship = championshipName;
		this.win = win;
		this.lose = lose;
		this.draw = draw;
	}

	/* Getters */
	public String getTeam() {
		return team;
	}

	public int getDraw() {
		return draw;
	}

	public String getChampionship() {
		return championship;
	}

	public int getLose() {
		return lose;
	}

	public int getWin() {
		return win;
	}

	/* Setters */
	public void setWin(int win) {
		this.win = win;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public void setLose(int lose) {
		this.lose = lose;
	}

	public void setChampionship(String championshipName) {
		this.championship = championshipName;
	}

	public void setDraw(int draw) {
		this.draw = draw;
	}

}
