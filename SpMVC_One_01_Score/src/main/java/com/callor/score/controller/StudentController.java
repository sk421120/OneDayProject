package com.callor.score.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.score.model.StudentVO;
import com.callor.score.service.StudentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/student")
public class StudentController {
	
	protected final StudentService stService;
	
	public StudentController(StudentService stService) {
		this.stService = stService;
	}

	@RequestMapping(value={"/",""}, method = RequestMethod.GET)
	public String student() {
		return "student/list";
	}
	
	@RequestMapping(value="/update", method = RequestMethod.GET)
	public String update(String st_num, Model model) {
		StudentVO stVO = stService.findById(st_num);
		model.addAttribute("STUDENT",stVO);
		return "student/update";
	}
}
