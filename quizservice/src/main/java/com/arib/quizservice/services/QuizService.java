package com.arib.quizservice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.arib.quizservice.dao.QuizDao;
import com.arib.quizservice.entities.QuestionsEntityWrapper;
import com.arib.quizservice.entities.QuizDto;
import com.arib.quizservice.entities.QuizEntity;
import com.arib.quizservice.entities.Response;
import com.arib.quizservice.feign.QuizInterface;

@Service
public class QuizService {
	
	@Autowired
	QuizDao quizd;
	
	@Autowired
	QuizInterface quizinterface;
	
	public ResponseEntity<String> createQuizByReq(QuizDto quiz) {
		int num= quiz.getNum();
		String category=quiz.getCategory();
		String title=quiz.getTitle();

		List<Integer> questionids= quizinterface.createQuiz(category, num).getBody(); //use getBody() to fetch body of ResponseEntity i.e. Questions.
		
		QuizEntity quizz=new QuizEntity();
		quizz.setTitle(title);
		quizz.setQuestions(questionids);
		quizz.setCategory(category);
		quizz.setNum(num);
		quizd.save(quizz);
		
		return new ResponseEntity<>("Successfully Created",HttpStatus.CREATED);
	}

	public ResponseEntity<List<QuestionsEntityWrapper>> getQuestionsByQuizId(int id) {

		QuizEntity quiz = quizd.findById(id).get();
		List<Integer> questionlist= quiz.getQuestions();
		List<QuestionsEntityWrapper> questionListForUser = quizinterface.getQuestionsByIds(questionlist).getBody();
		return new ResponseEntity<>(questionListForUser,HttpStatus.OK);
	}

	public ResponseEntity<Integer> calculate(int quizid, List<Response> response) {
		Integer score = quizinterface.calculate(response).getBody();
		return new ResponseEntity<>(score,HttpStatus.OK);
	}
	
	

}
