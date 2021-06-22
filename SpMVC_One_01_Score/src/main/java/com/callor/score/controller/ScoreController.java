package com.callor.score.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.score.model.ScoreDTO;
import com.callor.score.model.ScoreVO;
import com.callor.score.service.ScoreService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/stscore")
public class ScoreController {
	
	protected final ScoreService scService;
	public ScoreController(ScoreService scService) {
		this.scService = scService;
	}

	@RequestMapping(value={"/",""}, method = RequestMethod.GET)
	public String stscore() {
		return "stscore/list";
	}
	
	@RequestMapping(value="/view", method = RequestMethod.GET)
	public String view(String st_num, Model model) {
		
		ScoreDTO scDTO = scService.findById(st_num);
		List<ScoreVO> scList = scService.scoreList(st_num);
		
		// scoredto 받고 scorevo list받고 세팅
		model.addAttribute("SCOREDTO", scDTO);
		model.addAttribute("SCORELIST", scList);
		return "stscore/view";
	}
}
