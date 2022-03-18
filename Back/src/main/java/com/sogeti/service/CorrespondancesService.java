package com.sogeti.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sogeti.model.Correspondances;
import com.sogeti.repository.CorrespondancesRepository;

@Service
public class CorrespondancesService {

	@Autowired
	CorrespondancesRepository correspondancesRepository;

	/**
	 * Find and retrieve one correspondance from the Correspondances table in the
	 * DB, using the championshipName
	 * 
	 * @param championshipName
	 * @return correspondance (if it was found) or null (if it wasn't found)
	 */
	public Correspondances findBychampionshipName(String championshipName) {
		Optional<Correspondances> correspondance = correspondancesRepository.findBychampionshipName(championshipName);
		if (correspondance.isPresent()) {
			return correspondance.get();
		} else {
			return null;
		}
	}

	/**
	 * Find and retrieve one correspondance from the Correspondances table in the
	 * DB, using the sportId
	 * 
	 * @param sportId
	 * @return correspondance (if it was found) or null (if it wasn't found)
	 */
	public Correspondances findBysportId(String sportId) {
		Optional<Correspondances> correspondance = correspondancesRepository.findBysportId(sportId);
		if (correspondance.isPresent()) {
			return correspondance.get();
		} else {
			return null;
		}
	}

	/**
	 * Find and retrieve all the correspondances from the database
	 * 
	 * @return List<Correspondances>
	 */

	public List<Correspondances> findAll() {
		return correspondancesRepository.findAll();
	}
}
