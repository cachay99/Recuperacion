package es.salesianos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.salesianos.model.Character;
import es.salesianos.model.Race;
import es.salesianos.service.Service;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping(value = "/api/v1")
public class InsertController {

	@Autowired
	@Qualifier("characterService")
	private Service<Character> characterService; 
	
	@Autowired
	@Qualifier("raceService")
	private Service<Race> raceService;

	@PostMapping(path="/insertCharacter")
	public ResponseEntity insertCharacter(@RequestBody Character character)  {
		characterService.insert(character);
		return new ResponseEntity(character, HttpStatus.CREATED);
	}
	
	@PostMapping(path="/insertRace")
	public ResponseEntity<Race> insertRace(@RequestBody Race race)  {
		raceService.insert(race);
		return new ResponseEntity<>(race, HttpStatus.CREATED);
	}

}
