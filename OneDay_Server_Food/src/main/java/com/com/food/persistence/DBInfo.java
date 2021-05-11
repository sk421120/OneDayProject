package com.com.food.persistence;

public class DBInfo {
	public static class FOODS {
		public static final String f_code = "식품코드";
		public static final String f_name = "식품명";
		public static final String f_date = "출시일";
		public static final String f_ccode = "제조사코드";
		public static final String f_icode = "분류코드";
		public static final String f_serv = "1회제공량";
		public static final String f_cap = "총내용량";
		public static final String f_energy = "에너지";
		public static final String f_protein = "단백질";
		public static final String f_fat = "지방";
		public static final String f_carbo = "탄수화물";
		public static final String f_sugar = "총당류"; 
	}
	
	public static class MYFOODS {
		public static final String m_seq = "구분";
		public static final String m_date = "날짜";
		public static final String m_fcode = "식품코드";
		public static final String m_intake = "섭취량";
	}
	
	public static class DAILYFOOD {
		public static final String m_seq = "구분";
		public static final String m_date = "날짜";
		public static final String f_name = "식품명";
		public static final String m_intake = "섭취량";
		public static final String f_cap = "총내용량";
		public static final String f_energy = "에너지";
		public static final String f_protein = "단백질";
		public static final String f_fat = "지방";
		public static final String f_carbo = "탄수화물";
		public static final String f_sugar = "총당류"; 
	}
}
