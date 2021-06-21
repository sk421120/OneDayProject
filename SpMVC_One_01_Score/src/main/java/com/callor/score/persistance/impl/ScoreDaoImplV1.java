package com.callor.score.persistance.impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.callor.score.model.ScoreVO;
import com.callor.score.persistance.ScoreDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository("scoreDaoV1")
public class ScoreDaoImplV1 implements ScoreDao{

	protected final JdbcTemplate jdbcTemplate;
	public ScoreDaoImplV1(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public List<ScoreVO> selectALL() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ScoreVO findById(String pk) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(ScoreVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(ScoreVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String pk) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ScoreVO> scoreListById(String pk) {
		// TODO 학번으로 학생 점수리스트 조회
		String sql = " SELECT * FROM tbl_score ";
		sql += " WHERE sc_stnum = ? ";
		
		return jdbcTemplate.query(sql, new Object[] { pk }, new BeanPropertyRowMapper<ScoreVO>(ScoreVO.class));
	}

}