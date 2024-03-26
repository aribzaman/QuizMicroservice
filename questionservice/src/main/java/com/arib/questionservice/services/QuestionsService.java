package com.arib.questionservice.services;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

import com.arib.questionservice.dto.QuestionMapper;
import com.arib.questionservice.exception.BadRequestException;
import com.arib.questionservice.exception.ResourceNotFoundException;
import com.arib.questionservice.projections.CorrectAnswerListProjection;
import lombok.AllArgsConstructor;
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

	public QuestionsEntity findById(Integer id) {
		return questionDao.findById(id).orElseThrow(()-> new ResourceNotFoundException("No Question found for id " + id));
	}

	public void save(QuestionsEntity question) {questionDao.save(question);}

	public void deleteById(Integer id) {questionDao.deleteById(id);}

	public List<QuestionsEntity> findByQuestionCategory(String categoryName) {
		List<QuestionsEntity> listOfQuestions = questionDao.findByQuestioncategory(categoryName);
		if(listOfQuestions.isEmpty()) throw new BadRequestException("No category by name: " + categoryName);
		return listOfQuestions;
	}

	public List<Integer> generateQuestions(String category, Integer num) {
		List<Integer> questionIdList = questionDao.getRandomQuestionsByCategory(category, num);
		Collections.sort(questionIdList);
		if(questionIdList.isEmpty()) throw new BadRequestException("No category by name: " + category);
		else if(questionIdList.size() < num) throw new BadRequestException("Not enough questions in this category. Available questions: " + questionIdList.size());
        return questionIdList;
	}

	public List<QuestionsEntityWrapper> getQuestionsByIds(List<Integer> questionIdListFromUser) {

		List<QuestionsEntity> questionListFromDatabase = questionDao.findAllQuestionsByIdIn(questionIdListFromUser);

		if(questionListFromDatabase.size()<questionIdListFromUser.size()){
			throw new BadRequestException("Some Questions not available" );
		}

		return questionListFromDatabase.stream()
				.map(QuestionMapper::apply)
				.toList();
	}

	public int calculate(List<Response> response) {

		Collections.sort(response);

		//Extracting list of q.ids from User Response List
		List<Integer> questionIdListFromUser = response.stream()
				.map(Response::getId).toList();

		//Fetching the list of (q.id & it's Correct Answer) from the respective Q.Ids present in user response
		List<CorrectAnswerListProjection> calpAbstraction = questionDao.findAllByIdIn(questionIdListFromUser);

		checkForNonExistingQuestionsInDatabase(calpAbstraction, questionIdListFromUser);

		//Extracting list of responses from User Response
		List<String> questionResponseListFromUser = response.stream()
				.map(Response::getResponse).toList();

		//Extracting List of Correct Answers from List fetched from Database
		List<String> questionCorrectAnswerListFromDatabase = calpAbstraction.stream()
				.map(CorrectAnswerListProjection::getCorrect)
				.toList();

		// Filtering out null values and then counting the correctly answered questions
		return (int) IntStream.range(0, questionResponseListFromUser.size())
				.filter(i -> Objects.nonNull(questionResponseListFromUser.get(i)))
				.filter(i -> questionResponseListFromUser.get(i).equalsIgnoreCase(questionCorrectAnswerListFromDatabase.get(i)))
				.count();
	}

	private void checkForNonExistingQuestionsInDatabase(List<CorrectAnswerListProjection> calpAbstraction, List<Integer> questionIdListFromUser) {
		//Extracting list of q.ids from List fetched from Database
		List<Integer> questionIdListFromDatabase = calpAbstraction.stream()
				.map(CorrectAnswerListProjection::getId)
				.toList();

		//Accumulating QuestionsIds in response List that do not exist in db (if any)
		List<Integer> extraQuestionsList = questionIdListFromUser.stream()
				.filter(id -> !questionIdListFromDatabase.contains(id))
				.toList();
		String result = String.join(", ", extraQuestionsList.stream()
				.map(Object::toString).toArray(String[]::new));

		//Throw Error if any of the questions are missing in Database
		if(!extraQuestionsList.isEmpty()) throw new BadRequestException("Questions not Found In Database: " + result);
	}
}
