package com.arib.quizservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class QuestionsEntityWrapper {
	int ques_id;
	String questiontext;
	String option1;
	String option2;
	String option3;
	String option4;
}
