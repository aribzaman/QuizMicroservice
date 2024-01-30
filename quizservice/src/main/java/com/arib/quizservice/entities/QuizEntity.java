package com.arib.quizservice.entities;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "QuizTable")
@DynamicUpdate
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuizEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int quizid;
	String title;
	String category;
	int num;

	@ElementCollection
	List<Integer> questions;

	public QuizEntity(String title, String category, int num, List<Integer> questions) {
		this.title = title;
		this.category = category;
		this.num = num;
		this.questions = questions;
	}
}
