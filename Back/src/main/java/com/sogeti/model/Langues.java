package com.sogeti.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//JP entity "Langues"
@Entity
//DB table "Langues"
@Table(name = "LANGUES")
public class Langues implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/* Private fields */
	// Primary key of the "Langues" table
	@Id
	@Column
	private String langueId;

	@Column
	private String langue;

	/* Relationship One Language To Many Users */
    @OneToMany()
    @JoinColumn(name= "langueId")
    private Set<User> user;

	/**
	 * Default constructor
	 */
	public Langues() {
	}

	/**
	 * Constructor initializing the fields :
	 * 
	 * @param langue_id : the identifier of the language
	 * @param langue : the name of the language
	 */
	public Langues(String langue_id, String langue) {
		this.langueId = langue_id;
		this.langue = langue;
	}

	/* Getters */
	public String getLangue_id() {
		return langueId;
	}

	public String getLangue() {
		return langue;
	}

	/* Setters */
	public void setLangue_id(String langue_id) {
		this.langueId = langue_id;
	}

	public void setLangue(String langue) {
		this.langue = langue;
	}

}
