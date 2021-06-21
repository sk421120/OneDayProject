package com.callor.score.persistance.impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.callor.score.model.ScoreDTO;
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
		String sql = "SELECT * FROM tbl_student ";
		sql += "WHERE st_num = ? ";
		
		return jdbcTemplate.queryForObject(sql, new Object[] { pk },
				new BeanPropertyRowMapper<StudentVO>(StudentVO.class));
	}

	@Override
	public int insert(StudentVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(StudentVO vo) {
		// TODO 학생정보 수정
		String sql = " UPDATE tbl_student SET ";
		sql += "st_name = ? ,";
		sql += "st_dept = ? ,";
		sql += "st_grade = ? ,";
		sql += "st_tel = ? ,";
		sql += "st_addr = ? ";
		sql += "WHERE st_num = ? ";
		
		Object[] params = new Object[] {
				vo.getSt_name(),
				vo.getSt_dept(),
				vo.getSt_grade(),
				vo.getSt_tel(),
				vo.getSt_addr(),
				vo.getSt_num()
		};
		
		return jdbcTemplate.update(sql, params);
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

		return jdbcTemplate.queryForObject(sql, String.class);
	}

}
