package es.salesianos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.salesianos.model.Character;
import es.salesianos.model.Race;
import es.salesianos.service.Service;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping(value = "/api/v1")
public class ListController{

	@Autowired
	@Qualifier("characterService")
	private Service<Character> characterService;
	
	@Autowired
	@Qualifier("raceService")
	private Service<Race> raceService;

	@PostMapping(path = "/listcharacters")
	protected ResponseEntity<List<Character>> listAllCharacters() {
		List<Character> characters = characterService.listAll();
		return new ResponseEntity<>(characters, HttpStatus.OK);
	}
	
	@PostMapping(path = "/listraces")
	protected ResponseEntity<List<Race>> listAllRaces() {
		List<Race> races = raceService.listAll();
		return new ResponseEntity<>(races, HttpStatus.OK);
	}
	
}