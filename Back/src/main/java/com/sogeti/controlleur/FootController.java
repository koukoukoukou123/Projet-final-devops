package com.sogeti.controlleur;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.sogeti.model.Championships;
import com.sogeti.model.Correspondances;
import com.sogeti.model.HeadToHead;
import com.sogeti.model.Participations;
import com.sogeti.model.Preferences;
import com.sogeti.model.TeamClassementAdd;
import com.sogeti.model.Teams;
import com.sogeti.service.ChampionshipService;
import com.sogeti.service.CorrespondancesService;
import com.sogeti.service.HeadToHeadService;
import com.sogeti.service.ParticipationService;
import com.sogeti.service.PreferencesService;
import com.sogeti.service.TeamService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/sport")
public class FootController {

	/* Request for the API FOOTBALL */
	@Autowired
	HeadToHeadService headtoheadservice;

	@PostMapping("/testapi")
	public String azazaz(@RequestBody HeadToHead headtohead) {
		try {
		return headtoheadservice.findAll(headtohead);
		}catch (Exception e) {
			throw new ResponseStatusException(
		              HttpStatus.BAD_REQUEST , "Problem to connect the server please try other teams", e);
		}
	}

	/* Request Teams */
	@Autowired
	TeamService teamservice;

	@PostMapping("/team")
	public List<Teams> back() {

		return teamservice.findAll();

	}
	
	@PutMapping("/addteam")
	public ResponseEntity<String> addteam(@RequestBody TeamClassementAdd teamtoadd) {
		System.out.println("je suis là");
		System.out.println(teamtoadd.getTeam());
		Teams team = new Teams(teamtoadd.getTeam());
		System.out.println(teamtoadd.getChampionship());
		Championships championship = new Championships(teamtoadd.getChampionship());
		teamservice.add(team);
		Participations participation = new Participations(championship,team,teamtoadd.getWin()*3 + teamtoadd.getDraw() ,teamtoadd.getWin(),teamtoadd.getDraw(),teamtoadd.getLose());
		System.out.println(participation.getDraw());
		System.out.println(participation.getLose());
		System.out.println(participation.getPoints());
		System.out.println(participation.getChampionship().getchampionshipName());
		System.out.println(participation.getTeam().getTeamName());
        participationservice.save(participation);
		 return ResponseEntity.ok("ajouter");
		
	}

	/* Request Participations */
	@Autowired
	ParticipationService participationservice;

	@PostMapping("/participation")
	public List<Participations> getteams() {

		return participationservice.findAll();

	}

	/* Request Championships */
	@Autowired
	ChampionshipService championshipservice;

	@PostMapping("/championship")
	public List<Championships> getchampionship() {

		return championshipservice.findAll();

	}

	/* Request Correspondances */
	@Autowired
	CorrespondancesService correspondanceservice;

	@PostMapping("/testallcorrespondances")
	public List<Correspondances> backRequestAllCorrespondances() {
		return correspondanceservice.findAll();
	}

	/* Request Preferences */
	@Autowired
	PreferencesService preferenceservice;

	@PostMapping("/testallpref")
	public List<Preferences> backRequestPrefAllUser() {
		return preferenceservice.findAll();
	}
}
