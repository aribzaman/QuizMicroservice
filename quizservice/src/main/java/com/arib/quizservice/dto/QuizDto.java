package com.arib.quizservice.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

@Data
@AllArgsConstructor
public class QuizDto {

	@NotBlank
	String category;

	@Range(min=1, max=200)
	int num;

	@NotBlank
	String title;
}
