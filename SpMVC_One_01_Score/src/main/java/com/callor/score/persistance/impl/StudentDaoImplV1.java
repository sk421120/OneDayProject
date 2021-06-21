package com.callor.score.persistance.impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.callor.score.model.StudentVO;
import com.callor.score.persistance.StudentDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository("studentDaoV1")
public class StudentDaoImplV1 implements StudentDao{
	protected final JdbcTemplate jdbcTemplate;

	public StudentDaoImplV1(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<StudentVO> selectALL() {
		// TODO 학생정보 전체 조회
		String sql = "SELECT * FROM tbl_student ";

		List<StudentVO> stList = jdbcTemplate.query(sql,
				new BeanPropertyRowMapper<StudentVO>(StudentVO.class));
		log.debug("studentVO select {}", stList.toString());
		return stList;
	}

	@Override
	public StudentVO findById(String pk) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(StudentVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(StudentVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String pk) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String findByMaxNum() {
		// TODO 학생정보에서 가장 큰 값 추출
		String sql = " SELECT MAX(st_num) FROM tbl_student ";

		String st_num = (String) jdbcTemplate.queryForObject(sql, String.class);
		return st_num;
	}

}
