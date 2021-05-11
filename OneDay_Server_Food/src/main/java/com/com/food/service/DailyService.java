package com.com.food.service;

import java.util.List;

import com.com.food.model.DailyFoodDTO;
import com.com.food.model.MyFoodsVO;

public interface DailyService {

	public List<DailyFoodDTO> selectAll();
	public DailyFoodDTO selectBySeq(int m_seq);
	public List<DailyFoodDTO> selectByDate(String m_date);
	
	public int insert(MyFoodsVO mfVO);
}
