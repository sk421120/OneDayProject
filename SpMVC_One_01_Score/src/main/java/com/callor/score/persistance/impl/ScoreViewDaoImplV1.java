package com.callor.score.persistance.impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.callor.score.model.ScoreDTO;
import com.callor.score.persistance.ScoreVDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository("scoreviewDaoV1")
public class ScoreViewDaoImplV1 implements ScoreVDao{

	protected final JdbcTemplate jdbcTemplate;

	public ScoreViewDaoImplV1(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public List<ScoreDTO> selectALL() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM view_성적정보 ";

		List<ScoreDTO> scDTOList = jdbcTemplate.query(sql,
				new BeanPropertyRowMapper<ScoreDTO>(ScoreDTO.class));
		log.debug("scoredto select {}", scDTOList.toString());
		return scDTOList;
	}

	@Override
	public ScoreDTO findById(String pk) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(ScoreDTO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(ScoreDTO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String pk) {
		// TODO Auto-generated method stub
		return 0;
	}

}
