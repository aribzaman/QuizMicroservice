package com.arib.quizservice.dao;

import com.arib.quizservice.projections.QuestionIdListProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import com.arib.quizservice.entities.QuizEntity;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuizDao extends JpaRepository<QuizEntity, Integer> {

    @Query(value = "SELECT qeq.questions FROM Quiz_table qt\n" +
            "join quiz_entity_questions qeq\n" +
            "on qt.quizid = qeq.quiz_entity_quizid\n" +
            "where qt.quizid = :quizId order by qeq.questions asc", nativeQuery = true)
    List<QuestionIdListProjection> getQuestionIdsOfQuiz(int quizId);

}