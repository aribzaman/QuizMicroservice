package com.arib.quizservice.entities;

public class QuizDto {
	String category;
	int num;
	String title;
	
	public QuizDto(String category, int num, String title) {
		super();
		this.category = category;
		this.num = num;
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "QuizDto [category=" + category + ", num=" + num + ", title=" + title + "]";
	}
	
	
	
	
}
