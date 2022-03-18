package com.sogeti.model;

import java.io.Serializable;

/* CorrespondancePK is the IdClass of the Correspondance class
 * It specifies the multiple primary keys of the Correspondance entity
 */
public class CorrespondancesPK implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/* Composite Primary Key */
	/**
	 * the composite primary key of the Correspondance class is the combination of two fields:
	 * championshipName
	 * sportId
	 */
	String championshipName;
	String sportId;
	/* Constructor */
	/**
	 * Default Constructor :
	 * no-argument constructor
	 */
	public CorrespondancesPK() {
	}
	/**
	 * overriding the hashCode method
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
		CorrespondancesPK other = (CorrespondancesPK) obj;
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
