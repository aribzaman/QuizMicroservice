package com.arib.quizservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.arib.quizservice.entities.QuizEntity;

public interface QuizDao extends JpaRepository<QuizEntity, Integer> {

}
