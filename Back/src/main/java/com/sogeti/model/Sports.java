package com.sogeti.model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//JP entity "Sports"
@Entity
//DB table "Sports"
@Table(name = "SPORTS")
public class Sports implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/* Private Fields */

	// Primary Key of the "Sport" table is : sportId
	@Id
	@Column
	private String sportId;

	@Column
	private String sportCategory;
	
	/* Relationships between Entities */

	/*
	 * Relationship One Sport - Many Preferences. One Sport could be the subject of
	 * Many Preferences. This relationship is mapped by the attribute sportId
	 */
	@OneToMany(mappedBy = "sportId")
	Set<Preferences> preferences;

	/*
	 * Relationship One Sport - Many Correspondences. One Sport could be the subject
	 * of Many Correspondences. This relationship is mapped by the attribute sportId
	 */
	@OneToMany(mappedBy = "sportId")
	Set<Correspondances> corespondances;

	/* Constructors */

	/**
	 * Default Constructor
	 */
	public Sports() {
		super();
	}

	/**
	 * Constructor initializing the sportCategory of an object of the class Sport
	 * 
	 * @param sportCategory
	 */
	public Sports(String sportCategory) {
		this.sportCategory = sportCategory;
	}

	/**
	 * Constructor initializing the sportId and sportCategory of an object of the
	 * class Sport
	 * 
	 * @param sportId
	 * @param sportCategory
	 */
	public Sports(String sportId, String sportCategory) {
		super();
		this.sportId = sportId;
		this.sportCategory = sportCategory;
	}

	/* Getters */
	public String getSportCategory() {
		return sportCategory;
	}

	public String getSportId() {
		return sportId;
	}

	/* Setters */
	public void setSportCategory(String sportCategory) {
		this.sportCategory = sportCategory;
	}

	public void setSportId(String sportId) {
		this.sportId = sportId;
	}

	/**
	 * overriding the hashCode method
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((corespondances == null) ? 0 : corespondances.hashCode());
		result = prime * result + ((preferences == null) ? 0 : preferences.hashCode());
		result = prime * result + ((sportCategory == null) ? 0 : sportCategory.hashCode());
		result = prime * result + ((sportId == null) ? 0 : sportId.hashCode());
		return result;
	}

	/**
	 * overriding the equals method
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sports other = (Sports) obj;
		if (corespondances == null) {
			if (other.corespondances != null)
				return false;
		} else if (!corespondances.equals(other.corespondances))
			return false;
		if (preferences == null) {
			if (other.preferences != null)
				return false;
		} else if (!preferences.equals(other.preferences))
			return false;
		if (sportCategory == null) {
			if (other.sportCategory != null)
				return false;
		} else if (!sportCategory.equals(other.sportCategory))
			return false;
		if (sportId == null) {
			if (other.sportId != null)
				return false;
		} else if (!sportId.equals(other.sportId))
			return false;
		return true;
	}

}