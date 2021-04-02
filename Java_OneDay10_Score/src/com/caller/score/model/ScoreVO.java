package com.caller.score.model;

public class ScoreVO {
	
	protected String name;
	protected int intKor;
	protected int intEng;
	protected int intMath;
	protected int intScience;
	protected int intHistory;
	protected int intSum;
	protected float floatAvg;
	
	public int getIntScience() {
		return intScience;
	}
	public void setIntScience(int intScience) {
		this.intScience = intScience;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getIntKor() {
		return intKor;
	}
	public void setIntKor(int intKor) {
		this.intKor = intKor;
	}
	public int getIntEng() {
		return intEng;
	}
	public void setIntEng(int intEng) {
		this.intEng = intEng;
	}
	public int getIntSum() {
		return intSum;
	}
	public void setIntSum(int intSum) {
		this.intSum = intSum;
	}
	public float getFloatAvg() {
		return floatAvg;
	}
	public void setFloatAvg(float floatAvg) {
		this.floatAvg = floatAvg;
	}
	public int getIntMath() {
		return intMath;
	}
	public void setIntMath(int intMath) {
		this.intMath = intMath;
	}
	public int getIntHistory() {
		return intHistory;
	}
	public void setIntHistory(int intHistory) {
		this.intHistory = intHistory;
	}

}
