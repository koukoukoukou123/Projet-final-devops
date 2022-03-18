package com.sogeti.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "TEAMS")
public class Teams {



	@Id
	@Column(name = "teamName")
	private String teamName;
	
	/* One to Many relationship between Team and Participations : */
	/* One team can have Many Participations */
	@OneToMany(mappedBy = "teamName")
	private Set<Participations> participation;
	
	public Teams() {
	}

	public Teams(String teamName) {
		this.teamName = teamName;
	}


	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((participation == null) ? 0 : participation.hashCode());
		result = prime * result + ((teamName == null) ? 0 : teamName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Teams other = (Teams) obj;
		if (participation == null) {
			if (other.participation != null)
				return false;
		} else if (!participation.equals(other.participation))
			return false;
		if (teamName == null) {
			if (other.teamName != null)
				return false;
		} else if (!teamName.equals(other.teamName))
			return false;
		return true;
	}

}
