package com.com.food.service;

import java.util.List;

import com.com.food.model.FoodDTO;

public interface FoodService {
	
	public List<FoodDTO> selectAll();
	public FoodDTO selectByCode(String f_code);
	public List<FoodDTO> selectByName(String f_name);
	
}
