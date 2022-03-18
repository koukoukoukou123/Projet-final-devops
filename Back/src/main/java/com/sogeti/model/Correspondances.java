package com.sogeti.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

//JP entity "Correspondances"
@Entity
//The composite primary key of the class Correspondance is defined through the CorrespondancePK public class
@IdClass(CorrespondancesPK.class)
//DB table "Correspondances"
@Table(name = "CORRESPONDANCES")
public class Correspondances implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/* Relationships between Entities */
	
	/* Relationship Many Correspondances - One Championship 
	 * Many Correspondances are related to the same one Championship
	 * The foreign key is the attribute championshipName
	 */

	// First Primary Key
	@Id
	@ManyToOne
	@MapsId("championshipName")
	@JoinColumn(name = "championshipName", insertable = false, updatable = false)
	Championships championshipName;

	/* Relationship Many Correspondances - One Sport.
	 * Many Correspondances are associated to the same one Sport.
	 * The foreign key is the attribute sportId
	 */
	// Second Primary Key
	@Id
	@ManyToOne
	@MapsId("sportId")
	@JoinColumn(name = "sportId", insertable = false, updatable = false)
	Sports sportId;

	/* Constructors */

	/**
	 * Default constructor
	 */
	public Correspondances() {

	}

	/**
	 * Constructor initializing the fields :
	 * 
	 * @param championshipName : the name of the championship
	 * @param sportId          : the id of the sport corresponding to this
	 *                         championshipName
	 * 
	 */
	public Correspondances(Championships championshipName, Sports sportId) {
		super();
		this.championshipName = championshipName;
		this.sportId = sportId;
	}

	/* Getters */
	public Championships getChampionshipName() {
		return championshipName;
	}

	public Sports getSportId() {
		return sportId;
	}

	/* Setters */
	public void setChampionshipName(Championships championshipName) {
		this.championshipName = championshipName;
	}

	public void setSportId(Sports sportId) {
		this.sportId = sportId;
	}

	/**
	 * overriding the hashcode method
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((championshipName == null) ? 0 : championshipName.hashCode());
		result = prime * result + ((sportId == null) ? 0 : sportId.hashCode());
		return result;
	}

	/**
	 * overriding the equals method: this method is used to compare two objects of
	 * the class Correspondance
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Correspondances other = (Correspondances) obj;
		if (championshipName == null) {
			if (other.championshipName != null)
				return false;
		} else if (!championshipName.equals(other.championshipName))
			return false;
		if (sportId == null) {
			if (other.sportId != null)
				return false;
		} else if (!sportId.equals(other.sportId))
			return false;
		return true;
	}

}
