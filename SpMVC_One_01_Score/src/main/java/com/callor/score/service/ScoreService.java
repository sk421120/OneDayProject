package com.callor.score.service;

import java.util.List;

import com.callor.score.model.ScoreDTO;
import com.callor.score.model.ScoreVO;

public interface ScoreService {

	public List<ScoreDTO> scoreView();
	public List<ScoreVO> scoreList(String pk);
	public ScoreDTO findById(String pk);

	public int insert(ScoreVO vo);
}
