package com.arib.quizservice.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.arib.quizservice.entities.QuestionsEntityWrapper;
import com.arib.quizservice.entities.Response;

@FeignClient("QUESTIONSERVICE") // this is the name of the instance present in the eureka server, //go to quizservice from here next(study)
public interface QuizInterface {

	//BELOW DATA IS TAKEN FROM QUESTIONSERVICE CONTTROLLER //addign questions/ before because as it was in controller
	
	// Generate Questions for quiz creation category num
	@GetMapping("questions/create")
	public ResponseEntity<List<Integer>> createQuiz(@RequestParam String category, @RequestParam Integer num);

	// Send questions for question id(s)
	@PostMapping("questions/getids")
	public ResponseEntity<List<QuestionsEntityWrapper>> getQuestionsByIds(@RequestBody List<Integer> ids);

	// Check for score after receiving response
	@PostMapping("questions/score")
	public ResponseEntity<Integer> calculate(@RequestBody List<Response> response);

}
