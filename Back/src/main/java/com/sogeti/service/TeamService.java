package com.sogeti.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sogeti.model.Teams;
import com.sogeti.repository.TeamRepository;

@Service
public class TeamService {

	@Autowired
	TeamRepository teamRepository;

	/**
	 * Find and retrieve one team from the Team table in the DB, using the team name
	 * 
	 * @param teamName
	 * @return team (if it was found) or null (if it wasn't found)
	 */
	public Teams findByteamName(String teamName) {
		Optional<Teams> team = teamRepository.findByteamName(teamName);
		if (team.isPresent()) {
			return team.get();
		} else {
			return null;
		}
	}

	/**
	 * Find and retrieve all the teams from the database
	 * 
	 * @return
	 */
	public List<Teams> findAll() {
		return teamRepository.findAll();
	}

	/**
	 * Insert and save a new team in the Team table in the DB
	 * 
	 * @param team
	 */
	public void add(Teams team) {
		teamRepository.save(team);
	}

}
