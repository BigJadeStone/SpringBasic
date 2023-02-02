package com.simple.command;

public class Quiz01VO {
	
	private String year;
	private int month;
	private int day;
	
	Quiz01VO(){}
	
	Quiz01VO(String year, int month, int day){
		this.year = year;
		this.month = month;
		this.day = day;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	@Override
	public String toString() {
		return "Quiz01VO [year=" + year + ", month=" + month + ", day=" + day + "]";
	}
	
	
	
	
	

}
