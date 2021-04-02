package com.caller.score.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.caller.score.model.ScoreVO;

public class ScoreServiceV1 {
	
	protected Scanner scan;
	protected List<ScoreVO> scoreList;
	
	public ScoreServiceV1() {
		scan = new Scanner(System.in);
		scoreList = new ArrayList<ScoreVO>();
	}
	
	public void selectMenu() {
		System.out.println("=".repeat(50));
		System.out.println("빛고을 고등학교 성적처리 프로젝트 2021");
		System.out.println("=".repeat(50));
		System.out.println("1. 학생별 성적 입력");
		System.out.println("2. 학생 성적 리스트 출력");
		System.out.println("QUIT. 업무종료");
		System.out.println("=".repeat(50));
		System.out.println("");
	}
	
	public void inputScore() {
		
	}

}
