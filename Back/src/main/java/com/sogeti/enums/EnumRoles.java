package com.sogeti.enums;

// Enumeration Roles

public enum EnumRoles {
	/**
	 * Constant: ROLE_ADMIN
	 */
	ROLE_ADMIN("ROLE_ADMIN"),

	/**
	 * Constant: ROLE_USER
	 */
	ROLE_USER("ROLE_USER");
	
	/* Private Fields */
	private String role;

	/**
	 * Private constructor
	 * 
	 * @param s : role
	 */
	private EnumRoles(String s) {
		this.role = s;
	}

	/* Getter */
	public String getRole() {
		return role;
	}

	/* Setter */
	public void setRole(String role) {
		this.role = role;
	}

}
