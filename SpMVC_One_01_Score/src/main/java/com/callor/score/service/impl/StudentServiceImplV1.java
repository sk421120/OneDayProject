package com.callor.score.service.impl;

import org.springframework.stereotype.Repository;

import com.callor.score.model.StudentVO;
import com.callor.score.persistance.StudentDao;
import com.callor.score.service.StudentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository("studentServiceV1")
public class StudentServiceImplV1 implements StudentService {
	

	protected final StudentDao stDao;

	public StudentServiceImplV1(StudentDao stDao) {
		this.stDao = stDao;
	}

	@Override
	public int insert(StudentVO stVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(StudentVO stVO) {
		// TODO Auto-generated method stub
		return 0;
	}

}
