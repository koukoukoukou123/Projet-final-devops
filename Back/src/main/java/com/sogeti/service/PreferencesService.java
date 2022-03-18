package com.sogeti.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sogeti.model.Preferences;
import com.sogeti.repository.PreferencesRepository;

@Service
public class PreferencesService {

	@Autowired
	PreferencesRepository preferencesRepository;

	/**
	 * Find and retrieve one preference from the Preference table in the DB, using
	 * the name of the user associated to this specific preference
	 * 
	 * @param username
	 * @return preference (if was found) or null (if it wasn't found)
	 */
	public Preferences findByusername(String username) {
		Optional<Preferences> preferences = preferencesRepository.findByusername(username);
		if (preferences.isPresent()) {
			return preferences.get();
		} else {
			return null;
		}
	}

	/**
	 * Find and retrieve all the preferences from the database
	 * @return List<Preferences>
	 */
	public List<Preferences> findAll() {
		return preferencesRepository.findAll();
	}
}
