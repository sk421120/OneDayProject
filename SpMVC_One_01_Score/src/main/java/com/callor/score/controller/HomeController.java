package com.callor.score.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.score.model.ScoreDTO;
import com.callor.score.service.ScoreService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
	
	protected ScoreService scService;
	public HomeController(ScoreService scService) {
		this.scService = scService;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		
		List<ScoreDTO> sdList = scService.scoreView();
		log.debug("Conroller {} " , sdList.toString());

		model.addAttribute("SCOREDTO", sdList);
	
//		return null;
		return "home";
	}
	
}
