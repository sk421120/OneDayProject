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
public class FoodDTO {

	private String f_code;
	private String f_name;
	private int f_date = 0;
	private String f_ccode;
	private String f_icode;
	private int f_serv = 0;
	private int f_cap = 0;
	private int f_energy = 0;
	private int f_protein = 0;
	private int f_fat = 0;
	private int f_carbo = 0;
	private int f_sugar = 0;
}
