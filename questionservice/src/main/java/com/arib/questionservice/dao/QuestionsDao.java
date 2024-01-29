package com.arib.questionservice.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.arib.questionservice.entities.QuestionsEntity;


@Repository
public interface QuestionsDao extends JpaRepository<QuestionsEntity, Integer>{

	List<QuestionsEntity> findByQuestioncategory(String categ);
		
	@Query(value="SELECT q.ques_id FROM questions q where q.questioncategory=:category ORDER BY rand() LIMIT :num", nativeQuery=true)
	List<Integer> getRandomQuestionsByCategory(String category, int num);
		
}
