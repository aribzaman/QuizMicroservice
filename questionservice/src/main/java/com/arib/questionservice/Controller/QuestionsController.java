package com.arib.questionservice.Controller;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import org.hibernate.validator.constraints.Range;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.arib.questionservice.entities.QuestionsEntity;
import com.arib.questionservice.dto.QuestionsEntityWrapper;
import com.arib.questionservice.dto.Response;
import com.arib.questionservice.services.QuestionsService;

@RestController
@RequestMapping("api/v1/questions")
@CrossOrigin
@AllArgsConstructor
@Validated
public class QuestionsController {

	QuestionsService questionService;

	@GetMapping
	public List<QuestionsEntity> getAllQuestions() {
		return questionService.getAllQuestions();
	}

	@GetMapping("/{id}")
	public QuestionsEntity getQuestionById(@PathVariable @Positive Integer id) {
		return questionService.findById(id);
	}

	@GetMapping("/category/{categoryName}")
	public List<QuestionsEntity> getQuestionByQuizCategory(@PathVariable @NotBlank String categoryName) {
		return questionService.findByQuestionCategory(categoryName);
	}

	@PostMapping
	public ResponseEntity<?> addQuestions(@RequestBody @Valid QuestionsEntity question) {
		questionService.save(question);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public void deleteQuestion(@PathVariable @Positive Integer id) {
			questionService.deleteById(id);
	}

	//Generate N ids for the given Category of Questions
	@GetMapping("generate")
	public List<Integer> generateQuestions(@RequestParam @NotBlank String category, @RequestParam @Range(min = 1, max = 200) Integer num) {
			return questionService.generateQuestions(category, num);
	}

	// Get Wrapped questions[question+options] of requested question id(s)
	@GetMapping("/by-ids")
	public List<QuestionsEntityWrapper> getQuestionsByIds(@RequestParam @NotEmpty List<Integer> ids) {
		return questionService.getQuestionsByIds(ids);
	}

	//Calculates Score for the given responses
	@PostMapping("/score")
	public int calculate(@RequestBody @NotEmpty List<Response> response) {
		return questionService.calculate(response);
	}

}
