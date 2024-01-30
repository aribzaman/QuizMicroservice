package com.arib.quizservice.services;

import java.util.List;

import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class QuizService {

	QuizDao quizDao;
	QuizInterface quizInterface;

	public List<QuizEntity> findAll() {
		return quizDao.findAll();
	}

	public QuizEntity findById(int id) {
		return quizDao.findById(id).get();
	}
	
	public ResponseEntity<String> createQuizByReq(QuizDto quiz) {
		int num= quiz.getNum();
		String category=quiz.getCategory();
		String title=quiz.getTitle();

		List<Integer> questionids= quizInterface.createQuiz(category, num).getBody();
		
		QuizEntity quizz=new QuizEntity(title,category,num,questionids);
		quizDao.save(quizz);
		
		return new ResponseEntity<>("Successfully Created",HttpStatus.CREATED);
	}

	public ResponseEntity<List<QuestionsEntityWrapper>> getQuestionsByQuizId(int id) {

		QuizEntity quiz = quizDao.findById(id).get();
		List<Integer> questionlist= quiz.getQuestions();
		List<QuestionsEntityWrapper> questionListForUser = quizInterface.getQuestionsByIds(questionlist).getBody();
		return new ResponseEntity<>(questionListForUser,HttpStatus.OK);
	}

	public ResponseEntity<Integer> calculate(int quizid, List<Response> response) {
		Integer score = quizInterface.calculate(response).getBody();
		return new ResponseEntity<>(score,HttpStatus.OK);
	}

}
