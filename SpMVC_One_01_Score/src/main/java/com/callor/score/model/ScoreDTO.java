package com.callor.score.model;

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
public class ScoreDTO {
	private String st_num;
	private String	st_name;
	private String st_dept;
	private int st_grade = 0;
	private int st_subcount = 0;
	private int st_total = 0;
	private float st_avg = 0;
}
