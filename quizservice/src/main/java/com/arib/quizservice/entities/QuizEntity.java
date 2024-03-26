package com.arib.quizservice.entities;

import java.util.List;

import jakarta.persistence.*;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.Range;

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

	@Column(unique = true, nullable = false)
	String title;

	@Column(nullable = false)
	String category;

	@Column(nullable = false)
	@Range(min = 1, max =200)
	int num;

	@ElementCollection
	@NotEmpty
	List<Integer> questions;

	public QuizEntity(String title, String category, int num, List<Integer> questions) {
		this.title = title;
		this.category = category;
		this.num = num;
		this.questions = questions;
	}
}
