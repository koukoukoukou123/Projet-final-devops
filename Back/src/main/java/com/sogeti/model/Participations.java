package com.sogeti.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
//JP entity "Participations"
@Entity
//The composite primary key of the class Participation is defined through the ParticipationPK public class
@IdClass(ParticipationsPK.class)
//DB table "Participations"
@Table(name = "PARTICIPATIONS")
public class Participations implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/* Relationships between Entities */

	/*
	 * Relationship Many Participations - One Championship. Many Participations could
	 * be associated to the same one Championship. The foreign key is the attribute
	 * championshipName
	 */
	@Id
	@ManyToOne
	@MapsId("championshipName")
	@JoinColumn(name = "championshipName", insertable = false, updatable = false)
	Championships championshipName;

	/*
	 * Relationship Many Participations - One Team. Many Participations could be
	 * associated to the same one Team. The foreign key is the attribute teamName
	 */
	@Id
	@ManyToOne
	@MapsId("teamName")
	@JoinColumn(name = "teamName", insertable = false, updatable = false)
	Teams teamName;

	/* Private fields */

	/**
	 * number of points
	 */
	@Column(name = "points")
	private int points;
	/**
	 * number of matches won
	 */
	@Column(name = "win")
	private int win;
	/**
	 * number of draws
	 */
	@Column(name = "draw")
	private int draw;
	/**
	 * number of lost matches
	 */
	@Column(name = "lose")
	private int lose;

	/**
	 * Default Constructor
	 */
	public Participations() {
	}

	/**
	 * Constructor initializing the values of all the properties of the
	 * Participations Class :
	 * 
	 * @param championshipName
	 * @param teamName
	 * @param points
	 * @param win
	 * @param draw
	 * @param lose
	 */

	public Participations(Championships championshipName, Teams teamName, int points, int win, int draw, int lose) {
		super();
		this.championshipName = championshipName;
		this.teamName = teamName;
		this.points = points;
		this.win = win;
		this.draw = draw;
		this.lose = lose;
	}

	/* Getters */

	public Championships getChampionshipName() {
		return championshipName;
	}

	public Teams getTeamName() {
		return teamName;
	}

	public int getPoints() {
		return points;
	}

	public Championships getChampionship() {
		return championshipName;
	}

	public Teams getTeam() {
		return teamName;
	}

	public int getWin() {
		return win;
	}

	public int getDraw() {
		return draw;
	}

	public int getLose() {
		return lose;
	}

	/* Setters */
	public void setChampionshipName(Championships championshipName) {
		this.championshipName = championshipName;
	}

	public void setTeamName(Teams teamName) {
		this.teamName = teamName;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public void setWin(int win) {
		this.win = win;
	}

	public void setDraw(int draw) {
		this.draw = draw;
	}

	public void setLose(int lose) {
		this.lose = lose;
	}

	public void setTeam(Teams team) {
		this.teamName = team;
	}

	public void setChampionship(Championships championship) {
		this.championshipName = championship;
	}

	/**
	 * Overriding the method hashCode
	 */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((championshipName == null) ? 0 : championshipName.hashCode());
		result = prime * result + draw;
		result = prime * result + lose;
		result = prime * result + points;
		result = prime * result + ((teamName == null) ? 0 : teamName.hashCode());
		result = prime * result + win;
		return result;
	}

	/**
	 * Overriding the method equals: this method is used to compare two objects of
	 * the class Participations
	 */

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Participations other = (Participations) obj;
		if (championshipName == null) {
			if (other.championshipName != null)
				return false;
		} else if (!championshipName.equals(other.championshipName))
			return false;
		if (draw != other.draw)
			return false;
		if (lose != other.lose)
			return false;
		if (points != other.points)
			return false;
		if (teamName == null) {
			if (other.teamName != null)
				return false;
		} else if (!teamName.equals(other.teamName))
			return false;
		if (win != other.win)
			return false;
		return true;
	}

}