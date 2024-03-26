package com.arib.quizservice.feign;

import java.util.List;

import com.arib.quizservice.dto.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.arib.quizservice.dto.QuestionsEntityWrapper;

@FeignClient(value = "QUESTIONSERVICE", path = "api/v1/questions")
public interface QuizInterface {

	// Generate n random question ids of given category
	@GetMapping("/generate")
	public List<Integer> generateQuestions(@RequestParam String category, @RequestParam Integer num);

	// Get Question Wrapper for given question id(s)
	@GetMapping("/by-ids")
	public List<QuestionsEntityWrapper> getQuestionsByIds(@RequestParam List<Integer> ids);

	@PostMapping("/score")
	public int calculate(@RequestBody List<Response> response);

}
