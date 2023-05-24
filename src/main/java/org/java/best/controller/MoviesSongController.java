package org.java.best.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MoviesSongController {

	@GetMapping("/")
	public String getHome(Model model, @RequestParam(name = "name") String name) {
		
		model.addAttribute("name", name);
		
		return "home";
	}
	
}
