package es.salesianos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.salesianos.model.Character;
import es.salesianos.model.Race;
import es.salesianos.service.Service;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping(value = "/api/v1")
public class DeleteController {
	
	@Autowired
	@Qualifier("characterService")
	private Service<Character> characterService;
	
	@Autowired
	@Qualifier("raceService")
	private Service<Race> raceService;
	
	@GetMapping("/deleteCharacter")
	protected ResponseEntity deleteCharacter(@RequestParam("id") Integer idCharacter){
		characterService.delete(idCharacter);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@GetMapping("/deleteRace")
	protected ResponseEntity deleteRace(@RequestParam("id") Integer idRace){
		raceService.delete(idRace);
		return new ResponseEntity(HttpStatus.OK);
	}
}
