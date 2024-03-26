package com.arib.questionservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionsEntityWrapper {

	int id;
	String questiontext;
	String option1;
	String option2;
	String option3;
	String option4;
	
}
