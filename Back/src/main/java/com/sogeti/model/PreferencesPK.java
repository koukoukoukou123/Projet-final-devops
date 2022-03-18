package com.sogeti.model;

import java.io.Serializable;

/* PreferencesPK is the IdClass of the Preferences class
 * It specifies the multiple primary keys of the Preferences entity
 */
public class PreferencesPK implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/* Composite Primary Key */
	/**
	 * the composite primary key of the Preferences class is the combination of two
	 * fields: username and sportId
	 */
	String sportId;
	String username;

	/**
	 * Default Constructor: no-argument constructor
	 */
	public PreferencesPK() {
	}

	/**
	 * overriding the hashCode method
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sportId == null) ? 0 : sportId.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		PreferencesPK other = (PreferencesPK) obj;
		if (sportId == null) {
			if (other.sportId != null)
				return false;
		} else if (!sportId.equals(other.sportId))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

}
