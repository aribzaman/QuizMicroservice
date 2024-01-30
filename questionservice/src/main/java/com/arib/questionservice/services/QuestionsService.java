package com.arib.questionservice.services;

import java.util.List;
import java.util.Optional;

import com.arib.questionservice.dto.QuestionMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.arib.questionservice.dto.QuestionsEntityWrapper;
import com.arib.questionservice.dto.Response;
import com.arib.questionservice.dao.QuestionsDao;
import com.arib.questionservice.entities.QuestionsEntity;

@Service
@AllArgsConstructor
public class QuestionsService {

	QuestionsDao questionDao;

	public List<QuestionsEntity> getAllQuestions() {
		return questionDao.findAll();
	}

	public Optional<QuestionsEntity> findById(int id) {
		return questionDao.findById(id);
	}

	public void save(QuestionsEntity ques) {questionDao.save(ques);}

	public void deleteById(int id) {questionDao.deleteById(id);}

	public List<QuestionsEntity> findByQuestionCategory(String categ) {
		return questionDao.findByQuestioncategory(categ);
	}

	public List<Integer> generateQuestions(String category, Integer num) {
        return questionDao.getRandomQuestionsByCategory(category, num);
	}

	public ResponseEntity<List<QuestionsEntityWrapper>> getQuestionsByIds(List<Integer> ids) {

		List<QuestionsEntity> questionlist = ids.stream()
				.map(id -> questionDao.findById(id).get())
				.toList();

		List<QuestionsEntityWrapper> questionListForUser = questionlist.stream()
				.map(new QuestionMapper())
				.toList();
		
		return new ResponseEntity<>(questionListForUser,HttpStatus.OK);
	}

	public ResponseEntity<Integer> calculate(List<Response> response) {

		int score=0;
		for(Response resp: response) {
			if(questionDao.findById(resp.getId()).get().getCorrect().equals(resp.getResponse())) {
				score++;
			}
		}
		return new ResponseEntity<>(score,HttpStatus.OK);
	}
}
