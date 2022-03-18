package com.sogeti.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sogeti.model.Participations;
import com.sogeti.repository.ParticipationRepository;

@Service
public class ParticipationService {

	@Autowired
	ParticipationRepository participationRepository;

	/**
	 * Find and retrieve all the participations from the database
	 * 
	 * @return List<Participations>
	 */
	public List<Participations> findAll() {
		return participationRepository.findAll();
	}

	/**
	 * Insert and save a new participation inside the table of Participations in the
	 * DB
	 * 
	 * @param participation
	 */
	public void save(Participations participation) {
		participationRepository.save(participation);
	}

}
