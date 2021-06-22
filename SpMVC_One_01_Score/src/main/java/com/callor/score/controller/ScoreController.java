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
	
	@RequestMapping(value="/insert", method = RequestMethod.GET)
	public String insert(String st_num, Model model) {
		model.addAttribute("STNUM",st_num);
		return "stscore/input";
	}
	
	@RequestMapping(value="/insert", method = RequestMethod.POST)
	public String insert(String sc_stnum, String sc_subject, String sc_score) {
		ScoreVO vo = new ScoreVO();
//		set stnum	subject	score
//		서비스에서 maxnum 확인후 seq 추가
		scService.insert(vo);
		return "stscore/input";
	}
}
