package com.arib.questionservice.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.arib.questionservice.entities.QuestionsEntityWrapper;
import com.arib.questionservice.entities.Response;
import com.arib.questionservice.dao.QuestionsDao;
import com.arib.questionservice.entities.QuestionsEntity;


@Service
public class QuestionsService {

	@Autowired
	QuestionsDao quesd;

	public List<QuestionsEntity> getAllQuestions() {
		return quesd.findAll();
	}

	public List<QuestionsEntity> findByQuestionCategory(String categ) {
		return quesd.findByQuestioncategory(categ);
	}

	public Optional<QuestionsEntity> findById(int id) {
		return quesd.findById(id);
	}

	public List<Integer> createQuiz(String category, Integer num) {
		List<Integer> questionslist = quesd.getRandomQuestionsByCategory(category, num);	
		return questionslist;
	}

	public ResponseEntity<List<QuestionsEntityWrapper>> getQuestionsByIds(List<Integer> ids) {
		List<QuestionsEntity> questionlist= new ArrayList<>();
		List<QuestionsEntityWrapper> questionlistforuser= new ArrayList<>();
		for(Integer i: ids) {
			questionlist.add(quesd.findById(i).get());
		}

		for(QuestionsEntity q: questionlist) {
			QuestionsEntityWrapper qew = new QuestionsEntityWrapper(q.getQues_id(), q.getQuestiontext(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
			questionlistforuser.add(qew);
		}
		
		return new ResponseEntity<>(questionlistforuser,HttpStatus.OK);
	}

	public ResponseEntity<Integer> calculate(List<Response> response) {

		int score=0;		
//		for searching db without quiz id
		for(Response resp: response) {
			if(quesd.findById(resp.getId()).get().getCorrect().equals(resp.getResponse())) {
				score++;
			}
		}
		return new ResponseEntity<>(score,HttpStatus.OK);
	}
}
