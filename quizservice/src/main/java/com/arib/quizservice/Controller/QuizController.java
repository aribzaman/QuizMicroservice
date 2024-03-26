package com.arib.quizservice.Controller;

import java.util.List;

import com.arib.quizservice.dto.QuestionsEntityWrapper;
import com.arib.quizservice.dto.QuizDto;
import com.arib.quizservice.dto.Response;
import com.arib.quizservice.entities.QuizEntity;
import com.arib.quizservice.services.QuizService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/quiz")
@RequiredArgsConstructor
@Validated
public class QuizController {

	final QuizService quizService;

	@GetMapping
	public List<QuizEntity> getAll() {
		return quizService.findAll();
	}

	@GetMapping("/{id}")
	public QuizEntity getQuizById(@PathVariable @Positive Integer id) {
			return quizService.findById(id);
	}

	//Creates a quiz by the given information {Category, Number of Questions, Title}
	@PostMapping
	public ResponseEntity<String> createQuiz(@RequestBody @Valid QuizDto quiz) {
		quizService.createQuizByReq(quiz);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@GetMapping("/{quizId}/questions")
	public List<QuestionsEntityWrapper> getQuestionsByQuizId(@PathVariable @Positive Integer quizId) {
		return quizService.getQuestionsByQuizId(quizId);
	}

	@GetMapping("/{quizId}/score")
	public Integer calculate(@PathVariable @Positive Integer quizId, @RequestBody @NotEmpty List<Response> response)
	{
		return quizService.calculate(quizId,response);
	}
}
