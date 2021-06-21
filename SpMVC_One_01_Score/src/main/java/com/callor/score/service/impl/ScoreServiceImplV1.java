package com.callor.score.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.callor.score.model.ScoreDTO;
import com.callor.score.model.ScoreVO;
import com.callor.score.persistance.ScoreVDao;
import com.callor.score.service.ScoreService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("scoreServiceV1")
public class ScoreServiceImplV1 implements ScoreService{

	protected final ScoreVDao scoreVDao;
	
	public ScoreServiceImplV1(ScoreVDao scoreVDao) {
		this.scoreVDao = scoreVDao;
	}
	
	@Override
	public List<ScoreDTO> scoreView() {
		// TODO 성적정보 view 조회
		List<ScoreDTO> sdList = scoreVDao.selectALL();

		return sdList;
	}

	@Override
	public List<ScoreVO> scoreList(String pk) {
		// TODO 개인 성적 조회
		
		return null;
	}

	@Override
	public int insert(ScoreVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
