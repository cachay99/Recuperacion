package es.salesianos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import es.salesianos.model.Character;
import es.salesianos.service.CharacterService;
import es.salesianos.service.Service;

@Controller
public class UpdateCharacterController{
	
	@Autowired
	@Qualifier("characterService")
	Service<Character> service = new CharacterService();

	@PostMapping(path="/updateCharacter")
	public String updateCharacter(@ModelAttribute Character character) {
		service.update(character);
		return "ListCharacters";
	}
	@GetMapping(path="/updateCharacter")
	public ModelAndView getupdateCharacterPage(@ModelAttribute Character character) {
		ModelAndView model = new ModelAndView("updateCharacter");
		model.addObject("character", character);
		return model;
	}

}