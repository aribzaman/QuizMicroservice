package com.arib.questionservice.dto;

import com.arib.questionservice.entities.QuestionsEntity;

public class QuestionMapper {

    private QuestionMapper(){}

    public static QuestionsEntityWrapper apply(QuestionsEntity q) {
        return new QuestionsEntityWrapper(q.getId(), q.getQuestiontext(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
    }
}
