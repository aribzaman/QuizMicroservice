package com.arib.quizservice.services;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import com.arib.quizservice.dto.Response;
import com.arib.quizservice.exception.BadRequestException;
import com.arib.quizservice.exception.ResourceNotFoundException;
import com.arib.quizservice.projections.QuestionIdListProjection;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.arib.quizservice.dao.QuizDao;
import com.arib.quizservice.dto.QuestionsEntityWrapper;
import com.arib.quizservice.dto.QuizDto;
import com.arib.quizservice.entities.QuizEntity;
import com.arib.quizservice.feign.QuizInterface;

@Service
@RequiredArgsConstructor
public class QuizService {

	final QuizDao quizDao;
	final QuizInterface quizInterface;

	public List<QuizEntity> findAll() {
		return quizDao.findAll();
	}

	public QuizEntity findById(int id) {
		return quizDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("No Quiz found for quiz id: " + id));
	}

	public void createQuizByReq(QuizDto quiz) {
		int num = quiz.getNum();
		String category = quiz.getCategory();
		String title = quiz.getTitle();
		List<Integer> questionIds = quizInterface.generateQuestions(category, num);
		quizDao.save(new QuizEntity(title, category, num, questionIds));
	}

	public List<QuestionsEntityWrapper> getQuestionsByQuizId(Integer quizId) {
		QuizEntity quiz = findById(quizId);
		List<Integer> questionlist = quiz.getQuestions();
		return quizInterface.getQuestionsByIds(questionlist);
	}

	public Integer calculate(int quizId, List<Response> response) {

		responseVerificationWithReceivedQuiz(quizId, response);

		//Delegates work of calculation of score to Question Service
		return quizInterface.calculate(response);
	}

	private void responseVerificationWithReceivedQuiz(int quizId, List<Response> response) {
		Collections.sort(response);

		// Fetches all the question ids of the given Quiz id to verify if same questions are responded or not
		List<QuestionIdListProjection> qIdAbstraction = quizDao.getQuestionIdsOfQuiz(quizId);
		List<Integer> questionIdListFromDb = qIdAbstraction.stream().map(qId -> qId.getQuestions().get(0)).toList();

		//Throws Error if Number of questions responded is greater than or less than number of questions in given Quiz id
		if (response.size() < questionIdListFromDb.size())
			throw new BadRequestException("Not All Questions are responded to.");

		if (response.size() > questionIdListFromDb.size())
			throw new BadRequestException("Extra Questions present in response that are not found in this quiz.");


		//Throws error if any question in response does not belong ot the current quiz
		IntStream.range(0, response.size())
				.forEach(i -> {
					if (!questionIdListFromDb.get(i).equals(response.get(i).getId()))
						throw new BadRequestException("Question with Question-id: " + response.get(i).getId() +
								" doesn't belong to quiz: " + quizId);
				});
	}
}