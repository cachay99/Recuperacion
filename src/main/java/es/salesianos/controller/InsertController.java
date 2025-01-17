package es.salesianos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import es.salesianos.model.Character;
import es.salesianos.model.Race;
import es.salesianos.service.Service;

@Controller
public class InsertController {

	@Autowired
	@Qualifier("characterService")
	private Service<Character> characterService; 
	
	@Autowired
	@Qualifier("raceService")
	private Service<Race> raceService;

	@PostMapping(path="/insertCharacter")
	public String insertCharacter(Character character)  {
		characterService.insert(character);
		return "welcomeCharacter";
	}
	
	@PostMapping(path="/insertRace")
	public String insertRace(Race race)  {
		raceService.insert(race);
		return "welcomeRace";
	}

}
