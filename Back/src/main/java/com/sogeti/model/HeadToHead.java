package com.sogeti.model;

public class HeadToHead {

	/* Private fields */

	// First team
	private String equipe1;

	// Second team
	private String equipe2;

	/**
	 * Default constructor
	 */
	public HeadToHead() {
		super();
	}

	/**
	 * Constructor initializing all the value of the properties of an object of the
	 * HeadToHead class
	 * 
	 * @param equipe1 : name of first team in the head to head game
	 * @param equipe2 : name of second team in the head to head game
	 */
	public HeadToHead(String equipe1, String equipe2) {
		super();
		this.equipe1 = equipe1;
		this.equipe2 = equipe2;
	}

	/* Getters */

	public String getEquipe1() {
		return equipe1;
	}

	public String getEquipe2() {
		return equipe2;
	}

	public void setEquipe1(String equipe1) {
		this.equipe1 = equipe1;
	}

	public void setEquipe2(String equipe2) {
		this.equipe2 = equipe2;
	}

}
