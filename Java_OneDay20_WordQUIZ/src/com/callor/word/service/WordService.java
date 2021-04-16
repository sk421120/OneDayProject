package com.callor.word.service;

import com.callor.word.model.WordVO;

public interface WordService {

	public void selectMenu();
	public void loadWord();
	public void saveScore();
	public void loadScore();
	public void wordQuiz();
	public WordVO rndWord();
}
