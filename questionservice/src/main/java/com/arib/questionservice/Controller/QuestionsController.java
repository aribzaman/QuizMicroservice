package com.arib.questionservice.Controller;

import java.util.List;
import java.util.Optional;

import org.hibernate.boot.archive.scan.spi.ClassDescriptor.Categorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.arib.questionservice.dao.QuestionsDao;
import com.arib.questionservice.entities.QuestionsEntity;
import com.arib.questionservice.entities.QuestionsEntityWrapper;
import com.arib.questionservice.entities.Response;
import com.arib.questionservice.services.QuestionsService;

@RestController
@RequestMapping("questions")
@CrossOrigin
public class QuestionsController {

	@Autowired
	Environment environment;
	
	@Autowired
	QuestionsService quess;

	@Autowired
	QuestionsDao quesd;

	// default
	@GetMapping({ "", "/", "/home" })
	public String home() {
		return "Page Working Fine!";
	}

	// GET All Questions
	@GetMapping("/all")
	public List<QuestionsEntity> getAllQuestions() {
		return quess.getAllQuestions();
	}

	// get a question by prim. id (Through Dao)
	@GetMapping("/{id}")
	public Optional<QuestionsEntity> getQuestion(@PathVariable int id) {
		return quess.findById(id);
	}

	// get all questions by category name (Through service)
	@GetMapping("/category/{categ}")
	public List<QuestionsEntity> getQuestionByQuizCategory(@PathVariable String categ) {
		return quess.findByQuestionCategory(categ);
	}

	// ADD New Question
	@PostMapping(path = "/add", consumes = { "application/json" })
	public ResponseEntity<Object> addQuestions(@RequestBody QuestionsEntity ques) {
		try {
			quesd.save(ques);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok().body("{\"message\":\"error\"}");
		}
		return ResponseEntity.ok().body("{\"message\":\"success\"}");
	}

	// DELETE Question by prim. id
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteQuestion(@PathVariable int id) {
		try {
			quesd.deleteById(id);
		} catch (Exception e) {
			return ResponseEntity.ok().body("{\"message\":\"error\"}");
		}
		return ResponseEntity.ok().body("{\"message\":\"success\"}");
	}

	// Check if sending bad request works at frontend or not
//	@DeleteMapping("/delete/{id}")
//	public ResponseEntity<String> deleteQuestion(@PathVariable int id) {
//		try {
//			quesd.deleteById(id);
//			return new ResponseEntity<String>("{\"message\":\"success\"}", HttpStatus.OK);
//		} catch (Exception e) {
//			return ResponseEntity.badRequest().body("{\"message\":\"error\"}");
//		}
//	}

	// Generate Questions for quiz creation category num
	@GetMapping("create")
	public ResponseEntity<List<Integer>> createQuiz(@RequestParam String category, @RequestParam Integer num) {
		try {
			return ResponseEntity.ok().body(quess.createQuiz(category, num));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(null);
		}
	}

	// Get Wrapped questions[question+options] through their id(s)
	@PostMapping("getids")
	public ResponseEntity<List<QuestionsEntityWrapper>> getQuestionsByIds(@RequestBody List<Integer> ids) {
		System.out.println(environment.getProperty("local.server.port"));
		return quess.getQuestionsByIds(ids);
	}

	@PostMapping("/score")
	public ResponseEntity<Integer> calculate(@RequestBody List<Response> response) {
		return quess.calculate(response);
	}

}
