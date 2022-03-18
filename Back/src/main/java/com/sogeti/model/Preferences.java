package com.sogeti.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

//JP entity "Preferences"
@Entity
//The composite primary key of the class Preferences is defined through the PreferncesPK public class
@IdClass(PreferencesPK.class)
//DB table "Preferences"
@Table(name = "PREFERENCES")
public class Preferences implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/* Private Fields */

	/* Relationships between entities */
	
	/* Relationship Many Preferences - One Sport 
	 * Many Preferences could be associated to the same one Sport
	 * The foreign key is the attribute sportId
	 */
	@Id
	@ManyToOne
	@MapsId("sportId")
	@JoinColumn(name = "sportId", insertable = false, updatable = false)
	Sports sportId;

	
	/* Relationship Many Preferences - One User
	 * Many Preferences could be associated to the same one User
	 * The foreign key is the attribute username
	 */
	@Id
	@ManyToOne
	@MapsId("username")
	@JoinColumn(name = "username", insertable = false, updatable = false)
	User username;
	/* Constructors */

	/**
	 * Default constructor
	 */
	public Preferences() {
	}

	/**
	 * Constructor initializing the values of all the properties of an object of the
	 * Preferences class
	 * 
	 * @param sportId  : identifier of sport
	 * @param username : name of the user who preferred this sport
	 */
	public Preferences(Sports sportId, User username) {
		super();
		this.sportId = sportId;
		this.username = username;
	}

	/* Getters */
	public Sports getSportId() {
		return sportId;
	}

	public User getUsername() {
		return username;
	}

	/* Setters */
	public void setSportId(Sports sportId) {
		this.sportId = sportId;
	}

	public void setUsername(User username) {
		this.username = username;
	}

}
