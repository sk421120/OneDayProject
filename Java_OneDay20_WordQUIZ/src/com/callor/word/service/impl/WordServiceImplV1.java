package com.callor.word.service.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.callor.word.model.UserVO;
import com.callor.word.model.WordVO;
import com.callor.word.service.WordService;
import com.sk421120.standard.MenuService;
import com.sk421120.standard.impl.MenuServiceImplV2;

public class WordServiceImplV1 implements WordService {

	protected List<WordVO> wordList;
	protected MenuService mService;
	protected FileWriter fWriter;
	protected FileReader fReader;
	protected PrintWriter pWriter;
	protected BufferedReader buffer;
	protected Random rnd;
	protected Scanner scan;
	protected UserVO vo;

	protected final Integer 영어 = 0;
	protected final Integer 한글 = 1;

	public WordServiceImplV1() {
		wordList = new ArrayList<WordVO>();
		rnd = new Random();
		scan = new Scanner(System.in);
		this.loadWord();
	}

	@Override
	public void selectMenu() {
		// TODO 메뉴 출력
		vo = new UserVO();
		vo.setScore(0);
		
		List<String> menu = new ArrayList<String>();
		menu.add("이어하기");
		menu.add("탐험하기");
		mService = new MenuServiceImplV2("\t**\t찾아라 [황금열쇠]\t**", menu);
		
		while (true) {
			Integer intM = mService.selectMenu();
			if (intM == null) {
				this.saveScore();
				System.out.println("=".repeat(50));
				System.out.println("\t** Bye~ Bye~~~ :)");
				return;
			}

			if (intM == 1) {
				this.loadScore();
			} else if (intM == 2) {
				this.wordQuiz();
			}
		}
	}

