package com.callor.score.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.score.model.ScoreDTO;
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
	public String view(String st_num) {
		
		ScoreDTO scDTO = scService.findById(st_num);
		// scoredto 받고
		// scorevo list받고 세팅
		return "stscore/view";
	}
}
