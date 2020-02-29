package es.salesianos.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping(value = "/api/v1")
public class IndexController {
	
	@GetMapping(path="index")
	public String getIndexPage() {
		return "index";
	}
	
	@GetMapping(path = "/listcharacters")
	public String getListCharacterPage() {
		return "ListCharacters";
	}
	
	@GetMapping(path = "/listraces")
	public String getListRacePage() {
		return "ListRaces";
	}
}