	@Override
	public void loadWord() {
		// TODO 영어 단어 불러오기 및 리스트 추가
		String fileName = "src/com/callor/word/word.txt";

		try {
			fReader = new FileReader(fileName);
			buffer = new BufferedReader(fReader);

			String read = new String();
			while ((read = buffer.readLine()) != null) {
				String[] words = read.split(":");

				WordVO wordVO = new WordVO();
				wordVO.setEnglish(words[영어]);
				wordVO.setMeaning(words[한글]);
				wordList.add(wordVO);
			}

			buffer.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void saveScore() {
		// TODO 점수 저장하기
		
		while (true) {
			System.out.println("=".repeat(50));
			System.out.println(" 저장할 파일 이름을 입력해주세요.");
			System.out.println(" ( 저장없이 종료 : QUIT )");
			System.out.print(" >> ");
			String name = scan.nextLine();
			
			if(name.equals("")) {
				System.out.println("\t** 파일 이름을 입력해주세요!");
				continue;
			}
			
			if (name.equals("QUIT")) {
				return;
			} else {
				this.saveScore(name);
				break;
			} 
		}

	}
	
	private void saveScore(String name) {
		String fileName = "src/com/callor/word/" + name + ".txt";
		
		try {
			fWriter = new FileWriter(fileName);
			pWriter = new PrintWriter(fWriter);

			pWriter.printf("%d", vo.getScore());

			pWriter.flush();
			pWriter.close();

			System.out.printf("\t%s 저장 완료!\n", name);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("** 파일 저장중에 오류가 발생했습니다!!!");
		}
		
	}

	@Override
	public void loadScore() {
		while (true) {
			// TODO 점수 불러오기
			System.out.println("=".repeat(50));
			System.out.println(" 불러올 파일 이름을 입력해주세요.");
			System.out.println(" ( 저장없이 종료 : QUIT )");
			System.out.print(" >> ");
			String name = scan.nextLine();
			if (name.equals("")) {
				System.out.println("\t** 파일 이름을 입력해주세요!");
				continue;
			}
			
			if (name.equals("QUIT")) {
				return;
			}
			
			String fileName = "src/com/callor/word/" + name + ".txt";
			
			try {
				fReader = new FileReader(fileName);
				buffer = new BufferedReader(fReader);

				String read = new String();

				while ((read = buffer.readLine()) != null) {
					Integer score = Integer.valueOf(read);
					vo.setScore(score);
				}

				System.out.println(name + " 불러오기 완료!");
				buffer.close();

			} catch (FileNotFoundException e) {
				System.out.printf("\t%s 파일을 불러 올 수 없습니다!\n", name);
				continue;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}

	}

	@Override
	public void wordQuiz() {
		// TODO 영어 단어 퀴즈

		int score = vo.getScore();
		if (score < 1) {
			score = 0;
			this.firstQuiz();
		}

		while (true) {
			WordVO quiz = this.rndWord();
			String[] words = quiz.getEnglish().split("");
			String[] rndWords = this.wordQuiz(words.clone());
			int tryCount = 0;
			int hintCount = 1;
			System.out.println("*".repeat(50));
			System.out.println("  * 종료 Quit  * 힌트 Hint  * 건너뛰기 Next");
			System.out.println("\t( 힌트와 건너뛰기는 포인트 -1)");
			System.out.println("*".repeat(50));
			while (tryCount < 4) {
				System.out.println(" 현재 점수 : " + score);
				System.out.println("=".repeat(50));
				System.out.println("\t[ " + quiz.getMeaning() + " ]");
				System.out.println("   뜻을 가진 단어는 무엇일까요?");
				System.out.println("-".repeat(50));
				System.out.println("\t" + Arrays.toString(rndWords));
				System.out.println("-".repeat(50));
				System.out.print(" >> ");
				String input = scan.nextLine();

				if (input.equals("Quit")) {
					vo.setScore(score);
					return;
				}

				if (input.equals("Hint")) {
					if (tryCount < 1) {
						System.out.println("\t* 힌트를 사용할 수 없습니다!");
					} else {
						score = this.hint(words, hintCount++, score);
					}
					continue;
				}

				if (input.equals("Next")) {
					System.out.println("\t* 다음 문제로 넘어갑니다!");
					score--;
					break;
				}

				tryCount++;
				if (input.equalsIgnoreCase(quiz.getEnglish())) {
					// 포인트 상승
					System.out.print("\t* 맞았습니다!");
					score = this.pointScore(score, tryCount);
					break;
				} else if (tryCount == 4) {
					System.out.println("\t* 재도전 기회를 다 소진했습니다.");
					System.out.println(quiz.getMeaning() + " 뜻을 가진 " + quiz.getEnglish() + " 입니다!");
				} else {
					System.out.printf("\n  * 다시 생각해보세요. %d번 기회가 남았습니다!\n\n", 4 - tryCount);
				}
			} // end while ()
		}

	}

	private int pointScore(int score, int count) {
		int point = (4 - count) * 2 + 1;
		System.out.printf(" * %d 점 획득!!\n", point);
		return score + point;
	}

	private int hint(String[] word, int nCount, int score) {
		// TODO 힌트 점수차감 및
		if (score < 1 || nCount > word.length) {
			System.out.println("힌트를 사용할 수 없습니다.");
			return score;
		}
		
		System.out.print("\t[");
		
		for (int i = 0; i < nCount; i++) {
			System.out.printf(" %s", word[i]);
		}
		nCount = word.length - nCount;
		
		for(int i = 0; i < nCount; i++) {
			System.out.print(" ?");
		}
		System.out.println(" ]");
		score--;
		return score;
	}

	private String[] wordQuiz(String[] word) {
		// TODO 문제 단어 배열 바꾸기
		for (int i = 0; i < word.length; i++) {
			int index = rnd.nextInt(word.length);

			String tmp = word[i];
			word[i] = word[index];
			word[index] = tmp;
		}

		return word;
	}

	private void firstQuiz() {
		// TODO 처음 사용하는 사람에게 나오는 멘트
		System.out.println("=".repeat(50));
		System.out.println("    괴도 뤼팡이 선물로 준 황금 금고를 풀 수 있는");
		System.out.println("\t  열쇠를 찾아서 황금부자가 되어보자!");
	}

	@Override
	public WordVO rndWord() {
		// TODO 무작위 단어 만들기
		int index = rnd.nextInt(wordList.size());

		return wordList.get(index);
	}

}
