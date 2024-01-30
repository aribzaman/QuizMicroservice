package com.arib.quizservice.Controller;

import java.util.List;

import com.arib.quizservice.entities.QuestionsEntityWrapper;
import com.arib.quizservice.entities.QuizDto;
import com.arib.quizservice.entities.QuizEntity;
import com.arib.quizservice.entities.Response;
import com.arib.quizservice.services.QuizService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("quiz")
@AllArgsConstructor
public class QuizController {

	QuizService quizService;

	// GET all quizes
	@GetMapping
	public List<QuizEntity> getAll() {
		return quizService.findAll();
	}

	// GET a quiz by primary id
	@GetMapping("/{id}")
	public ResponseEntity<Object> getQuizById(@PathVariable int id) {
		try {
			return new ResponseEntity<>(quizService.findById(id),HttpStatus.OK);
		}
		catch(Exception e){
			e.printStackTrace();
			return new ResponseEntity<>("unsuccess",HttpStatus.BAD_REQUEST);
		}
	}

	// ADD a new quiz (by request body)
	@PostMapping
	public ResponseEntity<String> createQuiz(@RequestBody QuizDto quiz) {
		try {
			quizService.createQuizByReq(quiz);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok().body("{\"message\":\"error\"}");
		}
		return ResponseEntity.ok().body("{\"message\":\"success\"}");
	}

	//GET Questions of a quiz by its Quiz id
	@GetMapping("/questions/{id}")
	public ResponseEntity<List<QuestionsEntityWrapper>> getQuestionsByQuizId(@PathVariable int id) {
		try {
			return quizService.getQuestionsByQuizId(id);
		}
		catch(Exception e){
			e.printStackTrace();
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}
	}
	
	//Calculate Score for responses
	@PostMapping("/score/{quizid}")
	public ResponseEntity<Integer> calculate(@PathVariable int quizid, @RequestBody List<Response> response)
	{
		return quizService.calculate(quizid,response);
	}

}
