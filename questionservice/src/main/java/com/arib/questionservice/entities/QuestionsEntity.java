package com.arib.questionservice.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "questions")
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
@Data
public class QuestionsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "quesId", nullable = false, unique = true)
	int id;

	@NotBlank
	@Column(nullable = false)
	String questiontext;

	@NotBlank
	@Column(nullable = false)
	String questioncategory;

	@NotBlank
	String difficultylevel;

	@NotBlank
	@Column(nullable = false)
	private String option1;

	@NotBlank
	@Column(nullable = false)
	private String option2;

	@NotBlank
	@Column(nullable = false)
	private String option3;

	@NotBlank
	@Column(nullable = false)
	private String option4;

	@NotBlank
	private String correct;

	private String explanation;
}
