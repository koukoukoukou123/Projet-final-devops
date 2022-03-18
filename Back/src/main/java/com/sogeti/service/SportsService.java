package com.sogeti.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sogeti.model.Sports;
import com.sogeti.repository.SportsRepository;

@Service
public class SportsService {

	@Autowired
	SportsRepository sportsRepository;

	/**
	 * Find and retrieve one sport from the Sport table in the DB, using its sportId
	 * 
	 * @param sportId
	 * @return sport (if it is found) or null (if it is not found)
	 */

	public Sports findBysportId(String sportId) {
		Optional<Sports> sport = sportsRepository.findBysportId(sportId);
		if (sport.isPresent()) {
			return sport.get();
		} else {
			return null;
		}
	}

	/**
	 * Find and retrieve all the sports from the database
	 * 
	 * @return List<Sports>
	 */

	public List<Sports> findAll() {
		return sportsRepository.findAll();
	}
}
