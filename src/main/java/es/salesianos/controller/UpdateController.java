package es.salesianos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.salesianos.model.Character;
import es.salesianos.service.Service;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping(value = "/api/v1")
public class UpdateController{
	
	@Autowired
	private ListController controller;
	
	@Autowired
	@Qualifier("characterService")
	private Service<Character> service;

	@GetMapping("/updateCharacter")
	protected ResponseEntity editCharacter(@RequestParam("id") Integer idCharacter) {
		Character character = service.listById(idCharacter);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@PostMapping(path="/updateCharacter")
	protected ResponseEntity<Character> updateCharacter(@RequestBody Character character) {
		service.update(character);
		return new ResponseEntity<>(character, HttpStatus.CREATED);
	}

}
