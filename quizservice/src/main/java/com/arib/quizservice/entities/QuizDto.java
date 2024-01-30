package com.arib.quizservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class QuizDto {
	String category;
	int num;
	String title;
}
