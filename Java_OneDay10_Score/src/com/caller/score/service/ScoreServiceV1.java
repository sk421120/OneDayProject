package com.caller.score.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.caller.score.model.ScoreVO;

public class ScoreServiceV1 {

	protected Scanner scan;
	protected List<ScoreVO> scoreList;

	protected int[] intSum;
	protected String[] strSub;

	protected int intTotal;
	protected float floatTotalAvg;

	public ScoreServiceV1() {
		scan = new Scanner(System.in);
		scoreList = new ArrayList<ScoreVO>();
		intSum = new int[5];
		strSub = new String[] { "국어", "영어", "수학", "과학", "국사" };

		intTotal = 0;
		floatTotalAvg = 0;
	}

	public void selectMenu() {
		// TODO 메뉴 출력하기
		while (true) {
			int menu = 0;
			System.out.println("=".repeat(70));
			System.out.println("빛고을 고등학교 성적처리 프로젝트 2021");
			System.out.println("=".repeat(70));
			System.out.println("1. 학생별 성적 입력");
			System.out.println("2. 학생 성적 리스트 출력");
			System.out.println("QUIT. 업무종료");
			System.out.println("=".repeat(70));
			System.out.print("업무선택 >>");
			String strMenu = scan.nextLine();
			if (strMenu.equals("QUIT")) {
				break;
			}

			try {
				menu = Integer.valueOf(strMenu);
			} catch (Exception e) {
				System.out.println("\n\t* 메뉴를 다시 입력해주세요.\n");
				continue;
			}

			if (menu == 1) {
				// 성적입력
				this.inputScore();
			} else if (menu == 2) {
				// 리스트 출력
				printScore();
			} else {
				System.out.println("\n\t* 메뉴를 다시 입력해주세요.\n");
			}
		}
		System.out.printf("%d명의 학생 성적을 입력했습니다.\n", scoreList.size());
		System.out.println("업무를 종료합니다.");
	}

	public void inputScore() {
		// TODO 학생 성적 입력하기
		String strName = "";
		while (true) {
			System.out.println("=".repeat(70));
			System.out.println("학생이름을 입력하세요(입력을 중단하려면 QUIT)");
			System.out.println("=".repeat(70));
			System.out.print("이름 >> ");
			strName = scan.nextLine();
			if (strName.equals("QUIT")) {
				return;
			} else if (strName.equals("")) {
				System.out.println("\t* 다시 입력해주세요!");
				continue;
			}
			break;
		}
		Integer[] intScore = new Integer[5];
		System.out.println("=".repeat(70));
		System.out.printf("%s 학생의 성적을 입력하세요\n (성적범위 : 0 ~ 100, 입력을 중단하려면 QUIT)\n", strName);
		System.out.println("=".repeat(70));
		for (int i = 0; i < strSub.length; i++) {
			intScore[i] = this.inputScore(strSub[i]);
			if (intScore[i] == null) {
				return;
			}
		}

		this.printScoreOne(strName, intScore);
		
		ScoreVO vo = new ScoreVO();

		vo.setName(strName);
		vo.setIntKor(intScore[0]);
		vo.setIntEng(intScore[1]);
		vo.setIntMath(intScore[2]);
		vo.setIntScience(intScore[3]);
		vo.setIntHistory(intScore[4]);
		int sum = this.makeSum(intScore);
		vo.setIntSum(sum);
		vo.setFloatAvg(this.makeAvg(sum));

		scoreList.add(vo);

	}

	public Integer inputScore(String subject) {
		// TODO 성적 유효검사
		while (true) {
			Integer score = 0;
			System.out.printf("%s >> ", subject);
			String strScore = scan.nextLine();
			if (strScore.equals("QUIT")) {
				return null;
			}
			try {
				score = Integer.valueOf(strScore);
			} catch (Exception e) {
				System.out.println("\t* 정수 값을 입력해주세요!");
				continue;
			}

			if (score < 0 || score > 100) {
				System.out.println(" * 성적 범위는 0 ~ 100까지 입니다!");
				continue;
			}
			return score;
		}
	}

	private int makeSum(Integer[] intScore) {
		// TODO 학생별 총점 구하기
		int sum = 0;
		for (int i = 0; i < intScore.length; i++) {
			sum += intScore[i];
		}
		return sum;
	}

	private float makeAvg(int sum) {
		// TODO 학생별 평균 구하기
		return (float) sum / strSub.length;
	}

	private void makeTotal() {
		// TODO 전체 총점과 평균 구하기
		int[] score = new int[5];
		int total = 0;
		float avg = 0;
		for (int i = 0; i < scoreList.size(); i++) {
			ScoreVO vo = scoreList.get(i);
			score[0] += vo.getIntKor();
			score[1] += vo.getIntEng();
			score[2] += vo.getIntMath();
			score[3] += vo.getIntScience();
			score[4] += vo.getIntHistory();
			total += vo.getIntSum();
			avg += vo.getFloatAvg();
		}
		intTotal = total;
		intSum = score;
		floatTotalAvg = (float) avg / scoreList.size();
		
	}
	
	public void printScore() {
		// TODO 학생 성적 출력하기
		this.makeTotal();
		if (scoreList.size() == 0) {
			System.out.println("\n\t * 입력된 학생 성적이 없습니다.");
			System.out.println("\t메뉴에서 학생 성적을 추가해주세요!\n");
			return;
		}
		System.out.println("=".repeat(70));
		System.out.println("순번\t이름\t국어\t영어\t수학\t과학\t국사\t총점\t평균");
		System.out.println("-".repeat(70));
		for (int i = 0; i < scoreList.size(); i++) {
			ScoreVO vo = scoreList.get(i);
			System.out.printf("%2d\t%s\t%3d\t%3d\t%3d\t%3d\t%3d\t%4d\t%3.2f\n", i + 1, vo.getName(), vo.getIntKor(),
					vo.getIntEng(), vo.getIntMath(), vo.getIntScience(), vo.getIntHistory(), vo.getIntSum(),
					vo.getFloatAvg());
		}
		System.out.println("=".repeat(70));
		System.out.print("   총  점\t");
		for (int score : intSum) {
			System.out.printf("%3d\t", score);
		}
		System.out.printf("%4d\t%3.2f\n", intTotal, floatTotalAvg);
		System.out.println("=".repeat(70));
	}

	public void printScoreOne(String strName, Integer[] intScore) {
		// TODO 한명 성적 출력하기 
		System.out.println("=".repeat(70));
		System.out.printf("%s 학생의 성적이 추가되었습니다\n", strName);
		System.out.println("=".repeat(70));
		for (int i = 0; i < intScore.length; i++) {
			System.out.printf("%s : %d\n", strSub[i], intScore[i]);
		}
	}
}
