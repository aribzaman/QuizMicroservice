package com.arib.questionservice.entities;

import jakarta.persistence.Column;
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
@Table(name = "questions")
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
@Data
public class QuestionsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "quesId", nullable = false, unique = true)
	int ques_id;

	@Column(nullable = false)
	String questiontext;
	
	@Column(nullable = false)
	String questioncategory;
	
	String difficultylevel;
	String option1;
	String option2;
	String option3;
	String option4;
	String correct;
	String explanation;
}
