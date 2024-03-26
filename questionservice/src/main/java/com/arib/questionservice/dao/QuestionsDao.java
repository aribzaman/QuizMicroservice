package com.arib.questionservice.dao;

import java.util.List;

import com.arib.questionservice.projections.CorrectAnswerListProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.arib.questionservice.entities.QuestionsEntity;

@Repository
public interface QuestionsDao extends JpaRepository<QuestionsEntity, Integer>{

	List<QuestionsEntity> findByQuestioncategory(String category);

	//Using Native Query as "ORDER BY rand()" isn't supported by the query builder mechanism of JPA
	@Query(value="SELECT q.ques_id FROM questions q where q.questioncategory=:category ORDER BY rand() LIMIT :num", nativeQuery=true)
	List<Integer> getRandomQuestionsByCategory(String category, int num);

	List<QuestionsEntity> findAllQuestionsByIdIn(List<Integer> ids);

	List<CorrectAnswerListProjection> findAllByIdIn(@Param("ids") List<Integer> ids);
}
