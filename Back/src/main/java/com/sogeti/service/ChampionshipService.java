package com.sogeti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sogeti.model.Championships;
import com.sogeti.repository.ChampionshipRepository;

@Service
public class ChampionshipService {

	@Autowired
	ChampionshipRepository championshipRepository;

	/**
	 * Find and retrieve all the championships from the database
	 * 
	 * @return List<Championships>
	 */

	public List<Championships> findAll() {
		return championshipRepository.findAll();
	}

}
