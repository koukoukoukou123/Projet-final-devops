package com.sogeti.service;

import org.springframework.stereotype.Service;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.sogeti.model.HeadToHead;
import com.mashape.unirest.http.HttpResponse;

@Service
public class HeadToHeadService {
	
/**
 * findAll method retrieves, thanks to the Football API,
 * all the last results of direct matches between the two teams,
 * as well as the last results of each team separately 
 * @param headtohead: object of the class HeadToHead, required to get the name of both teams
 * @return str : The body of the http response after being turn into string
 * @throws UnirestException 
 */
	public String findAll(HeadToHead headtohead) throws UnirestException 
	{
		String str = null;

		
			/* the URL of the Football API is composed the concatenation of 5 parts:
			* 1) "https://apiv2.apifootball.com/?action=get_H2H&firstTeam="
			* 2) headtohead.getEquipe1() //name of the 1st team
			* 3) "&secondTeam="
			* 4) headtohead.getEquipe2() //name of the 2nd team
			* 5) "&APIkey=472143ff03cfc2a6d7e22499c80e33feee56a32db55389b329233a696a76eca7"  //The API Key that we receive after creating an account on this API website
			*/
			HttpResponse<?> response = (HttpResponse<?>)Unirest.get("https://apiv2.apifootball.com/?action=get_H2H&firstTeam="+ headtohead.getEquipe1() + "&secondTeam="+ headtohead.getEquipe2() +"&APIkey=472143ff03cfc2a6d7e22499c80e33feee56a32db55389b329233a696a76eca7")
					   .header("Accept", "application/json")   
					   .asJson();
			str = response.getBody().toString();

		
		return str;
	}
	
}
