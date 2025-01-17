package es.salesianos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import es.salesianos.model.Character;
import es.salesianos.service.Service;

@Controller
public class UpdateController{
	
	@Autowired
	ListController controller;
	
	@Autowired
	@Qualifier("characterService")
	Service<Character> service;

	@GetMapping("/updateCharacter")
	protected ModelAndView editCharacter(@RequestParam("id") Integer idCharacter) {
		ModelAndView model = new ModelAndView("updateCharacter");
		Character character = service.listById(idCharacter);
		model.addObject("character", character);
		return model;
	}
	
	@PostMapping(path="/updateCharacter")
	protected ModelAndView updateCharacter(@ModelAttribute Character character) {
		service.update(character);
		return controller.listAllCharacters();
	}

}
