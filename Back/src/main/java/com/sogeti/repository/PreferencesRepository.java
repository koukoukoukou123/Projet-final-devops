package com.sogeti.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sogeti.model.Preferences;

@Repository
@Transactional
public interface PreferencesRepository extends JpaRepository<Preferences, Long> {
	/**
	 * Find a preference by using the username of the user who is associated to this preference
	 * @param username
	 * @return preference
	 */
Optional <Preferences> findByusername(String username);
}
