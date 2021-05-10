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
public class MyFoodsVO {
	
	private int m_seq = 0;
	private String m_date;
	private String m_fcode;
	private int m_intake = 0;
	
}
