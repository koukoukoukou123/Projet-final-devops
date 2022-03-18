package com.sogeti.model;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
//JP entity "championships"
@Entity
// DB table "championships"
@Table(name = "championships")
public class Championships {

	/* Private fields */

	/**
	 * name of the championship
	 */
	// Primary key: championshipName
	@Id
	@Column(name = "championshipName")
	private String championshipName;

	/* Relationships between Entities */

	/*
	 * Relationship One Championship - Many Participations: One Championship could
	 * be the subject of many Participations This relationship is mapped by the
	 * attribute "championdhipName"
	 */
	@OneToMany(mappedBy = "championshipName")
	Set<Participations> participation;

	/*
	 * Relationship One Championship - Many Correspondances: One Championship could
	 * correspond to Many Correspondances This relationship is mapped by the
	 * attribute "championdhipName"
	 */
	@OneToMany(mappedBy = "championshipName")
	Set<Correspondances> corespondances;

	/* Constructors */

	/**
	 * Default constructor
	 */
	public Championships() {
	}

	/**
	 * Constructor initializing the name of the championship
	 * 
	 * @param championshipName : name of the championship
	 */
	public Championships(String championshipName) {
		this.championshipName = championshipName;
	}

	/* Getters */
	public String getchampionshipName() {
		return championshipName;
	}

	/* Setters */
	public void setchampionshipName(String championshipName) {

		this.championshipName = championshipName;
	}

	/**
	 * Overriding the hashcode method
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((championshipName == null) ? 0 : championshipName.hashCode());
		return result;
	}

	/**
	 * Overriding the method equals: this method is used to compare two objects of
	 * the class Championship
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Championships other = (Championships) obj;
		if (championshipName == null) {
			if (other.championshipName != null)
				return false;
		} else if (!championshipName.equals(other.championshipName))
			return false;
		return true;
	}

}
