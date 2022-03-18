package com.sogeti.model;

import java.io.Serializable;

/* ParticpationsPK is the IdClass of the Participation class
 * It specifies the multiple primary keys of the Participations entity
 */
public class ParticipationsPK implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/* Composite Primary Key */
	/**
	 * the composite primary key of the Participations class is the combination of two fields:
	 * championshipName
	 * teamName
	 */
	String teamName;
	String championshipName;
	
	/**
	 * Default Constructor:
	 * no-argument constructor
	 */
	public ParticipationsPK() {
	}
	
	/**
	 * overriding the hashcode method
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((championshipName == null) ? 0 : championshipName.hashCode());
		result = prime * result + ((teamName == null) ? 0 : teamName.hashCode());
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
		ParticipationsPK other = (ParticipationsPK) obj;
		if (championshipName == null) {
			if (other.championshipName != null)
				return false;
		} else if (!championshipName.equals(other.championshipName))
			return false;
		if (teamName == null) {
			if (other.teamName != null)
				return false;
		} else if (!teamName.equals(other.teamName))
			return false;
		return true;
	}

    

}