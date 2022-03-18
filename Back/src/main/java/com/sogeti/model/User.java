package com.sogeti.model;

import java.sql.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;

//JP entity "User"
@Entity
//DB table "Users"
@Table(name = "USERS", uniqueConstraints = { @UniqueConstraint(columnNames = { "username" }) })
public class User {

	/* Private fields */

	// Primary key of the class user is : username
	@Id
	@Column
	@Size(min = 3, max = 50)
	private String username;

	@Column
	@Size(min = 6, max = 100)
	private String password;

	@Column
	private String email;

	@Column
	private String role;

	@Column
	private Date lastlogin;

	@Column
	private String langue;
	@Column
	private String langueId;
	
	/* Relationships between Entities */
	
	/*
	 * Relationship One User - Many Preferences. One User could be the have Many
	 * Preferences. This relationship is mapped by the attribute username
	 */

	@OneToMany(mappedBy = "username")
	Set<Preferences> preferences;

	/* Constructors */

	/**
	 * Default Constructor
	 */
	public User() {
	}

	/**
	 * Constructor initializing the properties username and password of an object of
	 * the class User
	 * 
	 * @param username
	 * @param password
	 */
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	/**
	 * Constructor
	 * 
	 * @param username
	 * @param password
	 * @param email
	 */
	public User(String username, String password, String email) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
	}

	/**
	 * Constructor
	 * 
	 * @param username
	 * @param password
	 * @param email
	 * @param role
	 * @param lastlogin
	 * @param langue
	 * @param langueId
	 */
	public User(String username, String password, String email, String role, Date lastlogin, String langue,
			String langueId) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.role = role;
		this.lastlogin = lastlogin;
		this.langue = langue;
		this.langueId = langueId;
	}

	/**
	 * Constructor
	 * 
	 * @param username
	 * @param password
	 * @param email
	 * @param role
	 * @param lastlogin
	 * @param langue
	 * @param langueId
	 * @param preferences
	 */
	public User(String username, String password, String email, String role, Date lastlogin, String langue,
			String langueId, Set<Preferences> preferences) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.role = role;
		this.lastlogin = lastlogin;
		this.langue = langue;
		this.langueId = langueId;
		this.preferences = preferences;
	}

	/* Getters */

	public String getPassword() {
		return password;
	}

	public String getLangueId() {
		return langueId;
	}

	public String getUsername() {
		return username;
	}

	public Date getLastlogin() {
		return lastlogin;
	}

	public String getLangue() {
		return langue;
	}

	public String getRole() {
		return role;
	}

	public String getEmail() {
		return email;
	}

	public Set<Preferences> getPreferences() {
		return preferences;
	}

	/* Setters */
	public void setPassword(String password) {
		this.password = password;
	}

	public void setLastlogin(Date lastlogin) {
		this.lastlogin = lastlogin;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setLangueId(String langueId) {
		this.langueId = langueId;
	}

	public void setLangue(String langue) {
		this.langue = langue;
	}

	public void setRoles(String role) {
		this.role = role;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPreferences(Set<Preferences> preferences) {
		this.preferences = preferences;
	}

	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * overriding the hashCode method
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((langueId == null) ? 0 : langueId.hashCode());
		result = prime * result + ((lastlogin == null) ? 0 : lastlogin.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((preferences == null) ? 0 : preferences.hashCode());
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
		User other = (User) obj;
		if (langueId == null) {
			if (other.langueId != null)
				return false;
		} else if (!langueId.equals(other.langueId))
			return false;
		if (lastlogin == null) {
			if (other.lastlogin != null)
				return false;
		} else if (!lastlogin.equals(other.lastlogin))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (preferences == null) {
			if (other.preferences != null)
				return false;
		} else if (!preferences.equals(other.preferences))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

}
