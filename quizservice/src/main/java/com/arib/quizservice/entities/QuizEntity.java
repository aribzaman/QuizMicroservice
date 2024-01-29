package com.arib.quizservice.entities;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "QuizTable")
@DynamicUpdate
public class QuizEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int quizid;
	String title;
	String category;
	int num;
	
	//@ManyToMany //for numbers or single things we can't use @manytomany because it is used with entities t1:32:00
	
	@ElementCollection
	List<Integer> questions;

	public QuizEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public QuizEntity(int quizid, String title, String category, int num, List<Integer> questions) {
		super();
		this.quizid = quizid;
		this.title = title;
		this.category = category;
		this.num = num;
		this.questions = questions;
	}

	public int getQuizid() {
		return quizid;
	}

	public void setQuizid(int quizid) {
		this.quizid = quizid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
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

	public List<Integer> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Integer> questions) {
		this.questions = questions;
	}

	@Override
	public String toString() {
		return "QuizEntity [quizid=" + quizid + ", title=" + title + ", category=" + category + ", num=" + num
				+ ", questions=" + questions + "]";
	}
	
	

}
