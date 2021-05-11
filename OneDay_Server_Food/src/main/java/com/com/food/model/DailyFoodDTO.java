package com.com.food.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DailyFoodDTO {
	private int m_seq;
	private String m_date;
	private String f_name;
	private int m_intake = 0;
	private int f_cap = 0;
	private int f_energy = 0;
	private int f_protein = 0;
	private int f_fat = 0;
	private int f_carbo = 0;
	private int f_sugar = 0; 
}
