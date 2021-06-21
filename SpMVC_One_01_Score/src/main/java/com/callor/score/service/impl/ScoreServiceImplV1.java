package com.callor.score.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.callor.score.model.ScoreDTO;
import com.callor.score.model.ScoreVO;
import com.callor.score.persistance.ScoreDao;
import com.callor.score.persistance.ScoreVDao;
import com.callor.score.service.ScoreService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("scoreServiceV1")
public class ScoreServiceImplV1 implements ScoreService{

	protected final ScoreVDao scoreVDao;
	protected final ScoreDao scoreDao;
	
	public ScoreServiceImplV1(ScoreVDao scoreVDao, ScoreDao scoreDao) {
		this.scoreVDao = scoreVDao;
		this.scoreDao =  scoreDao;
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
		return scoreDao.scoreListById(pk);
	}

	@Override
	public int insert(ScoreVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ScoreDTO findById(String pk) {
		// TODO 학번으로 학생 성적정보 조회
		return scoreVDao.findById(pk);
	}
	
}
