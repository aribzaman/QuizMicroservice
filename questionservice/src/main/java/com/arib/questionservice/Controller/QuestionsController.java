package com.arib.questionservice.Controller;

import java.util.List;
import java.util.Optional;

import lombok.AllArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("questions")
@CrossOrigin
@AllArgsConstructor
public class QuestionsController {

	Environment environment;
	QuestionsService questionService;

	@GetMapping
	public List<QuestionsEntity> getAllQuestions() {
		return questionService.getAllQuestions();
	}

	// get a question by id
	@GetMapping("/{id}")
	public Optional<QuestionsEntity> getQuestion(@PathVariable int id) {
		return questionService.findById(id);
	}

	// get all questions by category name
	@GetMapping("/category/{categ}")
	public List<QuestionsEntity> getQuestionByQuizCategory(@PathVariable String categ) {
		return questionService.findByQuestionCategory(categ);
	}

	// Add a New Question
	@PostMapping
	public ResponseEntity<Object> addQuestions(@RequestBody QuestionsEntity ques) {
		try {
			questionService.save(ques);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok().body("{\"message\":\"error\"}");
		}
		return ResponseEntity.ok().body("{\"message\":\"success\"}");
	}

	// DELETE Question by id
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteQuestion(@PathVariable int id) {
		try {
			questionService.deleteById(id);
		} catch (Exception e) {
			return ResponseEntity.ok().body("{\"message\":\"error\"}");
		}
		return ResponseEntity.ok().body("{\"message\":\"success\"}");
	}

	// Generate Questions for quiz creation category num
	@GetMapping("generate")
	public ResponseEntity<List<Integer>> generateQuestions(@RequestParam String category, @RequestParam Integer num) {
		try {
			return ResponseEntity.ok().body(questionService.generateQuestions(category, num));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(null);
		}
	}

	// Get Wrapped questions[question+options] through their id(s)
	@PostMapping("getids")
	public ResponseEntity<List<QuestionsEntityWrapper>> getQuestionsByIds(@RequestBody List<Integer> ids) {
		System.out.println(environment.getProperty("local.server.port"));
		return questionService.getQuestionsByIds(ids);
	}

	@PostMapping("/score")
	public ResponseEntity<Integer> calculate(@RequestBody List<Response> response) {
		return questionService.calculate(response);
	}

}
