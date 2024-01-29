package com.arib.quizservice.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.arib.quizservice.dao.QuizDao;
import com.arib.quizservice.entities.QuestionsEntityWrapper;
import com.arib.quizservice.entities.QuizDto;
import com.arib.quizservice.entities.QuizEntity;
import com.arib.quizservice.entities.Response;
import com.arib.quizservice.services.QuizService;

@RestController
@RequestMapping("quiz")
public class QuizController {

	@Autowired
	QuizDao quizd;

	@Autowired
	QuizService quizs;

	// GET all quizes
	@GetMapping("/all")
	public List<QuizEntity> getAll() {
		return quizd.findAll();
	}

	// GET a quiz by primary id
	@GetMapping("/{id}")
	public ResponseEntity<Object> getQuizById(@PathVariable int id) {
		try {
			return new ResponseEntity<>(quizd.findById(id),HttpStatus.OK);
		}
		catch(Exception e){
			e.printStackTrace();
			return new ResponseEntity<>("unsuccess",HttpStatus.BAD_REQUEST);
		}
	}

	//---------------------- Additional methods for microservices

	// ADD a new quiz (by request body)
	@PostMapping(path = "/add")
	public ResponseEntity<String> createQuiz(@RequestBody QuizDto quiz) {
		//QuizDto[category,numQ,Title]
		try {
			quizs.createQuizByReq(quiz);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok().body("{\"message\":\"error\"}");
		}
		return ResponseEntity.ok().body("{\"message\":\"success\"}");
	}

	//GET Questions of a quiz by Quiz id
	@GetMapping("/questions/{id}")
	public ResponseEntity<List<QuestionsEntityWrapper>> getQuestionsByQuizId(@PathVariable int id) {
		try {
			return quizs.getQuestionsByQuizId(id);
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
		return quizs.calculate(quizid,response);
	}

}
