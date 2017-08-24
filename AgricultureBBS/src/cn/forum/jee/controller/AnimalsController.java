package cn.forum.jee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/animals")
public class AnimalsController {
	
	@RequestMapping(value = "/animalsList")
	public String animalsList(){
		return "animals/animalsList";
	}
	
	@RequestMapping(value = "/animalsContent")
	public String animalsContent(){
		return "animals/animalsContent";
	}
}
